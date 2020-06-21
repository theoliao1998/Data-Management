package flightapp;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

import java.lang.Math;

/**
 * Runs queries against a back-end database
 */
public class Query {
  // DB Connection
  private Connection conn;

  // Password hashing parameter constants
  private static final int HASH_STRENGTH = 65536;
  private static final int KEY_LENGTH = 128;

  // Canned queries
  private static final String CHECK_FLIGHT_CAPACITY = "SELECT capacity FROM Flights WHERE fid = ?";
  private PreparedStatement checkFlightCapacityStatement;

  // For check dangling
  private static final String TRANCOUNT_SQL = "SELECT @@TRANCOUNT AS tran_count";
  private PreparedStatement tranCountStatement;

  // For table clearing
  private static final String CLEAR_SQL1 = "TRUNCATE TABLE RESERVATIONS";
  private static final String CLEAR_SQL2 = "DELETE FROM USERS";
  private static final String RESEED_SQL = "DBCC CHECKIDENT ('RESERVATIONS', RESEED, ?)";
  private PreparedStatement tableClearStatement1;
  private PreparedStatement tableClearStatement2;
  private PreparedStatement reseedStatement;

  // For login
  private static final String CHECK_USER_SQL = "SELECT password, salt FROM USERS WHERE username = ?";
  private PreparedStatement checkUserStatement;

  // For create user
  private static final String CREATE_USER_SQL = "INSERT INTO USERS (username, password, salt, balance) VALUES (?, ? , ? , ?)";
  private PreparedStatement createUserStatement;

  // For booking
  private static final String CHECK_SAME_DAY_SQL = "select count(*) as num from RESERVATIONS r JOIN FLIGHTS f ON r.flight_id1 = f.fid "
      + " where user_name = ? AND f.day_of_month = ?";
  private PreparedStatement checkSameDayStatement;
  private static final String CHECK_FLIGHT_RESERVATION_NUM = "select count(*) as num from RESERVATIONS where (flight_id1 = ? OR flight_id2 = ?)";
  private PreparedStatement checkFlightReservationNumStatement;
  private static final String CREATE_RESERVATION_SQL = "insert into RESERVATIONS(user_name,flight_id1,flight_id2,isPaid) values (?,?,?,0)";
  private PreparedStatement createReservationStatement;

  // For pay
  private static final String FIND_RESERVATION_SQL = "select sum(price) as price from (select flight_id1, flight_id2 from RESERVATIONS WHERE reservation_id = ? AND user_name = ? "
      + " AND isPaid = 0) t, FLIGHTS f WHERE t.flight_id1 = f.fid OR t.flight_id2 = f.fid";
  private PreparedStatement findReservationStatement;
  private static final String FIND_BALANCE_SQL = "select balance from USERS where username = ?";
  private PreparedStatement findBalanceStatement;
  private static final String UPDATE_BALANCE_SQL = "UPDATE USERS SET balance = ? WHERE username = ?";
  private PreparedStatement updateBalanceStatement;
  private static final String SET_PAID_SQL = "UPDATE RESERVATIONS SET isPaid = 1 WHERE reservation_id = ?";
  private PreparedStatement setPaidStatement;

  // For reservations
  private static final String RESERVATIONS_SQL = "select * from RESERVATIONS";
  private PreparedStatement reservationsStatement;
  private static final String FIND_FID_SQL = "select day_of_month,carrier_id,flight_num,origin_city,dest_city,actual_time,capacity,price from FLIGHTS where fid = ?";
  private PreparedStatement findFidStatement;

  // For cancel
  private static final String CHECK_REFUND_SQL = "select sum(f.price) as refund from FLIGHTS f, RESERVATIONS r where (f.fid = r.flight_id1 or f.fid = r.flight_id2) and r.reservation_id = ? and r.user_name = ? and r.isPaid = 1";
  private PreparedStatement checkRefundStatement;
  private static final String REFUND_SQL = "UPDATE USERS SET balance = balance + ? FROM USERS WHERE username = ?";
  private PreparedStatement refundStatement;
  private static final String CANCEL_SQL = "delete from RESERVATIONS where reservation_id = ?";
  private PreparedStatement cancelStatement;

  // For search
  private static final String SEARCH_SQL1 = "SELECT TOP ( ? )"
      + " fid,day_of_month,carrier_id,flight_num,origin_city,dest_city,actual_time,capacity,price " + "FROM Flights "
      + "WHERE origin_city = ? AND dest_city = ? AND day_of_month = ? AND canceled = 0 ORDER BY actual_time ASC";
  private static final String SEARCH_SQL2 = "select * from (select TOP ( ? ) * from "
      + "(select 1 as num, F.actual_time as actual_time, "
      + " F.fid as fid1,  F.day_of_month as d_o_m1, F.carrier_id as c_i1, "
      + "   F.flight_num as f_n1, F.origin_city as o_c1, "
      + "   F.dest_city as d_c1,  F.capacity as c1, F.price as p1, F.actual_time as t1,"
      + " null as fid2,  null as d_o_m2, null as c_i2, " + "   null as f_n2, null as o_c2, "
      + "   null as d_c2,  null as c2, null as p2, null as t2 " + "   from Flights F"
      + "   where F.origin_city = ? and F.dest_city = ?" + "   AND F.day_of_month = ? AND F.canceled = 0" + " UNION "
      + " select 2 as num, (F1.actual_time + F2.actual_time) as actual_time, "
      + "   F1.fid as fid1, F1.day_of_month as d_o_m1, F1.carrier_id as c_i1, "
      + "   F1.flight_num as f_n1, F1.origin_city as o_c1, "
      + "   F1.dest_city as d_c1,  F1.capacity as c1, F1.price as p1, F1.actual_time as t1, "
      + "   F2.fid as fid2, F2.day_of_month as d_o_m2, F2.carrier_id as c_i2, "
      + "   F2.flight_num as f_n2, F2.origin_city as o_c2, "
      + "   F2.dest_city as d_c2,  F2.capacity as c2, F2.price as p2, F2.actual_time as t2 "
      + "   FROM Flights F1, Flights F2 " + "   WHERE F1.dest_city = F2.origin_city and "
      + "       F1.origin_city = ? and F2.dest_city = ? " + "       AND F1.day_of_month = ? and F2.day_of_month = ?"
      + " AND F1.canceled = 0 AND F2.canceled = 0 AND F1.month_id = F2.month_id" + ") as t "
      + "order by num, actual_time ASC) as m order by actual_time";
  private PreparedStatement searchStatement1;
  private PreparedStatement searchStatement2;

  private boolean isLoggedIn;
  private String user_name;
  private int identityFrom;

  private List<List<Integer>> itineraries;

  public Query() throws SQLException, IOException {
    this(null, null, null, null);
  }

  protected Query(String serverURL, String dbName, String adminName, String password) throws SQLException, IOException {
    conn = serverURL == null ? openConnectionFromDbConn()
        : openConnectionFromCredential(serverURL, dbName, adminName, password);
    isLoggedIn = false;
    user_name = null;
    itineraries = null;
    identityFrom = 0;
    prepareStatements();
  }

  /**
   * Return a connecion by using dbconn.properties file
   *
   * @throws SQLException
   * @throws IOException
   */
  public static Connection openConnectionFromDbConn() throws SQLException, IOException {
    // Connect to the database with the provided connection configuration
    Properties configProps = new Properties();
    configProps.load(new FileInputStream("dbconn.properties"));
    String serverURL = configProps.getProperty("hw5.server_url");
    String dbName = configProps.getProperty("hw5.database_name");
    String adminName = configProps.getProperty("hw5.username");
    String password = configProps.getProperty("hw5.password");
    return openConnectionFromCredential(serverURL, dbName, adminName, password);
  }

  /**
   * Return a connecion by using the provided parameter.
   *
   * @param serverURL example: example.database.widows.net
   * @param dbName    database name
   * @param adminName username to login server
   * @param password  password to login server
   *
   * @throws SQLException
   */
  protected static Connection openConnectionFromCredential(String serverURL, String dbName, String adminName,
      String password) throws SQLException {
    String connectionUrl = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s", serverURL,
        dbName, adminName, password);
    Connection conn = DriverManager.getConnection(connectionUrl);

    // By default, automatically commit after each statement
    conn.setAutoCommit(true);

    // By default, set the transaction isolation level to serializable
    conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

    return conn;
  }

  /**
   * Get underlying connection
   */
  public Connection getConnection() {
    return conn;
  }

  /**
   * Closes the application-to-database connection
   */
  public void closeConnection() throws SQLException {
    conn.close();
  }

  /**
   * Clear the data in any custom tables created.
   * 
   * WARNING! Do not drop any tables and do not clear the flights table.
   */
  public void clearTables() {
    try {

      tableClearStatement1.executeUpdate();
      tableClearStatement2.executeUpdate();
      reseedStatement.clearParameters();
      reseedStatement.setInt(1, 1);
      reseedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*
   * prepare all the SQL statements in this method.
   */
  private void prepareStatements() throws SQLException {
    checkFlightCapacityStatement = conn.prepareStatement(CHECK_FLIGHT_CAPACITY);
    tranCountStatement = conn.prepareStatement(TRANCOUNT_SQL);
    tableClearStatement1 = conn.prepareStatement(CLEAR_SQL1);
    tableClearStatement2 = conn.prepareStatement(CLEAR_SQL2);
    searchStatement1 = conn.prepareStatement(SEARCH_SQL1);
    searchStatement2 = conn.prepareStatement(SEARCH_SQL2);
    checkUserStatement = conn.prepareStatement(CHECK_USER_SQL);
    createUserStatement = conn.prepareStatement(CREATE_USER_SQL);
    checkFlightReservationNumStatement = conn.prepareStatement(CHECK_FLIGHT_RESERVATION_NUM);
    createReservationStatement = conn.prepareStatement(CREATE_RESERVATION_SQL, Statement.RETURN_GENERATED_KEYS);
    checkSameDayStatement = conn.prepareStatement(CHECK_SAME_DAY_SQL);
    reseedStatement = conn.prepareStatement(RESEED_SQL);
    findReservationStatement = conn.prepareStatement(FIND_RESERVATION_SQL);
    findBalanceStatement = conn.prepareStatement(FIND_BALANCE_SQL);
    updateBalanceStatement = conn.prepareStatement(UPDATE_BALANCE_SQL);
    setPaidStatement = conn.prepareStatement(SET_PAID_SQL);
    reservationsStatement = conn.prepareStatement(RESERVATIONS_SQL);
    findFidStatement = conn.prepareStatement(FIND_FID_SQL);
    cancelStatement = conn.prepareStatement(CANCEL_SQL);
    checkRefundStatement = conn.prepareStatement(CHECK_REFUND_SQL);
    refundStatement = conn.prepareStatement(REFUND_SQL);
  }

  /**
   * Takes a user's username and password and attempts to log the user in.
   *
   * @param username user's username
   * @param password user's password
   *
   * @return If someone has already logged in, then return "User already logged
   *         in\n" For all other errors, return "Login failed\n". Otherwise,
   *         return "Logged in as [username]\n".
   */
  public String transaction_login(String username, String password) {
    try {
      if (isLoggedIn) {
        return "User already logged in\n";

      }
      try {
        checkUserStatement.clearParameters();
        checkUserStatement.setString(1, username);
        ResultSet results = checkUserStatement.executeQuery();
        byte[] hash = null;
        byte[] hash2 = null;
        byte[] salt = null;
        while (results.next()) {
          hash = results.getBytes("password");
          salt = results.getBytes("salt");
          KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, HASH_STRENGTH, KEY_LENGTH);
          SecretKeyFactory factory = null;
          try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash2 = factory.generateSecret(spec).getEncoded();
          } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new IllegalStateException();
          }
        }
        results.close();
        if (hash != null && Arrays.equals(hash, hash2)) {
          isLoggedIn = true;
          user_name = username;
          itineraries = null;
          return String.format("Logged in as %s\n", username);
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
      return "Login failed\n";
    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Implement the create user function.
   *
   * @param username   new user's username. User names are unique the system.
   * @param password   new user's password.
   * @param initAmount initial amount to deposit into the user's account, should
   *                   be >= 0 (failure otherwise).
   *
   * @return either "Created user {@code username}\n" or "Failed to create user\n"
   *         if failed.
   */
  public String transaction_createCustomer(String username, String password, int initAmount) {
    try {
      if (initAmount < 0) {
        return "Failed to create user\n";
      }

      // check user name
      try {
        checkUserStatement.clearParameters();
        checkUserStatement.setString(1, username);
        ResultSet results = checkUserStatement.executeQuery();
        boolean fail = false;
        while (results.next()) {
          fail = true;
        }
        results.close();
        if (fail) {
          return "Failed to create user\n";
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      // Generate a random cryptographic salt
      SecureRandom random = new SecureRandom();
      byte[] salt = new byte[16];
      random.nextBytes(salt);

      // Specify the hash parameters
      KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, HASH_STRENGTH, KEY_LENGTH);

      // Generate the hash
      SecretKeyFactory factory = null;
      byte[] hash = null;
      try {
        factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        hash = factory.generateSecret(spec).getEncoded();
      } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
        throw new IllegalStateException();
      }
      try {
        createUserStatement.clearParameters();
        createUserStatement.setString(1, username);
        createUserStatement.setBytes(2, hash);
        createUserStatement.setBytes(3, salt);
        createUserStatement.setInt(4, initAmount);
        createUserStatement.executeUpdate();
        return String.format("Created user %s\n", username);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return "Failed to create user\n";
    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Implement the search function.
   *
   * Searches for flights from the given origin city to the given destination
   * city, on the given day of the month. If {@code directFlight} is true, it only
   * searches for direct flights, otherwise is searches for direct flights and
   * flights with two "hops." Only searches for up to the number of itineraries
   * given by {@code numberOfItineraries}.
   *
   * The results are sorted based on total flight time.
   *
   * @param originCity
   * @param destinationCity
   * @param directFlight        if true, then only search for direct flights,
   *                            otherwise include indirect flights as well
   * @param dayOfMonth
   * @param numberOfItineraries number of itineraries to return
   *
   * @return If no itineraries were found, return "No flights match your
   *         selection\n". If an error occurs, then return "Failed to search\n".
   *
   *         Otherwise, the sorted itineraries printed in the following format:
   *
   *         Itinerary [itinerary number]: [number of flights] flight(s), [total
   *         flight time] minutes\n [first flight in itinerary]\n ... [last flight
   *         in itinerary]\n
   *
   *         Each flight should be printed using the same format as in the
   *         {@code Flight} class. Itinerary numbers in each search should always
   *         start from 0 and increase by 1.
   *
   * @see Flight#toString()
   */
  public String transaction_search(String originCity, String destinationCity, boolean directFlight, int dayOfMonth,
      int numberOfItineraries) {
    try {
      StringBuffer sb = new StringBuffer();
      if (directFlight == true) {
        try {
          searchStatement1.clearParameters();
          searchStatement1.setInt(1, numberOfItineraries);
          searchStatement1.setString(2, originCity);
          searchStatement1.setString(3, destinationCity);
          searchStatement1.setInt(4, dayOfMonth);

          ResultSet directResults = searchStatement1.executeQuery();
          itineraries = new ArrayList<>();
          int i = 0;
          while (directResults.next()) {
            int result_fid = directResults.getInt("fid");
            int result_dayOfMonth = directResults.getInt("day_of_month");
            String result_carrierId = directResults.getString("carrier_id");
            String result_flightNum = directResults.getString("flight_num");
            String result_originCity = directResults.getString("origin_city");
            String result_destCity = directResults.getString("dest_city");
            int result_time = directResults.getInt("actual_time");
            int result_capacity = directResults.getInt("capacity");
            int result_price = directResults.getInt("price");
            itineraries.add(List.of(result_fid, result_capacity, -1, -1, result_dayOfMonth));

            sb.append("Itinerary " + (i++) + ": 1 flight(s), " + result_time + " minutes\n");
            sb.append("ID: " + result_fid + " Day: " + result_dayOfMonth + " Carrier: " + result_carrierId + " Number: "
                + result_flightNum + " Origin: " + result_originCity + " Dest: " + result_destCity + " Duration: "
                + result_time + " Capacity: " + result_capacity + " Price: " + result_price + "\n");
          }
          directResults.close();

        } catch (SQLException e) {
          e.printStackTrace();
        }
        if (sb.length() == 0) {
          return "No flights match your selection\n";
        }
        return sb.toString();
      } else {
        try {
          searchStatement2.clearParameters();
          searchStatement2.setInt(1, numberOfItineraries);
          searchStatement2.setString(2, originCity);
          searchStatement2.setString(3, destinationCity);
          searchStatement2.setInt(4, dayOfMonth);
          searchStatement2.setString(5, originCity);
          searchStatement2.setString(6, destinationCity);
          searchStatement2.setInt(7, dayOfMonth);
          searchStatement2.setInt(8, dayOfMonth);

          ResultSet oneHopResults = searchStatement2.executeQuery();
          itineraries = new ArrayList<>();

          int i = 0;
          while (oneHopResults.next()) {
            int result_sum_time = oneHopResults.getInt("actual_time");
            oneHopResults.getInt("fid2");
            int result_flight_num = oneHopResults.wasNull() ? 1 : 2;
            int result_fid1 = oneHopResults.getInt("fid1");
            int result_dayOfMonth1 = oneHopResults.getInt("d_o_m1");
            String result_carrierId1 = oneHopResults.getString("c_i1");
            String result_flightNum1 = oneHopResults.getString("f_n1");
            String result_originCity1 = oneHopResults.getString("o_c1");
            String result_destCity1 = oneHopResults.getString("d_c1");
            int result_time1 = oneHopResults.getInt("t1");
            int result_capacity1 = oneHopResults.getInt("c1");
            int result_price1 = oneHopResults.getInt("p1");

            sb.append(
                "Itinerary " + (i++) + ": " + result_flight_num + " flight(s), " + result_sum_time + " minutes\n");
            sb.append("ID: " + result_fid1 + " Day: " + result_dayOfMonth1 + " Carrier: " + result_carrierId1
                + " Number: " + result_flightNum1 + " Origin: " + result_originCity1 + " Dest: " + result_destCity1
                + " Duration: " + result_time1 + " Capacity: " + result_capacity1 + " Price: " + result_price1 + "\n");

            if (result_flight_num == 2) {
              int result_fid2 = oneHopResults.getInt("fid2");
              int result_dayOfMonth2 = oneHopResults.getInt("d_o_m2");
              String result_carrierId2 = oneHopResults.getString("c_i2");
              String result_flightNum2 = oneHopResults.getString("f_n2");
              String result_originCity2 = oneHopResults.getString("o_c2");
              String result_destCity2 = oneHopResults.getString("d_c2");
              int result_time2 = oneHopResults.getInt("t2");
              int result_capacity2 = oneHopResults.getInt("c2");
              int result_price2 = oneHopResults.getInt("p2");
              itineraries
                  .add(List.of(result_fid1, result_capacity1, result_fid2, result_capacity2, result_dayOfMonth1));

              sb.append("ID: " + result_fid2 + " Day: " + result_dayOfMonth2 + " Carrier: " + result_carrierId2
                  + " Number: " + result_flightNum2 + " Origin: " + result_originCity2 + " Dest: " + result_destCity2
                  + " Duration: " + result_time2 + " Capacity: " + result_capacity2 + " Price: " + result_price2
                  + "\n");
            } else {
              itineraries.add(List.of(result_fid1, result_capacity1, -1, -1, result_dayOfMonth1));
            }

          }
          oneHopResults.close();

        } catch (SQLException e) {
          e.printStackTrace();
        }
        if (sb.length() == 0) {
          return "No flights match your selection\n";
        }
        return sb.toString();
      }

    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Implements the book itinerary function.
   *
   * @param itineraryId ID of the itinerary to book. This must be one that is
   *                    returned by search in the current session.
   *
   * @return If the user is not logged in, then return "Cannot book reservations,
   *         not logged in\n". If the user is trying to book an itinerary with an
   *         invalid ID or without having done a search, then return "No such
   *         itinerary {@code itineraryId}\n". If the user already has a
   *         reservation on the same day as the one that they are trying to book
   *         now, then return "You cannot book two flights in the same day\n". For
   *         all other errors, return "Booking failed\n".
   *
   *         And if booking succeeded, return "Booked flight(s), reservation ID:
   *         [reservationId]\n" where reservationId is a unique number in the
   *         reservation system that starts from 1 and increments by 1 each time a
   *         successful reservation is made by any user in the system.
   */
  public String transaction_book(int itineraryId) {
    try {
      if (isLoggedIn != true) {
        return "Cannot book reservations, not logged in\n";
      }
      if (itineraries != null && itineraryId >= 0 && itineraryId < itineraries.size()) {
        boolean deadlock = true;
        while (deadlock) {
          deadlock = false;
          try {
            conn.setAutoCommit(false);
            checkSameDayStatement.clearParameters();
            checkSameDayStatement.setString(1, user_name);
            checkSameDayStatement.setInt(2, itineraries.get(itineraryId).get(4));
            ResultSet res_num = checkSameDayStatement.executeQuery();
            res_num.next();
            int num = res_num.getInt("num");
            res_num.close();
            if (num > 0) {
              conn.commit();
              conn.setAutoCommit(true);
              return "You cannot book two flights in the same day\n";
            }
            checkFlightReservationNumStatement.clearParameters();
            checkFlightReservationNumStatement.setInt(1, itineraries.get(itineraryId).get(0));
            checkFlightReservationNumStatement.setInt(2, itineraries.get(itineraryId).get(0));
            ResultSet res = checkFlightReservationNumStatement.executeQuery();
            res.next();
            int left_capacity = itineraries.get(itineraryId).get(1) - res.getInt("num");
            res.close();
            if (itineraries.get(itineraryId).get(2) >= 0) {
              checkFlightReservationNumStatement.clearParameters();
              checkFlightReservationNumStatement.setInt(1, itineraries.get(itineraryId).get(2));
              checkFlightReservationNumStatement.setInt(2, itineraries.get(itineraryId).get(2));
              res = checkFlightReservationNumStatement.executeQuery();
              res.next();
              left_capacity = Math.min(itineraries.get(itineraryId).get(3) - res.getInt("num"), left_capacity);
              res.close();
            }
            if (left_capacity > 0) {
              createReservationStatement.clearParameters();
              createReservationStatement.setString(1, user_name);
              createReservationStatement.setInt(2, itineraries.get(itineraryId).get(0));
              int fid2 = itineraries.get(itineraryId).get(2);
              if (fid2 > 0) {
                createReservationStatement.setInt(3, fid2);
              } else {
                createReservationStatement.setNull(3, java.sql.Types.INTEGER);
              }
              createReservationStatement.executeUpdate();
              ResultSet rs = createReservationStatement.getGeneratedKeys();
              rs.next();
              int reservationID = rs.getInt(1);
              rs.close();
              conn.commit();
              conn.setAutoCommit(true);
              identityFrom = reservationID - 1;
              return "Booked flight(s), reservation ID: " + reservationID + "\n";
            }
            conn.rollback();
            conn.setAutoCommit(true);
            return "Booking failed\n";
          } catch (SQLException e) {
            deadlock = isDeadLock(e);
            if (deadlock) {
              try {
                conn.rollback();
                conn.setAutoCommit(true);
                reseedStatement.clearParameters();
                reseedStatement.setInt(1, identityFrom);
                reseedStatement.executeUpdate();
              } catch (SQLException e1) {
                e.printStackTrace();
              }
            }
          }

        }

      }
      return "No such itinerary " + itineraryId + "\n";
    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Implements the pay function.
   *
   * @param reservationId the reservation to pay for.
   *
   * @return If no user has logged in, then return "Cannot pay, not logged in\n"
   *         If the reservation is not found / not under the logged in user's
   *         name, then return "Cannot find unpaid reservation [reservationId]
   *         under user: [username]\n" If the user does not have enough money in
   *         their account, then return "User has only [balance] in account but
   *         itinerary costs [cost]\n" For all other errors, return "Failed to pay
   *         for reservation [reservationId]\n"
   *
   *         If successful, return "Paid reservation: [reservationId] remaining
   *         balance: [balance]\n" where [balance] is the remaining balance in the
   *         user's account.
   */
  public String transaction_pay(int reservationId) {
    try {
      if (isLoggedIn == false) {
        return "Cannot pay, not logged in\n";
      }
      boolean deadlock = true;
      while (deadlock) {
        deadlock = false;
        try {
          conn.setAutoCommit(false);
          findReservationStatement.clearParameters();
          findReservationStatement.setInt(1, reservationId);
          findReservationStatement.setString(2, user_name);
          ResultSet rs = findReservationStatement.executeQuery();
          rs.next();
          int price = rs.getInt("price");
          rs.close();
          if (price == 0) {
            conn.commit();
            conn.setAutoCommit(true);
            return "Cannot find unpaid reservation " + reservationId + " under user: " + user_name + "\n";
          }
          findBalanceStatement.clearParameters();
          findBalanceStatement.setString(1, user_name);
          rs = findBalanceStatement.executeQuery();
          if (rs.next() == false) {
            rs.close();
            conn.commit();
            conn.setAutoCommit(true);
            return "Failed to pay for reservation " + reservationId + "\n";
          }
          int balance = rs.getInt("balance");
          rs.close();
          if (balance < price) {
            conn.commit();
            conn.setAutoCommit(true);
            return "User has only " + balance + " in account but itinerary costs " + price + "\n";
          }
          updateBalanceStatement.clearParameters();
          updateBalanceStatement.setInt(1, balance - price);
          updateBalanceStatement.setString(2, user_name);
          updateBalanceStatement.executeUpdate();

          setPaidStatement.clearParameters();
          setPaidStatement.setInt(1, reservationId);
          setPaidStatement.executeUpdate();

          conn.commit();
          conn.setAutoCommit(true);
          return "Paid reservation: " + reservationId + " remaining balance: " + (balance - price) + "\n";

        } catch (SQLException e) {
          deadlock = isDeadLock(e);
          try {
            conn.rollback();
            conn.setAutoCommit(true);
          } catch (SQLException e1) {
            e.printStackTrace();
          }
        }
      }
      return "Failed to pay for reservation " + reservationId + "\n";
    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Implements the reservations function.
   *
   * @return If no user has logged in, then return "Cannot view reservations, not
   *         logged in\n" If the user has no reservations, then return "No
   *         reservations found\n" For all other errors, return "Failed to
   *         retrieve reservations\n"
   *
   *         Otherwise return the reservations in the following format:
   *
   *         Reservation [reservation ID] paid: [true or false]:\n [flight 1 under
   *         the reservation]\n [flight 2 under the reservation]\n Reservation
   *         [reservation ID] paid: [true or false]:\n [flight 1 under the
   *         reservation]\n [flight 2 under the reservation]\n ...
   *
   *         Each flight should be printed using the same format as in the
   *         {@code Flight} class.
   *
   * @see Flight#toString()
   */
  public String transaction_reservations() {
    try {
      if (isLoggedIn == false) {
        return "Cannot view reservations, not logged in\n";
      }
      boolean deadlock = true;
      while (deadlock) {
        deadlock = false;
        try {
          conn.setAutoCommit(false);
          ResultSet rs = reservationsStatement.executeQuery();
          int i = 0;
          StringBuffer sb = new StringBuffer();
          while (rs.next()) {
            i++;
            int reservation_id = rs.getInt("reservation_id");
            int fid1 = rs.getInt("flight_id1");
            boolean isPaid = rs.getBoolean("isPaid");

            findFidStatement.clearParameters();
            findFidStatement.setInt(1, fid1);
            ResultSet rs2 = findFidStatement.executeQuery();
            rs2.next();
            int result_dayOfMonth = rs2.getInt("day_of_month");
            String result_carrierId = rs2.getString("carrier_id");
            int result_flightNum = rs2.getInt("flight_num");
            String result_originCity = rs2.getString("origin_city");
            String result_destCity = rs2.getString("dest_city");
            int result_time = rs2.getInt("actual_time");
            int result_capacity = rs2.getInt("capacity");
            int result_price = rs2.getInt("price");
            rs2.close();

            sb.append("Reservation " + reservation_id + " paid: " + isPaid + ":\n" + "ID: " + fid1 + " Day: "
                + result_dayOfMonth + " Carrier: " + result_carrierId + " Number: " + result_flightNum + " Origin: "
                + result_originCity + " Dest: " + result_destCity + " Duration: " + result_time + " Capacity: "
                + result_capacity + " Price: " + result_price + "\n");

            int fid2 = rs.getInt("flight_id2");
            if (!rs.wasNull()) {
              findFidStatement.clearParameters();
              findFidStatement.setInt(1, fid2);
              rs2 = findFidStatement.executeQuery();
              rs2.next();
              result_dayOfMonth = rs2.getInt("day_of_month");
              result_carrierId = rs2.getString("carrier_id");
              result_flightNum = rs2.getInt("flight_num");
              result_originCity = rs2.getString("origin_city");
              result_destCity = rs2.getString("dest_city");
              result_time = rs2.getInt("actual_time");
              result_capacity = rs2.getInt("capacity");
              result_price = rs2.getInt("price");
              rs2.close();

              sb.append("ID: " + fid2 + " Day: " + result_dayOfMonth + " Carrier: " + result_carrierId + " Number: "
                  + result_flightNum + " Origin: " + result_originCity + " Dest: " + result_destCity + " Duration: "
                  + result_time + " Capacity: " + result_capacity + " Price: " + result_price + "\n");
            }
          }

          if (i == 0) {
            rs.close();
            conn.commit();
            conn.setAutoCommit(true);
            return "No reservations found\n";
          }
          rs.close();
          conn.commit();
          conn.setAutoCommit(true);
          return sb.toString();
        } catch (SQLException e) {
          deadlock = isDeadLock(e);
          try {
            conn.rollback();
            conn.setAutoCommit(true);
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
          e.printStackTrace();
        }
      }
      return "Failed to retrieve reservations\n";
    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Implements the cancel operation.
   *
   * @param reservationId the reservation ID to cancel
   *
   * @return If no user has logged in, then return "Cannot cancel reservations,
   *         not logged in\n" For all other errors, return "Failed to cancel
   *         reservation [reservationId]\n"
   *
   *         If successful, return "Canceled reservation [reservationId]\n"
   *
   *         Even though a reservation has been canceled, its ID should not be
   *         reused by the system.
   */
  public String transaction_cancel(int reservationId) {
    try {
      if (!isLoggedIn) {
        return "Cannot cancel reservations, not logged in\n";
      }
      boolean deadlock = true;
      while (deadlock) {
        deadlock = false;
        try {
          conn.setAutoCommit(false);
          checkRefundStatement.clearParameters();
          checkRefundStatement.setInt(1, reservationId);
          checkRefundStatement.setString(2, user_name);
          ResultSet rs = checkRefundStatement.executeQuery();
          rs.next();
          int refund = rs.getInt("refund");
          rs.close();
          if(refund > 0){
            refundStatement.clearParameters();
            refundStatement.setInt(1, refund);
            refundStatement.setString(2, user_name);
            refundStatement.executeUpdate();
          }
          cancelStatement.clearParameters();
          cancelStatement.setInt(1, reservationId);
          int succeeded = cancelStatement.executeUpdate();
          if (succeeded > 0) {
            conn.commit();
            conn.setAutoCommit(true);
            return "Canceled reservation " + reservationId + "\n";
          }
          conn.commit();
          conn.setAutoCommit(true);
          return "Failed to cancel reservation " + reservationId + "\n";
        } catch (SQLException e) {
          deadlock = isDeadLock(e);
          if(deadlock){
            try{
              conn.rollback();
              conn.setAutoCommit(false);
            } catch (SQLException ex){
              ex.printStackTrace();
            }
          }
          e.printStackTrace();
        }
      }
      return "Failed to cancel reservation " + reservationId + "\n";
    } finally {
      checkDanglingTransaction();
    }
  }

  /**
   * Example utility function that uses prepared statements
   */
  private int checkFlightCapacity(int fid) throws SQLException {
    checkFlightCapacityStatement.clearParameters();
    checkFlightCapacityStatement.setInt(1, fid);
    ResultSet results = checkFlightCapacityStatement.executeQuery();
    results.next();
    int capacity = results.getInt("capacity");
    results.close();

    return capacity;
  }

  /**
   * Throw IllegalStateException if transaction not completely complete, rollback.
   * 
   */
  private void checkDanglingTransaction() {
    try {
      try (ResultSet rs = tranCountStatement.executeQuery()) {
        rs.next();
        int count = rs.getInt("tran_count");
        if (count > 0) {
          throw new IllegalStateException(
              "Transaction not fully commit/rollback. Number of transaction in process: " + count);
        }
      } finally {
        conn.setAutoCommit(true);
      }
    } catch (SQLException e) {
      throw new IllegalStateException("Database error", e);
    }
  }

  private static boolean isDeadLock(SQLException ex) {
    return ex.getErrorCode() == 1205;
  }

  /**
   * A class to store flight information.
   */
  class Flight {
    public int fid;
    public int dayOfMonth;
    public String carrierId;
    public String flightNum;
    public String originCity;
    public String destCity;
    public int time;
    public int capacity;
    public int price;

    @Override
    public String toString() {
      return "ID: " + fid + " Day: " + dayOfMonth + " Carrier: " + carrierId + " Number: " + flightNum + " Origin: "
          + originCity + " Dest: " + destCity + " Duration: " + time + " Capacity: " + capacity + " Price: " + price;
    }
  }
}

package flightapp;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

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
  private static final String CLEAR_SQL1 = "DELETE FROM RESERVATIONS";
  private static final String CLEAR_SQL2 = "DELETE FROM USERS";
  private PreparedStatement tableClearStatement1;
  private PreparedStatement tableClearStatement2;

  // For login
  private static final String CHECK_USER_SQL = "SELECT password, salt FROM USERS WHERE username = ?";
  private PreparedStatement checkUserStatement;

  // For create user
  private static final String CREATE_USER_SQL = "INSERT INTO USERS (username, password, salt, balance) VALUES (?, ? , ? , ?)";
  private PreparedStatement createUserStatement;

  // For search
  private static final String SEARCH_SQL1 = "SELECT TOP ( ? )"
      + " fid,day_of_month,carrier_id,flight_num,origin_city,dest_city,actual_time,capacity,price " + "FROM Flights "
      + "WHERE origin_city = ? AND dest_city = ? AND day_of_month = ? AND canceled = 0 ORDER BY actual_time ASC";
  private static final String SEARCH_SQL2 = "select * from (select TOP ( ? ) * from " + "(select 1 as num, F.actual_time as actual_time, "
      + " F.fid as fid1,  F.day_of_month as d_o_m1, F.carrier_id as c_i1, "
      + "   F.flight_num as f_n1, F.origin_city as o_c1, " + "   F.dest_city as d_c1,  F.capacity as c1, F.price as p1, F.actual_time as t1,"
      + " null as fid2,  null as d_o_m2, null as c_i2, " + "   null as f_n2, null as o_c2, "
      + "   null as d_c2,  null as c2, null as p2, null as t2 " + "   from Flights F"
      + "   where F.origin_city = ? and F.dest_city = ?" + "   AND F.day_of_month = ? AND F.canceled = 0" + " UNION "
      + " select 2 as num, (F1.actual_time + F2.actual_time) as actual_time, "
      + "   F1.fid as fid1, F1.day_of_month as d_o_m1, F1.carrier_id as c_i1, "
      + "   F1.flight_num as f_n1, F1.origin_city as o_c1, "
      + "   F1.dest_city as d_c1,  F1.capacity as c1, F1.price as p1, F1.actual_time as t1, "
      + "   F2.fid as fid2, F2.day_of_month as d_o_m2, F2.carrier_id as c_i2, "
      + "   F2.flight_num as f_n2, F2.origin_city as o_c2, "
      + "   F2.dest_city as d_c2,  F2.capacity as c2, F2.price as p2, F2.actual_time as t2 " + "   FROM Flights F1, Flights F2 "
      + "   WHERE F1.dest_city = F2.origin_city and " + "       F1.origin_city = ? and F2.dest_city = ? "
      + "       AND F1.day_of_month = ? and F2.day_of_month = ?"
      + " AND F1.canceled = 0 AND F2.canceled = 0 AND F1.month_id = F2.month_id"
      + ") as t " + "order by num, actual_time ASC) as m order by actual_time";
  private PreparedStatement searchStatement1;
  private PreparedStatement searchStatement2;

  private boolean isLoggedIn;
  private String user_name;

  public Query() throws SQLException, IOException {
    this(null, null, null, null);
  }

  protected Query(String serverURL, String dbName, String adminName, String password) throws SQLException, IOException {
    conn = serverURL == null ? openConnectionFromDbConn()
        : openConnectionFromCredential(serverURL, dbName, adminName, password);
    isLoggedIn = false;
    user_name = null;
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

    // TODO: YOUR CODE HERE
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
          searchStatement1.setInt(1, numberOfItineraries);
          searchStatement1.setString(2, originCity);
          searchStatement1.setString(3, destinationCity);
          searchStatement1.setInt(4, dayOfMonth);

          ResultSet directResults = searchStatement1.executeQuery();
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

            sb.append("Itinerary " + (i++) + ": 1 flight(s), " + result_time + " minutes\n");
            sb.append("ID: " + result_fid + " Day: " + result_dayOfMonth + " Carrier: " + result_carrierId + " Number: "
                + result_flightNum + " Origin: " + result_originCity + " Dest: " + result_destCity
                + " Duration: " + result_time + " Capacity: " + result_capacity + " Price: " + result_price + "\n");
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
          searchStatement2.setInt(1, numberOfItineraries);
          searchStatement2.setString(2, originCity);
          searchStatement2.setString(3, destinationCity);
          searchStatement2.setInt(4, dayOfMonth);
          searchStatement2.setString(5, originCity);
          searchStatement2.setString(6, destinationCity);
          searchStatement2.setInt(7, dayOfMonth);
          searchStatement2.setInt(8, dayOfMonth);

          ResultSet oneHopResults = searchStatement2.executeQuery();

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

            sb.append("Itinerary " + (i++) + ": " + result_flight_num + " flight(s), " + result_sum_time + " minutes\n");
            sb.append("ID: " + result_fid1 + " Day: " + result_dayOfMonth1 + " Carrier: " + result_carrierId1
                + " Number: " + result_flightNum1 + " Origin: " + result_originCity1 + " Dest: "
                + result_destCity1 + " Duration: " + result_time1 + " Capacity: " + result_capacity1 + " Price: "
                + result_price1 + "\n");

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

              sb.append("ID: " + result_fid2 + " Day: " + result_dayOfMonth2 + " Carrier: " + result_carrierId2
                + " Number: " + result_flightNum2 + " Origin: " + result_originCity2 + " Dest: "
                + result_destCity2 + " Duration: " + result_time2 + " Capacity: " + result_capacity2 + " Price: "
                + result_price2 + "\n");
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
      // TODO: YOUR CODE HERE
      return "Booking failed\n";
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
      // TODO: YOUR CODE HERE
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
      // TODO: YOUR CODE HERE
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
      // TODO: YOUR CODE HERE
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

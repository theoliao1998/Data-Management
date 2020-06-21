create table USERS (username varchar(20),
                    password varbinary(20),
                    salt varbinary(20),
                    balance int, 
                    PRIMARY KEY (username));

create table RESERVATIONS (reservation_id int IDENTITY(1,1) not null, -- IDENTITY [ (seed , increment) ]  
                        user_name varchar(20),
                        flight_id1 int,
                        flight_id2 int,
                        isPaid bit,
                        PRIMARY KEY (reservation_id),
                        FOREIGN KEY (user_name) REFERENCES USERS(username) ON DELETE CASCADE,
                        FOREIGN KEY (flight_id1) REFERENCES FLIGHTS(fid),
                        FOREIGN KEY (flight_id2) REFERENCES FLIGHTS(fid) ON DELETE CASCADE);

-- CREATE INDEX F_origin ON FLIGHTS(origin_city);
-- CREATE INDEX F_dest ON FLIGHTS(dest_city);
-- CREATE INDEX F_origin_dest ON FLIGHTS(origin_city, dest_city);
-- CREATE INDEX F_day_of_month ON FLIGHTS(day_of_month);
-- CREATE INDEX F_month_id ON FLIGHTS(month_id);
-- CREATE INDEX F_actual_time ON FLIGHTS(actual_time);
-- CREATE INDEX F_canceled ON FLIGHTS(canceled);
-- CREATE INDEX R_user_name on RESERVATIONS(user_name);
-- CREATE INDEX R_fid1 on RESERVATIONS(flight_id1);
-- CREATE INDEX R_fid2 on RESERVATIONS(flight_id2);
-- CREATE INDEX R_c on RESERVATIONS(isCancelled);
-- CREATE INDEX R_user on RESERVATIONS(user_name);

-- select sum(f.price) from FLIGHTS f, RESERVATIONS r where (f.fid = r.flight_id1 or f.fid = r.flight_id2) and 
-- r.reservation_id = ? and r.user_name = ? and r.isPaid = 1
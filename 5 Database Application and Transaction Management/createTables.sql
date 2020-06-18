create table USERS (username varchar(20),
                    password varbinary(20),
                    salt varbinary(20),
                    balance int, 
                    PRIMARY KEY (username));

create table RESERVATIONS (reservation_id int IDENTITY(1,1) not null,
                        user_name varchar(20),
                        flight_id1 int,
                        flight_id2 int,
                        isPaid bit,
                        isCancelled bit,
                        PRIMARY KEY (reservation_id),
                        FOREIGN KEY (user_name) REFERENCES USERS(username) ON DELETE CASCADE,
                        FOREIGN KEY (flight_id1) REFERENCES FLIGHTS(fid),
                        FOREIGN KEY (flight_id2) REFERENCES FLIGHTS(fid) ON DELETE CASCADE);

-- CREATE INDEX F_origin ON FLIGHTS(origin_city);
-- CREATE INDEX F_dest ON FLIGHTS(dest_city);
-- CREATE INDEX F_origin_dest ON FLIGHTS(origin_city, dest_city);

-- select * from
-- (select F.actual_time as actual_time, 
--     F.day_of_month as d_o_m1, F.carrier_id as c_i1, 
--     F.flight_num as f_n1, F.origin_city as o_c1, 
--     F.dest_city as d_c1,  F.capacity as c1, F.price as p1,
--     null as d_o_m2, null as c_i2, 
--     null as f_n2, null as o_c2, 
--     null as d_c2,  null as c2, null as p2
--     from Flights F
--     where F.origin_city = 'Seattle WA' and F.dest_city = 'Boston MA'
-- UNION
-- select (F1.actual_time + F2.actual_time) as actual_time, 
--     F1.day_of_month as d_o_m1, F1.carrier_id as c_i1, 
--     F1.flight_num as f_n1, F1.origin_city as o_c1, 
--     F1.dest_city as d_c1,  F1.capacity as c1, F1.price as p1,
--     F2.day_of_month as d_o_m2, F2.carrier_id as c_i2, 
--     F2.flight_num as f_n2, F2.origin_city as o_c2, 
--     F2.dest_city as d_c2,  F2.capacity as c2, F2.price as p2
--     FROM Flights F1, Flights F2 
--     WHERE F1.dest_city = F2.origin_city and
--         F1.origin_city = 'Seattle WA' and F2.dest_city = 'Boston MA'
--         AND F1.day_of_month = 1 and F2.day_of_month = 1) as t
-- order by actual_time;
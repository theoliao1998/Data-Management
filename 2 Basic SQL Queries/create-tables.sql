-- sqlite3
PRAGMA foreign_keys=ON;

CREATE TABLE IF NOT EXISTS CARRIERS (
    cid varchar(7) PRIMARY KEY,
    name varchar(83)
);

CREATE TABLE IF NOT EXISTS MONTHS (
    mid int PRIMARY KEY, 
    month varchar(9)
);

CREATE TABLE IF NOT EXISTS WEEKDAYS (
    did int PRIMARY KEY, 
    day_of_week varchar(9)
);

CREATE TABLE IF NOT EXISTS FLIGHTS (
	fid int PRIMARY KEY, 
    month_id int,        -- 1-12
    day_of_month int,    -- 1-31 
    day_of_week_id int,  -- 1-7, 1 = Monday, 2 = Tuesday, etc
    carrier_id varchar(7),
    flight_num int,
    origin_city varchar(34), 
    origin_state varchar(47), 
    dest_city varchar(34), 
    dest_state varchar(46), 
    departure_delay int, -- in mins
    taxi_out int,        -- in mins
    arrival_delay int,   -- in mins
    canceled int,        -- 1 means canceled
    actual_time int,     -- in mins
    distance int,        -- in miles
    capacity int, 
    price int,            -- in $         
    FOREIGN KEY (month_id) references MONTHS(mid) ON DELETE CASCADE,
    FOREIGN KEY (day_of_week_id) references WEEKDAYS(did) ON DELETE CASCADE,
    FOREIGN KEY (carrier_id) references CARRIERS(cid) ON DELETE CASCADE,
);

.mode csv
.import carriers.csv CARRIERS
.import months.csv MONTHS
.import weekdays.csv WEEKDAYS
.import flights-small.csv FLIGHTS


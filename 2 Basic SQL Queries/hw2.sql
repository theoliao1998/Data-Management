.mode column
.headers on

-- q1
-- List the distinct flight numbers of all flights from Seattle to Boston by Alaska Airlines Inc. on Mondays.
-- Also notice that, in the database, the city names include the state. So Seattle appears as
-- Seattle WA. Please use the flight_num column instead of fid.
-- Name the output column flight_num.
-- [Hint: Output relation cardinality: 3 rows]
select distinct f.flight_num as flight_num from FLIGHTS f, CARRIERS c, WEEKDAYS w 
    where f.carrier_id=c.cid and
    f.day_of_week_id=w.did and
    f.origin_city='Seattle WA' and 
    f.dest_city='Boston MA' and 
    c.name='Alaska Airlines Inc.' and 
    w.day_of_week='Monday';

-- q2
-- Find all itineraries from Seattle to Boston on July 15th. Search only for itineraries that have one stop (i.e., flight 1: Seattle -> [somewhere], flight2: [somewhere] -> Boston).
-- Both flights must depart on the same day (same day here means the date of flight) and must be with the same carrier. It's fine if the landing date is different from the departing date (i.e., in the case of an overnight flight). You don't need to check whether the first flight overlaps with the second one since the departing and arriving time of the flights are not provided.
-- The total flight time (actual_time) of the entire itinerary should be fewer than 7 hours
-- (but notice that actual_time is in minutes).
-- For each itinerary, the query should return the name of the carrier, the first flight number,
-- the origin and destination of that first flight, the flight time, the second flight number,
-- the origin and destination of the second flight, the second flight time, and finally the total flight time.
-- Only count flight times here; do not include any layover time.
-- Name the output columns name as the name of the carrier, f1_flight_num, f1_origin_city, f1_dest_city, f1_actual_time, f2_flight_num, f2_origin_city, f2_dest_city, f2_actual_time, and actual_time as the total flight time. List the output columns in this order.
-- [Output relation cardinality: 1472 rows]
select c.name as 'carrier name',f1.flight_num as f1_flight_num, f1.origin_city as f1_origin_city,
    f1.dest_city as f1_dest_city, f1.actual_time as f1_actual_time, f2.flight_num as f2_flight_num, 
    f2.origin_city as f2_origin_city, f2.dest_city as f2_dest_city, f2.actual_time as f2_actual_time, 
    (f1.actual_time + f2.actual_time) as actual_time
    from FLIGHTS f1, FLIGHTS f2, CARRIERS c, MONTHS m
    where f1.carrier_id=f2.carrier_id and
    f1.month_id=f2.month_id and
    f1.day_of_month=f2.day_of_month and
    f1.origin_city='Seattle WA' and
    f2.dest_city='Boston MA' and
    f1.dest_city=f2.origin_city and
    f1.carrier_id=c.cid and
    f1.month_id=m.mid and
    m.month='July' and
    f1.day_of_month='15' and
    (f1.actual_time+f2.actual_time)<7*60;

-- q3
-- Find the day of the week with the longest average arrival delay.
-- Return the name of the day and the average delay.
-- Name the output columns day_of_week and delay, in that order. (Hint: consider using LIMIT. Look up what it does!)
-- [Output relation cardinality: 1 row]
select w.day_of_week, avg(f.arrival_delay) as delay from FLIGHTS f, WEEKDAYS w
    where f.day_of_week_id=w.did
    group by w.day_of_week
    order by avg(f.arrival_delay) desc
    limit 1;

-- q4
-- Find the names of all airlines that ever flew more than 1000 flights in one day
-- (i.e., a specific day/month, but not any 24-hour period).
-- Return only the names of the airlines. Do not return any duplicates
-- (i.e., airlines with the exact same name).
-- Name the output column name.
-- [Output relation cardinality: 12 rows]
select distinct c.name from FLIGHTS f, CARRIERS c
    where f.carrier_id=c.cid
    group by c.cid, c.name, f.month_id, f.day_of_month
    having count(*)>1000;

-- q5
-- Find all airlines that had more than 0.5 percent of their flights out of Seattle be canceled.
-- Return the name of the airline and the percentage of canceled flight out of Seattle.
-- Order the results by the percentage of canceled flights in ascending order.
-- Name the output columns name and percent, in that order.
-- [Output relation cardinality: 6 rows]
select c.name, sum(f.canceled)/(1.0*count(*)) as percent
    from FLIGHTS f, CARRIERS c
    where f.carrier_id=c.cid and
    f.origin_city='Seattle WA'
    group by c.cid, c.name
    having percent>0.005
    order by percent;

-- q6
-- Find the maximum price of tickets between Seattle and New York, NY (i.e. Seattle to NY or NY to Seattle).
-- Show the maximum price for each airline separately.
-- Name the output columns carrier and max_price, in that order.
-- [Output relation cardinality: 3 rows]
select c.name as carrier, max(f.price) as max_price
    from FLIGHTS f, CARRIERS c
    where f.carrier_id=c.cid and
    ((f.origin_city='Seattle WA' and f.dest_city='New York NY') or 
    (f.dest_city='Seattle WA' and f.origin_city='New York NY'))
    group by c.cid, c.name;

-- q7
-- Find the total capacity of all direct flights that fly between Seattle and San Francisco, CA on July 10th (i.e. Seattle to SF or SF to Seattle).
-- Name the output column capacity.
-- [Output relation cardinality: 1 row]
select sum(f.capacity) as capacity
    from FLIGHTS f, MONTHS m
    where f.month_id=m.mid and
    ((f.origin_city='Seattle WA' and f.dest_city='San Francisco CA') or 
    (f.dest_city='San Francisco CA' and f.origin_city='New York NY')) and
    m.month='July' and
    f.day_of_month=10;

-- q8
-- Compute the total departure delay of each airline
-- across all flights. Some departure delays may be negative (indicating an early departure); they should reduce the total, so you don't need to handle them specially.
-- Name the output columns name and delay, in that order.
-- [Output relation cardinality: 22 rows]
select c.name, sum(f.departure_delay) as delay from FLIGHTS f, CARRIERS c
    where f.carrier_id=c.cid
    group by c.cid, c.name;
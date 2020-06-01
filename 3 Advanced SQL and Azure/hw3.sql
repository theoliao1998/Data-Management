-- q1
-- For each origin city, find the destination city (or cities) with the longest direct flight.
-- By direct flight, we mean a flight with no intermediate stops. Judge the longest flight in
-- time, not distance. (15 points)
-- Name the output columns origin_city, dest_city,
-- and time representing the the flight time between them.
-- Do not include duplicates of the same origin/destination city pair.
-- Order the result by origin_city and then dest_city (ascending, i.e. alphabetically).
-- [Output relation cardinality: 334 rows]
-- query time: 6s
select distinct f.origin_city, f.dest_city, t.time
    from FLIGHTS f, (
        select f.origin_city, max(f.actual_time) as time 
        from FLIGHTS f 
        group by f.origin_city
    ) t
    where f.origin_city=t.origin_city and
    f.actual_time=t.time
    order by f.origin_city, f.dest_city;


-- q2
-- Find all origin cities that only serve flights shorter than 3 hours.
-- You can assume that flights with NULL actual_time are not 3 hours or more. (15 points)
-- Name the output column city and sort them. List each city only once in the result.
-- [Output relation cardinality: 109]
-- query time: 3s
select f.origin_city as city
    from FLIGHTS f 
    group by f.origin_city
    having max(f.actual_time)<3*60
    order by city;

-- q3
-- For each origin city, find the percentage of departing flights shorter than 3 hours.
-- For this question, treat flights with NULL actual_time values as longer than 3 hours. (15 points)
-- Name the output columns origin_city and percentage
-- Order by percentage value, ascending. Be careful to handle cities without any flights shorter than 3 hours.
-- We will accept either 0 or NULL as the result for those cities.
-- Report percentages as percentages not decimals (e.g., report 75.25 rather than 0.7525).
-- [Output relation cardinality: 327]
-- query time: 6s
select f.origin_city, (
        select count(*) 
        from FLIGHTS f2 
        where f.origin_city=f2.origin_city and 
        f2.actual_time<3*60
    )*100.0/count(*) as percentage
    from FLIGHTS f
    group by origin_city
    order by percentage;

-- q4
-- List all cities that cannot be reached from Seattle though a direct flight but can be reached with
-- one stop (i.e., with any two flights that go through an intermediate city).
-- Do not include Seattle as one of these destinations (even though you could get back with two flights).
-- (15 points)
-- Name the output column city. Order the output ascending by city.
-- [Output relation cardinality: 256]
-- query time: 10s (would be wrong and much slower without distinct)
select distinct f2.dest_city as city
    from FLIGHTS f1, FLIGHTS f2
    where f1.dest_city=f2.origin_city and
    f1.origin_city='Seattle WA' and
    f2.dest_city!='Seattle WA' and
    f2.dest_city not in(
        select distinct f3.dest_city
        from FLIGHTS f3
        where f3.origin_city='Seattle WA'
        and f3.dest_city=f2.dest_city
    )
    order by city;

-- q5
-- List all cities that cannot be reached from Seattle through a direct flight nor with one stop
-- (i.e., with any two flights that go through an intermediate city). Warning: this query might take a while to execute.
-- We will learn about how to speed this up in lecture. (15 points)
-- Name the output column city. Order the output ascending by city.
-- (You can assume all cities to be the collection of all origin_city or all dest_city)
-- (Note: Do not worry if this query takes a while to execute. We are mostly concerned with the results)
-- [Output relation cardinality: 3 or 4, depending on what you consider to be the set of all cities]
-- query time: 170s
select distinct f1.dest_city as city
    from FLIGHTS f1
    where f1.dest_city not in (
        select distinct f2.dest_city
        from FLIGHTS f2
        where f2.origin_city='Seattle WA'
    ) and 
    f1.dest_city not in (
        select distinct f4.dest_city
        from FLIGHTS f3, FLIGHTS f4
        where f3.dest_city=f4.origin_city and
        f3.origin_city='Seattle WA'
    );

-- q6
-- List the names of carriers that operate flights from Seattle to San Francisco, CA.
-- Return each carrier's name only once. Use a nested query to answer this question. (7 points)
-- Name the output column carrier. Order the output ascending by carrier.
-- [Output relation cardinality: 4]
-- query time: 3s
select distinct c.name as carrier
    from CARRIERS c 
    where c.cid in (
        select distinct f.carrier_id
        from FLIGHTS f 
        where f.origin_city='Seattle WA' and
        f.dest_city='San Francisco CA'
    );

-- q7
-- Express the same query as above, but do so without using a nested query. Again, name the output column
-- carrier and order ascending.
-- query time: 1s
select distinct c.name as carrier
    from FLIGHTS f, CARRIERS c
    where f.carrier_id=c.cid and
    f.origin_city='Seattle WA' and
    f.dest_city='San Francisco CA';
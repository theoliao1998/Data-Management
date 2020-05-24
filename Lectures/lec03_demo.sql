--  Practice with null, aggregates, and ORDER BY/DISTINCT

create table Purchase(
   pid int primary key,
   product text,
   price float,
   quantity int,
   month varchar(15));

-- Fill the table with pre-made data
.import '2-data.txt' Purchase

select * from Purchase;

-- sqlite doesn't let us include null values in our pre-made data
-- so we instead use placeholder text and change the value
update purchase set price=null where price='null';
-- Now we have null attributes
select * from Purchase;

-- ORDER BY lets us order the results (note the departure from set semantics)
select * from Purchase ORDER BY price;
-- It defaults to ascending order...
select * from Purchase ORDER BY price ASC;
-- ...or we can specify descending
select * from Purchase ORDER BY price DESC;

-- Also useful for testing - limit the number of results to the top 2
select * from Purchase ORDER BY price DESC LIMIT 2;
-- Without ordering, it gives you any 2 rows back
select * from Purchase LIMIT 2;

select product from Purchase;
-- Often want to list unique values rather than all the duplicates
select DISTINCT product from Purchase;

-- Trying out our new aggregate functions
select count(*) from purchase;
-- * counts all rows, using an attribute counts non-null values
select count(price) from purchase;
-- aggregates don't include null values
select avg(price) from purchase;
-- can also have multiple aggregates in the select clause
select max(quantity), min(quantity) from Purchase;
-- counts non-null values vs distinct non-null values
select count(product) from purchase;
select count(distinct product) from purchase;

-- How to get the total dollar amount of sales from the table?
-- price, quantity per row
select price, quantity from Purchase;
-- dollar amount per row
.headers on
select price*quantity as purchase_total from Purchase;
-- total dollar amount over table
select SUM(price*quantity) as purchase_total from Purchase;
-- the 'as purchase_total' alias names the column in the *results*,
-- doesn't affect the underlying table





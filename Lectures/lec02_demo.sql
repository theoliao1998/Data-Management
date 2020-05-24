/* practice key creation */

/* sqlite has no boolean type, so we use a y/n character */
create table Company
  (cname varchar(20) primary key,
   country varchar(20),
   no_employees int,
   for_profit char(1));

insert into Company  values ('GizmoWorks', 'USA',  20000,'y');
insert into Company  values ('Canon',     'Japan', 50000,'y');
insert into Company  values ('Hitachi',   'Japan', 30000,'y');
/* Keywords are case-insensitive. For hw style, we like using
   all-caps to make it easier to read. We often use lowercase
   when writing queries on the fly because it's easier. */
INSERT INTO Company  VALUES('Charity',    'Canada',  500,'n');

select * from Company;

-- what commands does SQL Lite have that can help us display it more nicely?
.help

-- Making sure SQL Lite shows us the data in a nicer format
-- These commands are specific to SQLite!
.header on
.mode column
.nullvalue NULL

-- Null values: whenever we don't know the value, we can set it to NULL
insert into Company values('MobileWorks', 'China', null, null);
select * from Company;


-- Can order the results - a departure from set semantics, but useful in the real world!
select cname from Company;
select cname from Company ORDER BY cname;
select cname from Company ORDER BY cname DESC;

-- Since DBMSs use bag semantics, it can be useful to get back to unique values:
select country from Company;
select distinct country from Company;


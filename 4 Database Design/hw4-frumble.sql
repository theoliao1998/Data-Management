-- sqlite3

-- q1
-- Create a table in the database and load the data from the provided file into that table; 
-- use SQLite or any other relational DBMS if your choosing.
-- Turn in your create table statement. The data import statements are optional (you don't need to include these).
CREATE TABLE IF NOT EXISTS Sales (
	name varchar(16),
    discount int,
    month char(3),
    price int
);

.separator "\t"
.import mrFrumbleData_edited.txt Sales

select cnt;


-- q2
-- Find all nontrivial functional dependencies in the database.
-- This is a reverse engineering task, so expect to proceed in a trial and error fashion. 
-- Search first for the simple dependencies, say name → discount then try the more complex ones, 
-- like name, discount → month, as needed. To check each functional dependency you have to write a SQL query.
-- Your challenge is to write this SQL query for every candidate functional dependency that you check, such that:
-- a. the query's answer is always short (say: no more than ten lines - remember that 0 results can be instructive as well)
-- b. you can determine whether the FD holds or not by looking at the query's answer.
-- Try to be clever in order not to check too many dependencies, but don't miss potential relevant dependencies.
-- For example, if you have A → B and C → D, you do not need to derive AC → BD as well.
-- Please write a SQL query for each functional dependency you find along with a comment describing the functional dependency.
-- Please also include a SQL query for at least one functional dependency that does not exist in the dataset 
-- along with a comment mentioning that the functional dependency does not exist.
-- Remember, short queries are preferred.

-- name -> price
select max(cnt) from (
    select count(distinct price) as cnt from Sales
        group by name
);

-- month -> discount
select max(cnt) from (
    select count(distinct discount) as cnt from Sales
        group by month
);

-- price !-> discount
select max(cnt) from (
    select count(distinct discount) as cnt from Sales
        group by price
);

select max(cnt) from (
    select count(*) as cnt from Sales
        group by name, month
);

-- q3
-- Decompose the table into Boyce-Codd Normal Form (BCNF), 
-- and create SQL tables for the decomposed schema. Create keys and foreign keys where appropriate.
-- For this question turn in the SQL commands for creating the tables.

PRAGMA foreign_keys=ON;

CREATE TABLE IF NOT EXISTS Products (
	name varchar(16) PRIMARY KEY,
    price int
);

CREATE TABLE IF NOT EXISTS Months (
	month char(3) PRIMARY KEY,
    discount int
);

CREATE TABLE IF NOT EXISTS Records (
	pname varchar(16),
    month char(3),
    PRIMARY KEY (pname,month),
    FOREIGN KEY (pname) references Products(name) ON DELETE CASCADE,
    FOREIGN KEY (month) references Months(month) ON DELETE CASCADE
);

-- q4
-- Populate your BCNF tables from Mr. Frumble's data.
-- For this you need to write SQL queries that load the tables you created in question 3 from the table you created in question 1.
-- Here, turn in the SQL queries that load the tables, and count the size of the tables after loading them 
-- (obtained by running SELECT COUNT(*) FROM Table).
insert into Products
    select distinct name, price
        from Sales;

insert into Months
    select distinct month, discount
        from Sales;

insert into Records
    select name as pname, month 
        from Sales;
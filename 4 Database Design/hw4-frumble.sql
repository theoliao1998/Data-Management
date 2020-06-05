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


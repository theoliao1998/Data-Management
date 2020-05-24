.mode column
.headers on

-- Problem 1
CREATE TABLE IF NOT EXISTS Edges (
	Source INT, 
    Destination INT
);

insert into Edges values (10,5); 
insert into Edges values (6,25);
insert into Edges values (1,3);
insert into Edges values (4,4);

select * from Edges;
select Source from Edges;
select * from Edges where Source > Destination;

insert into Edges values ('-1','2000');

-- Problem 2
CREATE TABLE IF NOT EXISTS MyRestaurants (
	Name varchar(10), 
    Food varchar(10),
    Distance int,
    Last_vist Date,
    Like int
);

-- Problem 3
insert into MyRestaurants values ('Asian Flavor','Noodles','3','2020-05-11',1);
insert into MyRestaurants values ('Pizza Hut','Pizza','10','2020-02-11',0);
insert into MyRestaurants values ('KFC','Chicken','4','2020-05-13',1);
insert into MyRestaurants values ('Mc Donalds','Hamburger','20','2020-05-05',NULL);
insert into MyRestaurants values ('Burger King','Hamburger','9','2019-09-11',NULL);

-- Problem 4
.mode csv
.headers off
select * from MyRestaurants;
.headers on
select * from MyRestaurants;


.mode list
.headers off
select * from MyRestaurants;
.headers on
select * from MyRestaurants;

.mode column
.width 15
.headers off
select * from MyRestaurants;
.headers on
select * from MyRestaurants;

-- Problem 5
select Name, Distance from MyRestaurants where Distance<=20 order by Name;

-- Problem 6
select * from MyRestaurants where Like=1 and Last_vist<Date('now','-3 months');

-- Problem 7
select * from MyRestaurants where Distance<=10;
**From:** Xinhao Liao  
**To:** Sarah Dimatto  
**Date:** Week 4  

Hi Sarah,  

I am more than willing to help you. The information you need are given below with the full query lists appended in the end. Also, the documentation is appended in *documentation.pdf*.  

To find the recipe titles that are either a vegetable or a salad, we can use the query `select r.RecipeTitle from Recipes r join Recipe_Classes r_c on r.RecipeClassID=r_c.RecipeClassID where r_c.RecipeClassDescription in ("Vegetable", "Salad");`, which gives the results as follows.  
```
+---------------------+
| RecipeTitle         |
+---------------------+
| Garlic Green Beans  |
| Asparagus           |
| Mike's Summer Salad |
+---------------------+
```

To find all the dishes that contain seafood, we can use the query `select r.RecipeTitle from Recipes r join Recipe_Ingredients r_i on r.RecipeID=r_i.RecipeID join Ingredients i on r_i.IngredientID= i.IngredientID join Ingredient_Classes i_c on i.IngredientClassID=i_c.IngredientClassID where i_c. IngredientClassDescription='Seafood';`, which gives the results as follows.  
```
+-------------------------------------------------------+
| RecipeTitle                                           |
+-------------------------------------------------------+
| Salmon Filets in Parchment Paper                      |
| Huachinango Veracruzana (Red Snapper, Veracruz style) |
+-------------------------------------------------------+
```

You can make "Roast Beef" for everyone that contains beef and garlic, which is obatined from the query `select r.RecipeTitle from Recipes r join Recipe_Ingredients r_i1 on r.RecipeID=r_i1.RecipeID join Recipe_Ingredients r_i2 on r_i1.RecipeID=r_i2.RecipeID join Ingredients i1 on r_i1.IngredientID=i1.IngredientID join Ingredients i2 on r_i2.IngredientID=i2.IngredientID where (i1.IngredientName='Beef' and i2.IngredientName='Garlic');`.  

For the names of those employees who work in the Operations department, I use the query `select e.fname as 'first name', e.lname as 'last name' from employee e join department d on e.dept_id=d.dept_id where d.name='Operations';`, and obtained the following list.  
```
+------------+-----------+
| first name | last name |
+------------+-----------+
| Susan      | Hawthorne |
| Helen      | Fleming   |
| Chris      | Tucker    |
| Sarah      | Parker    |
| Jane       | Grossman  |
| Paula      | Roberts   |
| Thomas     | Ziegler   |
| Samantha   | Jameson   |
| John       | Blake     |
| Cindy      | Mason     |
| Frank      | Portman   |
| Theresa    | Markham   |
| Beth       | Fowler    |
| Rick       | Tulman    |
+------------+-----------+
```

To know on what dates Paula Roberts opened accounts and what the address of those customers are, we can use the query `select a.open_date, c.address, c.city, c.state from account a left join employee e on a.open_emp_id=e.emp_id left join customer c on a.cust_id=c.cust_id where e.fname='Paula' and e.lname='Roberts';` (which gives the detailed address including the city and state). And the result is as follows.  
```
+------------+---------------------+------------+-------+
| open_date  | address             | city       | state |
+------------+---------------------+------------+-------+
| 2000-01-15 | 47 Mockingbird Ln   | Lynnfield  | MA    |
| 2000-01-15 | 47 Mockingbird Ln   | Lynnfield  | MA    |
| 2004-06-30 | 47 Mockingbird Ln   | Lynnfield  | MA    |
| 2001-03-12 | 372 Clearwater Blvd | Woburn     | MA    |
| 2001-03-12 | 372 Clearwater Blvd | Woburn     | MA    |
| 2004-01-12 | 29 Admiral Ln       | Wilmington | MA    |
| 2004-03-22 | 287A Corporate Ave  | Wilmington | MA    |
+------------+---------------------+------------+-------+
```

A list of all our employees and their manager's ID is given as follows.  
```
+-------------+------------+-----------+---------------+
| employee id | first name | last name | supervisor id |
+-------------+------------+-----------+---------------+
|           1 | Michael    | Smith     |          NULL |
|           2 | Susan      | Barker    |             1 |
|           3 | Robert     | Tyler     |             1 |
|           4 | Susan      | Hawthorne |             3 |
|           5 | John       | Gooding   |             4 |
|           6 | Helen      | Fleming   |             4 |
|           7 | Chris      | Tucker    |             6 |
|           8 | Sarah      | Parker    |             6 |
|           9 | Jane       | Grossman  |             6 |
|          10 | Paula      | Roberts   |             4 |
|          11 | Thomas     | Ziegler   |            10 |
|          12 | Samantha   | Jameson   |            10 |
|          13 | John       | Blake     |             4 |
|          14 | Cindy      | Mason     |            13 |
|          15 | Frank      | Portman   |            13 |
|          16 | Theresa    | Markham   |             4 |
|          17 | Beth       | Fowler    |            16 |
|          18 | Rick       | Tulman    |            16 |
+-------------+------------+-----------+---------------+
```

To obtain a list of all accounts that have not been closed, the available balance, the state the customer is located in, and the name of the customer's business if they have one, I use the query `select a.account_id, a.avail_balance as 'available balance', c.state as 'customer state', b.name as 'business name' from account a JOIN customer c on a.cust_id=c.cust_id LEFT JOIN business b on c.cust_id=b.cust_id where a.status!='CLOSED';`, which gives me the result as follows.  
```
+------------+-------------------+----------------+------------------------+
| account_id | available balance | customer state | business name          |
+------------+-------------------+----------------+------------------------+
|          1 |           1057.75 | MA             | NULL                   |
|          2 |            500.00 | MA             | NULL                   |
|          3 |           3000.00 | MA             | NULL                   |
|          4 |           2258.02 | MA             | NULL                   |
|          5 |            200.00 | MA             | NULL                   |
|          7 |           1057.75 | MA             | NULL                   |
|          8 |           2212.50 | MA             | NULL                   |
|         10 |            534.12 | MA             | NULL                   |
|         11 |            767.77 | MA             | NULL                   |
|         12 |           5487.09 | MA             | NULL                   |
|         13 |           2237.97 | NH             | NULL                   |
|         14 |            122.37 | MA             | NULL                   |
|         15 |          10000.00 | MA             | NULL                   |
|         17 |           5000.00 | MA             | NULL                   |
|         18 |           3487.19 | NH             | NULL                   |
|         19 |            387.99 | NH             | NULL                   |
|         21 |            125.67 | MA             | NULL                   |
|         22 |           9345.55 | MA             | NULL                   |
|         23 |           1500.00 | MA             | NULL                   |
|         24 |          23575.12 | NH             | Chilton Engineering    |
|         25 |              0.00 | NH             | Chilton Engineering    |
|         27 |           9345.55 | MA             | Northeast Cooling Inc. |
|         28 |          38552.05 | NH             | Superior Auto Body     |
|         29 |          50000.00 | MA             | AAA Insurance Inc.     |
+------------+-------------------+----------------+------------------------+
```

For a list of employees that work at a branch with the address of "422 Maple St.", I use the query `select e.emp_id as 'employee id', e.fname as 'first name', e.lname as 'last name' from employee e join branch b on e.assigned_branch_id=b.branch_id where b.address='422 Maple St.';` and obtain the result as follows.  
```
+-------------+------------+-----------+
| employee id | first name | last name |
+-------------+------------+-----------+
|          10 | Paula      | Roberts   |
|          11 | Thomas     | Ziegler   |
|          12 | Samantha   | Jameson   |
+-------------+------------+-----------+
```

For questions about some exciting places to visit,  
* 5 random cities that have a population of 13,000 and below 500,000 and are not located in North America could be  
```
+------------+
| Name       |
+------------+
| Wuppertal  |
| Manchester |
| Bauru      |
| Kolomna    |
| Rivne      |
+------------+
```  
* There are 518 cities in a Constitutional Monarchy (with another 90 cities in a Constitutional Monarchy, Federation, and another 3 in a Constitutional Monarchy (Emirate)).  
* 5 random cities that a population above 13000 and below 500,000 that don't speak English as an official language and are not a Republic could be as follows. (Note: They are also not Federal Republic, People's Republic, Socialistic Republic, or Islamic Republic as well.)  
```
+-----------+
| Name      |
+-----------+
| Sayama    |
| Masqat    |
| Dordrecht |
| Hakodate  |
| Portmore  |
+-----------+
```

For questions about *ro_research1*, a table showing the ptstatus, Fitbit date, and the total number of steps and how far off the user was from their goal for all users every day is obtained, which is so long that I append another file *ro_research1_query.pdf* for it.  

For questions related to the *ro_employee database* database,  
* From 1985-01-01 to 1986-01-01, 9278 people were on payroll with a title that contained the word "Engineer".  
* 31700 people work in the Production department anytime between 1985-01-01 to 1992-01-01 (included).  
* A list of the names of 20 random employees, their current salary, and their current title is shown here as follows.  
```
+------------+---------------+--------+-----------------+
| first_name | last_name     | salary | title           |
+------------+---------------+--------+-----------------+
| Mitsuyuki  | Tibblin       |  57044 | Senior Staff    |
| Mihalis    | Kawashimo     |  87021 | Senior Staff    |
| Hausi      | Bruckman      |  86783 | Senior Staff    |
| Jinxi      | Siprelle      |  57105 | Senior Staff    |
| Shigeu     | Validov       |  57466 | Engineer        |
| Sanjai     | Marrevee      |  72404 | Engineer        |
| Sarita     | Klassen       |  94720 | Senior Engineer |
| Annemarie  | Bojadziev     |  61303 | Senior Engineer |
| Alejandro  | Pileggi       |  73260 | Senior Staff    |
| Shooichi   | Teitelbaum    |  95012 | Senior Staff    |
| Zeydy      | Waleschkowski |  96536 | Senior Staff    |
| Ghassan    | Munawer       |  99881 | Senior Staff    |
| Shiv       | Chorvat       |  66313 | Senior Engineer |
| Krister    | Gulla         | 114698 | Senior Staff    |
| Indrajit   | Tetzlaff      |  56921 | Engineer        |
| Yishay     | Hainaut       |  73228 | Senior Staff    |
| Kauko      | Marrevee      |  72915 | Senior Staff    |
| Boutros    | Esteva        |  53874 | Engineer        |
| Jessie     | Greibach      |  67619 | Senior Engineer |
| Moheb      | Lorcy         |  70795 | Senior Engineer |
+------------+---------------+--------+-----------------+
```

I didn't hear anything about the promotion of Raj and quite intrested in talking over drinks next week!  

Best,  

Xinhao Liao  
Datebase Team Member    
Borromean Digitial  


--  
<span style="color:blue">Database query list</span>   
```
mysql> use ro_recipes;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------------+
| Tables_in_ro_recipes |
+----------------------+
| Ingredient_Classes   |
| Ingredients          |
| Measurements         |
| Recipe_Classes       |
| Recipe_Ingredients   |
| Recipes              |
+----------------------+
6 rows in set (0.03 sec)

mysql>  desc Recipes;
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| RecipeID      | int(11)      | NO   | PRI | 0       |       |
| RecipeTitle   | varchar(255) | YES  |     | NULL    |       |
| RecipeClassID | smallint(6)  | YES  | MUL | 0       |       |
| Preparation   | text         | YES  |     | NULL    |       |
| Notes         | text         | YES  |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+
5 rows in set (0.03 sec)

mysql> desc Recipe_Classes;
+------------------------+--------------+------+-----+---------+-------+
| Field                  | Type         | Null | Key | Default | Extra |
+------------------------+--------------+------+-----+---------+-------+
| RecipeClassID          | smallint(6)  | NO   | PRI | 0       |       |
| RecipeClassDescription | varchar(255) | YES  |     | NULL    |       |
+------------------------+--------------+------+-----+---------+-------+
2 rows in set (0.03 sec)

mysql> select * from Recipe_Classes;
+---------------+------------------------+
| RecipeClassID | RecipeClassDescription |
+---------------+------------------------+
|             1 | Main course            |
|             2 | Vegetable              |
|             3 | Starch                 |
|             4 | Salad                  |
|             5 | Hors d'oeuvres         |
|             6 | Dessert                |
|             7 | Soup                   |
+---------------+------------------------+
7 rows in set (0.05 sec)

mysql> select r.RecipeTitle from Recipes r join Recipe_Classes r_c on r.RecipeClassID=r_c.RecipeClassID where r_c.RecipeClassDescription in ("Vegetable","Salad");
+---------------------+
| RecipeTitle         |
+---------------------+
| Garlic Green Beans  |
| Asparagus           |
| Mike's Summer Salad |
+---------------------+
3 rows in set (0.02 sec)

mysql> desc Ingredients;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| IngredientID      | int(11)      | NO   | PRI | 0       |       |
| IngredientName    | varchar(255) | YES  |     | NULL    |       |
| IngredientClassID | smallint(6)  | YES  |     | 0       |       |
| MeasureAmountID   | smallint(6)  | YES  |     | 0       |       |
+-------------------+--------------+------+-----+---------+-------+
4 rows in set (0.02 sec)

mysql> select * from Ingredient_Classes;
+-------------------+----------------------------+
| IngredientClassID | IngredientClassDescription |
+-------------------+----------------------------+
|                 1 | Spice                      |
|                 2 | Meat                       |
|                 3 | Vegetable                  |
|                 4 | Oil                        |
|                 5 | Pasta                      |
|                 6 | Grain                      |
|                 7 | Flour                      |
|                 8 | Dairy                      |
|                 9 | Liquid                     |
|                10 | Seafood                    |
|                11 | Butter                     |
|                12 | Cheese                     |
|                13 | Sauce                      |
|                14 | Dressing                   |
|                15 | Gravy                      |
|                16 | Topping                    |
|                17 | Fruit                      |
|                18 | Chips                      |
|                19 | Condiment                  |
|                20 | Bottle                     |
|                21 | Packaged food              |
|                22 | Herb                       |
|                23 | Sorbet                     |
|                24 | Liquor                     |
+-------------------+----------------------------+
24 rows in set (0.06 sec)

mysql> desc Recipe_Ingredients;
+-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| RecipeID        | int(11)     | NO   | PRI | 0       |       |
| RecipeSeqNo     | smallint(6) | NO   | PRI | 0       |       |
| IngredientID    | int(11)     | YES  | MUL | 0       |       |
| MeasureAmountID | smallint(6) | YES  | MUL | 0       |       |
| Amount          | double      | YES  |     | 0       |       |
+-----------------+-------------+------+-----+---------+-------+
5 rows in set (0.03 sec)

mysql> select r.RecipeTitle from Recipes r join Recipe_Ingredients r_i on r.RecipeID=r_i.RecipeID join Ingredients i on r_i.IngredientID= i.IngredientID join Ingredient_Classes i_c on i.IngredientClassID=i_c.IngredientClassID where i_c. IngredientClassDescription='Seafood';
+-------------------------------------------------------+
| RecipeTitle                                           |
+-------------------------------------------------------+
| Salmon Filets in Parchment Paper                      |
| Huachinango Veracruzana (Red Snapper, Veracruz style) |
+-------------------------------------------------------+
2 rows in set (0.08 sec)

mysql> select r.RecipeTitle from Recipes r join Recipe_Ingredients r_i on r.RecipeID=r_i.RecipeID join Ingredients i on r_i.IngredientID= i.IngredientID where i.IngredientName in ('Beef', 'Garlic');
+--------------------+
| RecipeTitle        |
+--------------------+
| Irish Stew         |
| Roast Beef         |
| Garlic Green Beans |
| Pollo Picoso       |
| Roast Beef         |
| Asparagus          |
+--------------------+
6 rows in set (0.03 sec)

mysql> select r.RecipeTitle from Recipes r join Recipe_Ingredients r_i1 on r.RecipeID=r_i1.RecipeID join Recipe_Ingredients r_i2 on r_i1.RecipeID=r_i2.RecipeID join Ingredients i1 on r_i1.IngredientID=i1.IngredientID join Ingredients i2 on r_i2.IngredientID=i2.IngredientID where (i1.IngredientName='Beef' and i2.IngredientName='Garlic');
+-------------+
| RecipeTitle |
+-------------+
| Roast Beef  |
+-------------+
1 row in set (0.02 sec)

mysql> use ro_company1;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+-----------------------+
| Tables_in_ro_company1 |
+-----------------------+
| account               |
| branch                |
| business              |
| customer              |
| department            |
| employee              |
| individual            |
| officer               |
| product               |
| product_type          |
| transaction           |
+-----------------------+
11 rows in set (0.03 sec)

mysql> desc employee;
+--------------------+----------------------+------+-----+---------+----------------+
| Field              | Type                 | Null | Key | Default | Extra          |
+--------------------+----------------------+------+-----+---------+----------------+
| emp_id             | smallint(5) unsigned | NO   | PRI | NULL    | auto_increment |
| fname              | varchar(20)          | NO   |     | NULL    |                |
| lname              | varchar(20)          | NO   |     | NULL    |                |
| start_date         | date                 | NO   |     | NULL    |                |
| end_date           | date                 | YES  |     | NULL    |                |
| superior_emp_id    | smallint(5) unsigned | YES  | MUL | NULL    |                |
| dept_id            | smallint(5) unsigned | YES  | MUL | NULL    |                |
| title              | varchar(20)          | YES  |     | NULL    |                |
| assigned_branch_id | smallint(5) unsigned | YES  | MUL | NULL    |                |
+--------------------+----------------------+------+-----+---------+----------------+
9 rows in set (0.02 sec)

mysql> select * from department;
+---------+----------------+
| dept_id | name           |
+---------+----------------+
|       1 | Operations     |
|       2 | Loans          |
|       3 | Administration |
+---------+----------------+
3 rows in set (0.06 sec)

mysql> select e.fname as 'first name', e.lname as 'last name' from employee e join department d on e.dept_id=d.dept_id where d.name='Operations';
+------------+-----------+
| first name | last name |
+------------+-----------+
| Susan      | Hawthorne |
| Helen      | Fleming   |
| Chris      | Tucker    |
| Sarah      | Parker    |
| Jane       | Grossman  |
| Paula      | Roberts   |
| Thomas     | Ziegler   |
| Samantha   | Jameson   |
| John       | Blake     |
| Cindy      | Mason     |
| Frank      | Portman   |
| Theresa    | Markham   |
| Beth       | Fowler    |
| Rick       | Tulman    |
+------------+-----------+
14 rows in set (0.02 sec)

mysql> desc account;
+--------------------+----------------------------------+------+-----+---------+----------------+
| Field              | Type                             | Null | Key | Default | Extra          |
+--------------------+----------------------------------+------+-----+---------+----------------+
| account_id         | int(10) unsigned                 | NO   | PRI | NULL    | auto_increment |
| product_cd         | varchar(10)                      | NO   | MUL | NULL    |                |
| cust_id            | int(10) unsigned                 | NO   | MUL | NULL    |                |
| open_date          | date                             | NO   |     | NULL    |                |
| close_date         | date                             | YES  |     | NULL    |                |
| last_activity_date | date                             | YES  |     | NULL    |                |
| status             | enum('ACTIVE','CLOSED','FROZEN') | YES  |     | NULL    |                |
| open_branch_id     | smallint(5) unsigned             | YES  | MUL | NULL    |                |
| open_emp_id        | smallint(5) unsigned             | YES  | MUL | NULL    |                |
| avail_balance      | float(10,2)                      | YES  |     | NULL    |                |
| pending_balance    | float(10,2)                      | YES  |     | NULL    |                |
+--------------------+----------------------------------+------+-----+---------+----------------+
11 rows in set (0.03 sec)

mysql> desc customer;
+--------------+------------------+------+-----+---------+----------------+
| Field        | Type             | Null | Key | Default | Extra          |
+--------------+------------------+------+-----+---------+----------------+
| cust_id      | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| fed_id       | varchar(12)      | NO   |     | NULL    |                |
| cust_type_cd | enum('I','B')    | NO   |     | NULL    |                |
| address      | varchar(30)      | YES  |     | NULL    |                |
| city         | varchar(20)      | YES  |     | NULL    |                |
| state        | varchar(20)      | YES  |     | NULL    |                |
| postal_code  | varchar(10)      | YES  |     | NULL    |                |
+--------------+------------------+------+-----+---------+----------------+
7 rows in set (0.03 sec)

mysql> select * from customer limit 1;
+---------+-------------+--------------+-------------------+-----------+-------+-------------+
| cust_id | fed_id      | cust_type_cd | address           | city      | state | postal_code |
+---------+-------------+--------------+-------------------+-----------+-------+-------------+
|       1 | 111-11-1111 | I            | 47 Mockingbird Ln | Lynnfield | MA    | 01940       |
+---------+-------------+--------------+-------------------+-----------+-------+-------------+
1 row in set (0.07 sec)

mysql> select a.open_date, c.address, c.city, c.state from account a left join employee e on a.open_emp_id=e.emp_id left join customer c on a.cust_id=c.cust_id where e.fname='Paula' and e.lname='Roberts';
+------------+---------------------+------------+-------+
| open_date  | address             | city       | state |
+------------+---------------------+------------+-------+
| 2000-01-15 | 47 Mockingbird Ln   | Lynnfield  | MA    |
| 2000-01-15 | 47 Mockingbird Ln   | Lynnfield  | MA    |
| 2004-06-30 | 47 Mockingbird Ln   | Lynnfield  | MA    |
| 2001-03-12 | 372 Clearwater Blvd | Woburn     | MA    |
| 2001-03-12 | 372 Clearwater Blvd | Woburn     | MA    |
| 2004-01-12 | 29 Admiral Ln       | Wilmington | MA    |
| 2004-03-22 | 287A Corporate Ave  | Wilmington | MA    |
+------------+---------------------+------------+-------+
7 rows in set (0.03 sec)

mysql> select emp_id as 'employee id', fname as 'first name', lname as 'last name', superior_emp_id as 'supervisor id' from employee;
+-------------+------------+-----------+---------------+
| employee id | first name | last name | supervisor id |
+-------------+------------+-----------+---------------+
|           1 | Michael    | Smith     |          NULL |
|           2 | Susan      | Barker    |             1 |
|           3 | Robert     | Tyler     |             1 |
|           4 | Susan      | Hawthorne |             3 |
|           5 | John       | Gooding   |             4 |
|           6 | Helen      | Fleming   |             4 |
|           7 | Chris      | Tucker    |             6 |
|           8 | Sarah      | Parker    |             6 |
|           9 | Jane       | Grossman  |             6 |
|          10 | Paula      | Roberts   |             4 |
|          11 | Thomas     | Ziegler   |            10 |
|          12 | Samantha   | Jameson   |            10 |
|          13 | John       | Blake     |             4 |
|          14 | Cindy      | Mason     |            13 |
|          15 | Frank      | Portman   |            13 |
|          16 | Theresa    | Markham   |             4 |
|          17 | Beth       | Fowler    |            16 |
|          18 | Rick       | Tulman    |            16 |
+-------------+------------+-----------+---------------+
18 rows in set (0.02 sec)

mysql> desc business;
+-------------+------------------+------+-----+---------+-------+
| Field       | Type             | Null | Key | Default | Extra |
+-------------+------------------+------+-----+---------+-------+
| cust_id     | int(10) unsigned | NO   | PRI | NULL    |       |
| name        | varchar(40)      | NO   |     | NULL    |       |
| state_id    | varchar(10)      | NO   |     | NULL    |       |
| incorp_date | date             | YES  |     | NULL    |       |
+-------------+------------------+------+-----+---------+-------+
4 rows in set (0.03 sec)

mysql> select * from business;
+---------+------------------------+------------+-------------+
| cust_id | name                   | state_id   | incorp_date |
+---------+------------------------+------------+-------------+
|      10 | Chilton Engineering    | 12-345-678 | 1995-05-01  |
|      11 | Northeast Cooling Inc. | 23-456-789 | 2001-01-01  |
|      12 | Superior Auto Body     | 34-567-890 | 2002-06-30  |
|      13 | AAA Insurance Inc.     | 45-678-901 | 1999-05-01  |
+---------+------------------------+------------+-------------+
4 rows in set (0.06 sec)

mysql> select a.account_id, a.avail_balance as 'available balance', c.state as 'customer state', b.name as 'business name' from account a JOIN customer c on a.cust_id=c.cust_id LEFT JOIN business b on c.cust_id=b.cust_id where a.status!='CLOSED';
+------------+-------------------+----------------+------------------------+
| account_id | available balance | customer state | business name          |
+------------+-------------------+----------------+------------------------+
|          1 |           1057.75 | MA             | NULL                   |
|          2 |            500.00 | MA             | NULL                   |
|          3 |           3000.00 | MA             | NULL                   |
|          4 |           2258.02 | MA             | NULL                   |
|          5 |            200.00 | MA             | NULL                   |
|          7 |           1057.75 | MA             | NULL                   |
|          8 |           2212.50 | MA             | NULL                   |
|         10 |            534.12 | MA             | NULL                   |
|         11 |            767.77 | MA             | NULL                   |
|         12 |           5487.09 | MA             | NULL                   |
|         13 |           2237.97 | NH             | NULL                   |
|         14 |            122.37 | MA             | NULL                   |
|         15 |          10000.00 | MA             | NULL                   |
|         17 |           5000.00 | MA             | NULL                   |
|         18 |           3487.19 | NH             | NULL                   |
|         19 |            387.99 | NH             | NULL                   |
|         21 |            125.67 | MA             | NULL                   |
|         22 |           9345.55 | MA             | NULL                   |
|         23 |           1500.00 | MA             | NULL                   |
|         24 |          23575.12 | NH             | Chilton Engineering    |
|         25 |              0.00 | NH             | Chilton Engineering    |
|         27 |           9345.55 | MA             | Northeast Cooling Inc. |
|         28 |          38552.05 | NH             | Superior Auto Body     |
|         29 |          50000.00 | MA             | AAA Insurance Inc.     |
+------------+-------------------+----------------+------------------------+
24 rows in set (0.03 sec)

mysql> desc branch;
+-----------+----------------------+------+-----+---------+----------------+
| Field     | Type                 | Null | Key | Default | Extra          |
+-----------+----------------------+------+-----+---------+----------------+
| branch_id | smallint(5) unsigned | NO   | PRI | NULL    | auto_increment |
| name      | varchar(20)          | NO   |     | NULL    |                |
| address   | varchar(30)          | YES  |     | NULL    |                |
| city      | varchar(20)          | YES  |     | NULL    |                |
| state     | varchar(2)           | YES  |     | NULL    |                |
| zip       | varchar(12)          | YES  |     | NULL    |                |
+-----------+----------------------+------+-----+---------+----------------+
6 rows in set (0.02 sec)

mysql> select e.emp_id as 'employee id', e.fname as 'first name', e.lname as 'last name' from employee e join branch b on e.assigned_branch_id=b.branch_id where b.address='422 Maple St.';
+-------------+------------+-----------+
| employee id | first name | last name |
+-------------+------------+-----------+
|          10 | Paula      | Roberts   |
|          11 | Thomas     | Ziegler   |
|          12 | Samantha   | Jameson   |
+-------------+------------+-----------+
3 rows in set (0.07 sec)

mysql> use world;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+-----------------+
| Tables_in_world |
+-----------------+
| city            |
| country         |
| countrylanguage |
+-----------------+
3 rows in set (0.03 sec)

mysql> desc country;
+----------------+---------------------------------------------------------------------------------------+------+-----+---------+-------+
| Field          | Type                                                                                  | Null | Key | Default | Extra |
+----------------+---------------------------------------------------------------------------------------+------+-----+---------+-------+
| Code           | char(3)                                                                               | NO   | PRI |         |       |
| Name           | char(52)                                                                              | NO   |     |         |       |
| Continent      | enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') | NO   |     | Asia    |       |
| Region         | char(26)                                                                              | NO   |     |         |       |
| SurfaceArea    | decimal(10,2)                                                                         | NO   |     | 0.00    |       |
| IndepYear      | smallint(6)                                                                           | YES  |     | NULL    |       |
| Population     | int(11)                                                                               | NO   |     | 0       |       |
| LifeExpectancy | decimal(3,1)                                                                          | YES  |     | NULL    |       |
| GNP            | decimal(10,2)                                                                         | YES  |     | NULL    |       |
| GNPOld         | decimal(10,2)                                                                         | YES  |     | NULL    |       |
| LocalName      | char(45)                                                                              | NO   |     |         |       |
| GovernmentForm | char(45)                                                                              | NO   |     |         |       |
| HeadOfState    | char(60)                                                                              | YES  |     | NULL    |       |
| Capital        | int(11)                                                                               | YES  |     | NULL    |       |
| Code2          | char(2)                                                                               | NO   |     |         |       |
+----------------+---------------------------------------------------------------------------------------+------+-----+---------+-------+
15 rows in set (0.03 sec)

mysql> select city.Name from city join country on city.CountryCode=country.Code where city.population BETWEEN 13000 AND 500000 and country.Continent!='North America' order by rand() limit 5;
+-------------------+
| Name              |
+-------------------+
| Nakhon Ratchasima |
| Derbent           |
| Liepaja           |
| Bacau             |
| Namwon            |
+-------------------+
5 rows in set (0.09 sec)

mysql> select distinct GovernmentForm from country;
+----------------------------------------------+
| GovernmentForm                               |
+----------------------------------------------+
| Nonmetropolitan Territory of The Netherlands |
| Islamic Emirate                              |
| Republic                                     |
| Dependent Territory of the UK                |
| Parliamentary Coprincipality                 |
| Emirate Federation                           |
| Federal Republic                             |
| US Territory                                 |
| Co-administrated                             |
| Nonmetropolitan Territory of France          |
| Constitutional Monarchy                      |
| Constitutional Monarchy, Federation          |
| Monarchy (Emirate)                           |
| Monarchy (Sultanate)                         |
| Monarchy                                     |
| Dependent Territory of Norway                |
| Territory of Australia                       |
| Federation                                   |
| People'sRepublic                             |
| Nonmetropolitan Territory of New Zealand     |
| Socialistic Republic                         |
| Occupied by Marocco                          |
| Part of Denmark                              |
| Overseas Department of France                |
| Special Administrative Region of China       |
| Islamic Republic                             |
| Constitutional Monarchy (Emirate)            |
| Socialistic State                            |
| Commonwealth of the US                       |
| Territorial Collectivity of France           |
| Autonomous Area                              |
| Administrated by the UN                      |
| Dependent Territory of the US                |
| Independent Church State                     |
| Parlementary Monarchy                        |
+----------------------------------------------+
35 rows in set (0.02 sec)

mysql> select count(1) from city join country on city.CountryCode=country.Code where country.GovernmentForm='Constitutional Monarchy';
+----------+
| count(1) |
+----------+
|      518 |
+----------+
1 row in set (0.03 sec)

mysql> select count(1) from city join country on city.CountryCode=country.Code where country.GovernmentForm='Constitutional Monarchy, Federation';
+----------+
| count(1) |
+----------+
|       90 |
+----------+
1 row in set (0.03 sec)

mysql> select count(1) from city join country on city.CountryCode=country.Code where country.GovernmentForm LIKE '%Constitutional Monarchy%'
    -> ;
+----------+
| count(1) |
+----------+
|      611 |
+----------+
1 row in set (0.16 sec)

mysql> select count(1) from city join country on city.CountryCode=country.Code where country.GovernmentForm = 'Constitutional Monarchy (Emirate)';
+----------+
| count(1) |
+----------+
|        3 |
+----------+
1 row in set (0.03 sec)

mysql> select ct.Name from city ct join country cy on ct.CountryCode=cy.Code where ct.population BETWEEN 13000 AND 500000 and cy.GovernmentForm!='Republic' and cy.Code not in (select CountryCode from countrylanguage where Language='English' and IsOfficial='T') order by rand() limit 5;
+----------------+
| Name           |
+----------------+
| Miyakonojo     |
| Isesaki        |
| Khamis Mushayt |
| Cienfuegos     |
| Godhra         |
+----------------+
5 rows in set (0.03 sec)

mysql> select ct.Name from city ct join country cy on ct.CountryCode=cy.Code where ct.population BETWEEN 13000 AND 500000 and cy.GovernmentForm not LIKE '%Republic%' and cy.Code not in (select CountryCode from countrylanguage where Language='English' and IsOfficial='T') order by rand() limit 5;
+-----------+
| Name      |
+-----------+
| Sayama    |
| Masqat    |
| Dordrecht |
| Hakodate  |
| Portmore  |
+-----------+
5 rows in set (0.18 sec)

mysql> use ro_research1;
Database changed

mysql> show tables;
+------------------------+
| Tables_in_ro_research1 |
+------------------------+
| day_entity             |
| fitbit_day_detail      |
| fitbit_hr              |
| fitbit_sleep           |
| goal_entity            |
| suth_user              |
| track_entity           |
| users_field_data       |
+------------------------+
8 rows in set (0.03 sec)

mysql> desc suth_user;
+-----------+------------------+------+-----+---------+----------------+
| Field     | Type             | Null | Key | Default | Extra          |
+-----------+------------------+------+-----+---------+----------------+
| id        | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| user_id   | int(10) unsigned | NO   | MUL | NULL    |                |
| startdate | varchar(50)      | YES  |     | NULL    |                |
| ptstatus  | varchar(50)      | YES  |     | NULL    |                |
+-----------+------------------+------+-----+---------+----------------+
4 rows in set (0.02 sec)

mysql> desc day_entity;
+----------------+------------------+------+-----+---------+----------------+
| Field          | Type             | Null | Key | Default | Extra          |
+----------------+------------------+------+-----+---------+----------------+
| id             | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| user_id        | int(10) unsigned | NO   | MUL | NULL    |                |
| created        | int(11)          | YES  |     | NULL    |                |
| changed        | int(11)          | YES  |     | NULL    |                |
| fitbit_date    | date             | YES  |     | NULL    |                |
| fitbit_steps   | int(11)          | YES  |     | NULL    |                |
| fitbit_goal    | int(11)          | YES  |     | NULL    |                |
| fitbit_veryacm | int(11)          | YES  |     | NULL    |                |
| fitbit_fairacm | int(11)          | YES  |     | NULL    |                |
| fitbit_ligham  | int(11)          | YES  |     | NULL    |                |
| fitbit_sedmin  | int(11)          | YES  |     | NULL    |                |
+----------------+------------------+------+-----+---------+----------------+
11 rows in set (0.03 sec)

mysql> select s.user_id, s.ptstatus, d.fitbit_date, d.fitbit_steps, (d.fitbit_goal-d.fitbit_steps) as "distance from goal" from suth_user s left join day_entity d on s.user_id = d.user_id;
+---------+----------+-------------+--------------+--------------------+
| user_id | ptstatus | fitbit_date | fitbit_steps | distance from goal |
+---------+----------+-------------+--------------+--------------------+
|     907 | Active   | NULL        |         NULL |               NULL |
|      77 | Active   | NULL        |         NULL |               NULL |
|     458 | Active   | NULL        |         NULL |               NULL |
|     197 | aw       | NULL        |         NULL |               NULL |
|     540 | Active   | NULL        |         NULL |               NULL |
|     250 | Active   | NULL        |         NULL |               NULL |
|     558 | Active   | NULL        |         NULL |               NULL |
|     178 | Active   | NULL        |         NULL |               NULL |
|     148 | Active   | 2019-07-07  |        11563 |              -1563 |
|     148 | Active   | 2019-07-06  |         2325 |               7675 |
|     148 | Active   | 2019-07-05  |        14282 |              -4282 |
|     148 | Active   | 2019-07-04  |         5441 |               4559 |
|     148 | Active   | 2019-07-03  |         6743 |               3257 |
|     148 | Active   | 2019-07-02  |        14331 |              -4331 |
|     148 | Active   | 2019-07-01  |        15560 |              -5560 |
|     148 | Active   | 2019-06-30  |         1600 |               8400 |
|     148 | Active   | 2019-06-29  |         1242 |               8758 |
|     148 | Active   | 2019-06-28  |        12831 |              -2831 |
|     148 | Active   | 2019-06-27  |        13471 |              -3471 |
|     148 | Active   | 2019-06-26  |        18065 |              -8065 |
|     148 | Active   | 2019-06-25  |        10748 |               -748 |
|     148 | Active   | 2019-06-24  |         8084 |               1916 |
|     148 | Active   | 2019-06-23  |            0 |              10000 |
|     148 | Active   | 2019-06-22  |            0 |              10000 |
|     148 | Active   | 2019-06-21  |            0 |              10000 |
|     148 | Active   | 2019-06-20  |            0 |              10000 |
|     148 | Active   | 2019-06-19  |            0 |              10000 |
|     148 | Active   | 2019-06-18  |            0 |              10000 |
|     148 | Active   | 2019-06-17  |            0 |              10000 |
|     148 | Active   | 2019-06-16  |            0 |              10000 |
|     148 | Active   | 2019-06-15  |            0 |              10000 |
|     148 | Active   | 2019-06-14  |            0 |              10000 |
|     148 | Active   | 2019-06-13  |            0 |              10000 |
|     148 | Active   | 2019-06-12  |            0 |              10000 |
|     148 | Active   | 2019-06-11  |            0 |              10000 |
|     148 | Active   | 2019-06-10  |            0 |              10000 |
|     148 | Active   | 2019-06-09  |            0 |              10000 |
|     148 | Active   | 2019-06-08  |            0 |              10000 |
|     148 | Active   | 2019-06-07  |            0 |              10000 |
|     148 | Active   | 2019-06-06  |            0 |              10000 |
|     148 | Active   | 2019-06-05  |            0 |              10000 |
|     148 | Active   | 2019-06-04  |            0 |              10000 |
|     148 | Active   | 2019-06-03  |            0 |              10000 |
|     148 | Active   | 2019-06-02  |            0 |              10000 |
|     148 | Active   | 2019-06-01  |            0 |              10000 |
|     148 | Active   | 2019-05-31  |            0 |              10000 |
|     148 | Active   | 2019-07-08  |        10577 |               -577 |
|     148 | Active   | 2019-07-09  |         6824 |               3176 |
|     148 | Active   | 2019-07-10  |         5877 |               4123 |
|     148 | Active   | 2019-07-11  |         7855 |               2145 |
|     148 | Active   | 2019-07-13  |         9646 |                354 |
|     148 | Active   | 2019-07-12  |        12310 |              -2310 |
|     148 | Active   | 2019-07-14  |         9731 |              -1231 |
|     148 | Active   | 2019-07-15  |         8892 |               -392 |
|     148 | Active   | 2019-07-16  |         8736 |               -236 |
|     148 | Active   | 2019-07-17  |         6458 |               2042 |
|     148 | Active   | 2019-07-18  |         5271 |               3229 |
|     148 | Active   | 2019-07-19  |        13271 |              -4771 |
|     148 | Active   | 2019-07-20  |        21445 |             -12945 |
|     148 | Active   | 2019-07-21  |        15315 |              -6415 |
|     148 | Active   | 2019-07-22  |         9244 |               -344 |
|     148 | Active   | 2019-07-23  |        11465 |              -2565 |
|     148 | Active   | 2019-07-24  |        11323 |              -2423 |
|     148 | Active   | 2019-07-25  |         7154 |               1746 |
|     148 | Active   | 2019-07-26  |         9181 |               -281 |
|     148 | Active   | 2019-07-27  |        20571 |             -11671 |
|     148 | Active   | 2019-07-28  |         1967 |               7333 |
|     148 | Active   | 2019-07-29  |         9427 |               -127 |
|     148 | Active   | 2019-07-30  |         6519 |               2781 |
|     148 | Active   | 2019-07-31  |        18226 |              -8926 |
|     148 | Active   | 2019-08-01  |         6319 |               2981 |
|     148 | Active   | 2019-08-02  |        10644 |              -1344 |
|     148 | Active   | 2019-08-04  |        10227 |               -527 |
|     148 | Active   | 2019-08-03  |         8983 |                317 |
|     148 | Active   | 2019-08-05  |        14461 |              -4761 |
|     148 | Active   | 2019-08-06  |        12183 |              -2483 |
|     148 | Active   | 2019-08-07  |        12334 |              -2634 |
|     148 | Active   | 2019-08-08  |          488 |               9212 |
|     148 | Active   | 2019-08-09  |        15481 |              -5781 |
|     148 | Active   | 2019-08-10  |        19690 |              -9990 |
|     148 | Active   | 2019-08-11  |        17400 |              -7400 |
|     148 | Active   | 2019-08-12  |        14436 |              -4436 |
|     148 | Active   | 2019-08-14  |         9893 |                107 |
|     148 | Active   | 2019-08-13  |        16070 |              -6070 |
|     148 | Active   | 2019-08-16  |         5229 |               4771 |
|     148 | Active   | 2019-08-15  |        14609 |              -4609 |
|     148 | Active   | 2019-08-17  |          713 |               9287 |
|     148 | Active   | 2019-08-18  |         4025 |               5975 |
|     148 | Active   | 2019-08-19  |         7287 |               2713 |
|     148 | Active   | 2019-08-20  |        13146 |              -3146 |
|     148 | Active   | 2019-08-21  |        11852 |              -1852 |
|     148 | Active   | 2019-08-22  |        13102 |              -3102 |
|     148 | Active   | 2019-08-23  |         6084 |               3916 |
|     148 | Active   | 2019-08-24  |          154 |               9846 |
|     148 | Active   | 2019-08-25  |         5819 |               3781 |
|     148 | Active   | 2019-08-26  |            0 |               9600 |
|     148 | Active   | 2019-08-27  |        13253 |              -3653 |
|     148 | Active   | 2019-08-28  |        11921 |              -2321 |
|     148 | Active   | 2019-08-29  |        15024 |              -5424 |
|     148 | Active   | 2019-08-30  |        12014 |              -2414 |
|     148 | Active   | 2019-08-31  |        16989 |              -7389 |
|     148 | Active   | 2019-09-01  |         8075 |               1925 |
|     148 | Active   | 2019-09-02  |        12853 |              -2853 |
|     148 | Active   | 2019-09-04  |         8651 |               1349 |
|     148 | Active   | 2019-09-03  |        12456 |              -2456 |
|     148 | Active   | 2019-09-05  |        10864 |               -864 |
|     148 | Active   | 2019-09-06  |         7012 |               2988 |
|     148 | Active   | 2019-09-08  |         9525 |                275 |
|     148 | Active   | 2019-09-09  |         8593 |               1207 |
|     148 | Active   | 2019-09-07  |         7485 |               2515 |
|     148 | Active   | 2019-09-10  |        10864 |              -1064 |
|     148 | Active   | 2019-09-11  |        10028 |               -228 |
|     148 | Active   | 2019-09-12  |         8336 |               1464 |
|     148 | Active   | 2019-09-13  |        14054 |              -4254 |
|     148 | Active   | 2019-09-14  |         6626 |               3174 |
|     148 | Active   | 2019-09-15  |         9115 |                885 |
|     148 | Active   | 2019-09-16  |         7928 |               2072 |
|     148 | Active   | 2019-09-17  |         8664 |               1336 |
|     148 | Active   | 2019-09-18  |        10108 |               -108 |
|     148 | Active   | 2019-09-19  |        16697 |              -6697 |
|     148 | Active   | 2019-09-20  |        14501 |              -4501 |
|     148 | Active   | 2019-09-21  |          392 |               9608 |
|     148 | Active   | 2019-09-22  |        10966 |               -966 |
|     148 | Active   | 2019-09-23  |        11089 |              -1089 |
|     148 | Active   | 2019-09-24  |         7599 |               2401 |
|     148 | Active   | 2019-09-25  |        11696 |              -1696 |
|     148 | Active   | 2019-09-26  |         3735 |               6265 |
|     148 | Active   | 2019-09-27  |        13767 |              -3767 |
|     148 | Active   | 2019-09-28  |        12132 |              -2132 |
|     148 | Active   | 2019-09-29  |         8107 |               1593 |
|     148 | Active   | 2019-09-30  |         9637 |                 63 |
|     148 | Active   | 2019-10-01  |         5260 |               4440 |
|     148 | Active   | 2019-10-02  |         5180 |               4520 |
|     148 | Active   | 2019-10-03  |        28731 |             -19031 |
|     148 | Active   | 2019-10-04  |        18379 |              -8679 |
|     148 | Active   | 2019-10-05  |        18843 |              -9143 |
|     148 | Active   | 2019-10-06  |         5867 |               4133 |
|     148 | Active   | 2019-10-07  |         7396 |               2604 |
|     148 | Active   | 2019-10-08  |         8944 |               1056 |
|     148 | Active   | 2019-10-09  |        12981 |              -2981 |
|     148 | Active   | 2019-10-10  |        13657 |              -3657 |
|     148 | Active   | 2019-10-11  |         9762 |                238 |
|     148 | Active   | 2019-10-12  |        23527 |             -13527 |
|     148 | Active   | 2019-10-13  |         4582 |               5418 |
|     148 | Active   | 2019-10-14  |        12999 |              -2999 |
|     148 | Active   | 2019-10-15  |         9764 |                236 |
|     148 | Active   | 2019-10-16  |        11931 |              -1931 |
|     148 | Active   | 2019-10-17  |         9904 |                 96 |
|     148 | Active   | 2019-10-18  |        10215 |               -215 |
|     148 | Active   | 2019-10-19  |        10001 |                 -1 |
|     148 | Active   | 2019-10-20  |         5666 |               4334 |
|     148 | Active   | 2019-10-21  |         6290 |               3710 |
|     148 | Active   | 2019-10-22  |        10128 |               -128 |
|     148 | Active   | 2019-10-23  |        14078 |              -4078 |
|     148 | Active   | 2019-10-25  |         3983 |               6017 |
|     148 | Active   | 2019-10-24  |         8637 |               1363 |
|     148 | Active   | 2019-10-26  |        11000 |              -1000 |
|     148 | Active   | 2019-10-27  |         4884 |               3516 |
|     148 | Active   | 2019-10-28  |        10527 |              -2127 |
|     148 | Active   | 2019-10-30  |        14104 |              -5704 |
|     148 | Active   | 2019-10-31  |        10503 |              -2103 |
|     148 | Active   | 2019-10-29  |        12258 |              -3858 |
|     148 | Active   | 2019-11-01  |         9464 |              -1064 |
|     148 | Active   | 2019-11-02  |         9202 |               -802 |
|     148 | Active   | 2019-11-03  |         9072 |               -272 |
|     148 | Active   | 2019-11-04  |         7551 |               1249 |
|     148 | Active   | 2019-11-05  |        15208 |              -6408 |
|     148 | Active   | 2019-11-06  |        14872 |              -6072 |
|     148 | Active   | 2019-11-07  |         9506 |               -706 |
|     148 | Active   | 2019-11-08  |        13390 |              -4590 |
|     148 | Active   | 2019-11-09  |         2601 |               6199 |
|     148 | Active   | 2019-11-10  |         4872 |               4328 |
|     148 | Active   | 2019-11-11  |        10570 |              -1370 |
|     148 | Active   | 2019-11-12  |        12230 |              -3030 |
|     148 | Active   | 2019-11-13  |         7310 |               1890 |
|     148 | Active   | 2019-11-14  |         6389 |               2811 |
|     148 | Active   | 2019-11-15  |         9673 |               -473 |
|     148 | Active   | 2019-11-16  |         7502 |               1698 |
|     148 | Active   | 2019-11-17  |         6222 |               2178 |
|     148 | Active   | 2019-11-18  |         6294 |               2106 |
|     148 | Active   | 2019-11-19  |         9490 |              -1090 |
|     148 | Active   | 2019-11-20  |        12219 |              -3819 |
|     148 | Active   | 2019-11-21  |         5601 |               2799 |
|     148 | Active   | 2019-11-22  |        12632 |              -4232 |
|     148 | Active   | 2019-11-23  |         9156 |               -756 |
|     207 | Active   | 2019-07-01  |         5372 |              -4972 |
|     207 | Active   | 2019-07-10  |        11512 |             -11112 |
|     207 | Active   | 2019-07-09  |         4320 |              -3920 |
|     207 | Active   | 2019-07-11  |        14928 |             -14528 |
|     207 | Active   | 2019-07-13  |            0 |                400 |
|     207 | Active   | 2019-07-12  |         7362 |              -6962 |
|     207 | Active   | 2019-07-14  |            0 |                400 |
|     207 | Active   | 2019-07-17  |         3294 |              -2894 |
|     207 | Active   | 2019-07-16  |         5598 |              -5198 |
|     207 | Active   | 2019-07-15  |         2781 |              -2381 |
|     207 | Active   | 2019-07-19  |         7009 |              -6609 |
|     207 | Active   | 2019-07-18  |        10659 |             -10259 |
|     207 | Active   | 2019-07-20  |         1510 |              -1110 |
|     207 | Active   | 2019-07-22  |            0 |                800 |
|     207 | Active   | 2019-07-24  |         5265 |              -4465 |
|     207 | Active   | 2019-07-23  |         7537 |              -6737 |
|     207 | Active   | 2019-07-21  |            0 |                800 |
|     207 | Active   | 2019-07-28  |            0 |               1200 |
|     207 | Active   | 2019-07-29  |         5067 |              -3867 |
|     207 | Active   | 2019-07-30  |         1037 |                163 |
|     207 | Active   | 2019-07-25  |         4516 |              -3716 |
|     207 | Active   | 2019-07-27  |         1558 |               -758 |
|     207 | Active   | 2019-07-26  |         2516 |              -1716 |
|     207 | Active   | 2019-08-01  |        11343 |             -10143 |
|     207 | Active   | 2019-08-05  |         5463 |              -3863 |
|     207 | Active   | 2019-07-31  |         1671 |               -471 |
|     207 | Active   | 2019-08-03  |            0 |               1200 |
|     207 | Active   | 2019-08-06  |         7459 |              -5859 |
|     207 | Active   | 2019-08-02  |         2137 |               -937 |
|     207 | Active   | 2019-08-04  |            0 |               1600 |
|     207 | Active   | 2019-08-14  |        18368 |             -16368 |
|     207 | Active   | 2019-08-07  |        12587 |             -10987 |
|     207 | Active   | 2019-08-13  |            0 |               2000 |
|     207 | Active   | 2019-08-15  |         7278 |              -5278 |
|     207 | Active   | 2019-08-12  |          749 |               1251 |
|     207 | Active   | 2019-08-08  |         1334 |                266 |
|     207 | Active   | 2019-08-09  |         4375 |              -2775 |
|     207 | Active   | 2019-08-10  |            0 |               1600 |
|     207 | Active   | 2019-08-11  |            0 |               2000 |
|     207 | Active   | 2019-08-23  |          767 |               1633 |
|     207 | Active   | 2019-08-18  |            0 |               2400 |
|     207 | Active   | 2019-08-16  |          649 |               1351 |
|     207 | Active   | 2019-08-25  |            0 |               2400 |
|     207 | Active   | 2019-08-17  |            0 |               2000 |
|     207 | Active   | 2019-08-24  |            0 |               2400 |
|     207 | Active   | 2019-08-21  |          738 |               1662 |
|     207 | Active   | 2019-08-22  |         1545 |                855 |
|     207 | Active   | 2019-08-27  |         7651 |              -5251 |
|     207 | Active   | 2019-08-20  |          922 |               1478 |
|     207 | Active   | 2019-08-26  |          586 |               1814 |
|     207 | Active   | 2019-08-19  |            7 |               2393 |
|     207 | Active   | 2019-09-17  |         3127 |               -327 |
|     207 | Active   | 2019-09-03  |          474 |               2326 |
|     207 | Active   | 2019-09-24  |         4564 |              -1764 |
|     207 | Active   | 2019-09-23  |         1530 |               1270 |
|     207 | Active   | 2019-09-02  |          852 |               1948 |
|     207 | Active   | 2019-09-26  |         3566 |               -766 |
|     207 | Active   | 2019-09-19  |         6489 |              -3689 |
|     207 | Active   | 2019-08-31  |            0 |               2400 |
|     207 | Active   | 2019-09-18  |         8230 |              -5430 |
|     207 | Active   | 2019-09-04  |         3742 |               -942 |
|     207 | Active   | 2019-09-29  |            0 |               2800 |
|     207 | Active   | 2019-09-20  |         4515 |              -1715 |
|     207 | Active   | 2019-08-28  |         4181 |              -1781 |
|     207 | Active   | 2019-08-29  |            0 |               2400 |
|     207 | Active   | 2019-09-15  |            0 |               2800 |
|     207 | Active   | 2019-09-14  |            0 |               2800 |
|     207 | Active   | 2019-09-28  |            0 |               2800 |
|     207 | Active   | 2019-08-30  |            0 |               2400 |
|     207 | Active   | 2019-09-22  |            0 |               2800 |
|     207 | Active   | 2019-09-13  |         1658 |               1142 |
|     207 | Active   | 2019-09-12  |            0 |               2800 |
|     207 | Active   | 2019-09-25  |         1767 |               1033 |
|     207 | Active   | 2019-09-27  |         3142 |               -342 |
|     207 | Active   | 2019-09-16  |          689 |               2111 |
|     207 | Active   | 2019-09-01  |          121 |               2679 |
|     207 | Active   | 2019-09-21  |            0 |               2800 |
|     207 | Active   | 2019-10-05  |            0 |               2800 |
|     207 | Active   | 2019-10-10  |          838 |               2262 |
|     207 | Active   | 2019-10-14  |            0 |               3100 |
|     207 | Active   | 2019-10-03  |         5883 |              -3083 |
|     207 | Active   | 2019-10-13  |            0 |               3100 |
|     207 | Active   | 2019-10-06  |            0 |               3100 |
|     207 | Active   | 2019-10-08  |         4579 |              -1479 |
|     207 | Active   | 2019-10-07  |            0 |               3100 |
|     207 | Active   | 2019-10-15  |        11987 |              -8887 |
|     207 | Active   | 2019-10-12  |            0 |               3100 |
|     207 | Active   | 2019-10-02  |         1959 |                841 |
|     207 | Active   | 2019-10-04  |         5158 |              -2358 |
|     207 | Active   | 2019-10-01  |         5803 |              -3003 |
|     207 | Active   | 2019-10-09  |         4578 |              -1478 |
|     207 | Active   | 2019-09-30  |          467 |               2333 |
|     207 | Active   | 2019-10-11  |         3381 |               -281 |
|     207 | Active   | 2019-10-16  |        11366 |              -8266 |
|     207 | Active   | 2019-10-25  |            0 |               3500 |
|     207 | Active   | 2019-10-18  |            7 |               3093 |
|     207 | Active   | 2019-10-23  |         5174 |              -1674 |
|     207 | Active   | 2019-10-17  |        15533 |             -12433 |
|     207 | Active   | 2019-10-29  |         6523 |              -3023 |
|     207 | Active   | 2019-10-24  |         6592 |              -3092 |
|     207 | Active   | 2019-10-22  |         6026 |              -2526 |
|     207 | Active   | 2019-10-19  |            0 |               3100 |
|     207 | Active   | 2019-10-26  |           12 |               3488 |
|     207 | Active   | 2019-10-21  |          705 |               2795 |
|     207 | Active   | 2019-10-28  |            0 |               3500 |
|     207 | Active   | 2019-10-20  |            0 |               3500 |
|     207 | Active   | 2019-10-27  |            0 |               3500 |
|     207 | Active   | 2019-10-30  |           14 |               3486 |
|     592 | aw       | 2019-07-07  |         3901 |               6099 |
|     592 | aw       | 2019-07-06  |         9375 |                625 |
|     592 | aw       | 2019-07-05  |         3669 |               6331 |
|     592 | aw       | 2019-07-04  |         4914 |               5086 |
|     592 | aw       | 2019-07-03  |         8454 |               1546 |
|     592 | aw       | 2019-07-02  |         9503 |                497 |
|     592 | aw       | 2019-07-01  |         8537 |               1463 |
|     592 | aw       | 2019-06-30  |        24524 |             -14524 |
|     592 | aw       | 2019-06-29  |        22342 |             -12342 |
|     592 | aw       | 2019-06-28  |        20262 |             -10262 |
|     592 | aw       | 2019-06-27  |        20081 |             -10081 |
|     592 | aw       | 2019-06-26  |        10094 |                -94 |
|     592 | aw       | 2019-06-25  |        12324 |              -2324 |
|     592 | aw       | 2019-06-24  |        13212 |              -3212 |
|     592 | aw       | 2019-06-23  |         4314 |               5686 |
|     592 | aw       | 2019-06-22  |         7030 |               2970 |
|     592 | aw       | 2019-06-21  |         4720 |               5280 |
|     592 | aw       | 2019-06-20  |        13313 |              -3313 |
|     592 | aw       | 2019-06-19  |        13518 |              -3518 |
|     592 | aw       | 2019-06-18  |        12443 |              -2443 |
|     592 | aw       | 2019-06-17  |        10652 |               -652 |
|     592 | aw       | 2019-06-16  |         2144 |               7856 |
|     592 | aw       | 2019-06-15  |         3769 |               6231 |
|     592 | aw       | 2019-06-14  |         4183 |               5817 |
|     592 | aw       | 2019-06-13  |        10881 |               -881 |
|     592 | aw       | 2019-06-12  |         7656 |               2344 |
|     592 | aw       | 2019-06-11  |         7150 |               2850 |
|     592 | aw       | 2019-06-10  |         9095 |                905 |
|     592 | aw       | 2019-06-09  |         1915 |               8085 |
|     592 | aw       | 2019-06-08  |        10745 |               -745 |
|     592 | aw       | 2019-06-07  |         4611 |               5389 |
|     592 | aw       | 2019-06-06  |        11236 |              -1236 |
|     592 | aw       | 2019-06-05  |        10081 |                -81 |
|     592 | aw       | 2019-06-04  |         8938 |               1062 |
|     592 | aw       | 2019-06-03  |        12107 |              -2107 |
|     592 | aw       | 2019-06-02  |        10346 |               -346 |
|     592 | aw       | 2019-06-01  |         4157 |               5843 |
|     592 | aw       | 2019-05-31  |        13283 |              -3283 |
|     592 | aw       | 2019-07-08  |        12709 |              -2709 |
|     592 | aw       | 2019-07-09  |         7432 |               2568 |
|     592 | aw       | 2019-07-10  |        12674 |              -2674 |
|     592 | aw       | 2019-07-11  |        11951 |              -1951 |
|     592 | aw       | 2019-07-12  |         1810 |               8190 |
|     592 | aw       | 2019-07-13  |        12316 |              -2316 |
|     592 | aw       | 2019-07-14  |         7757 |               2243 |
|     592 | aw       | 2019-07-15  |         9969 |                 31 |
|     592 | aw       | 2019-07-16  |        10246 |               -246 |
|     592 | aw       | 2019-07-17  |        10246 |               -246 |
|     592 | aw       | 2019-07-18  |        10463 |               -463 |
|     592 | aw       | 2019-07-19  |         3099 |               6901 |
|     592 | aw       | 2019-07-20  |         9908 |                 92 |
|     592 | aw       | 2019-07-21  |         6804 |               3196 |
|     592 | aw       | 2019-07-22  |        10379 |               -379 |
|     592 | aw       | 2019-07-23  |         8119 |               1881 |
|     592 | aw       | 2019-07-24  |        12375 |              -2375 |
|     592 | aw       | 2019-07-25  |        12585 |              -2585 |
|     592 | aw       | 2019-07-26  |         3287 |               6713 |
|     592 | aw       | 2019-07-27  |         7885 |               2115 |
|     592 | aw       | 2019-07-28  |         7429 |               2571 |
|     592 | aw       | 2019-07-29  |        11494 |              -1494 |
|     592 | aw       | 2019-07-30  |        10966 |               -966 |
|     592 | aw       | 2019-07-31  |        10553 |               -553 |
|     592 | aw       | 2019-08-01  |        10563 |               -563 |
|     592 | aw       | 2019-08-02  |         6163 |               3837 |
|     592 | aw       | 2019-08-03  |        10521 |               -521 |
|     592 | aw       | 2019-08-04  |         3789 |               6211 |
|     592 | aw       | 2019-08-05  |        10100 |               -100 |
|     592 | aw       | 2019-08-06  |        10985 |               -985 |
|     592 | aw       | 2019-08-07  |        17441 |              -7441 |
|     592 | aw       | 2019-08-08  |        12482 |              -2482 |
|     592 | aw       | 2019-08-09  |         5869 |               4131 |
|     592 | aw       | 2019-08-10  |        12014 |              -2014 |
|     592 | aw       | 2019-08-11  |         5774 |               4226 |
|     592 | aw       | 2019-08-12  |        10611 |               -611 |
|     592 | aw       | 2019-08-13  |         2123 |               7877 |
|     592 | aw       | 2019-08-14  |        17846 |              -7846 |
|     592 | aw       | 2019-08-17  |         5171 |               4829 |
|     592 | aw       | 2019-08-16  |         3122 |               6878 |
|     592 | aw       | 2019-08-15  |        10066 |                -66 |
|     592 | aw       | 2019-08-18  |         4177 |               5823 |
|     592 | aw       | 2019-08-19  |        10180 |               -180 |
|     592 | aw       | 2019-08-20  |        11422 |              -1422 |
|     592 | aw       | 2019-08-21  |        15098 |              -5098 |
|     592 | aw       | 2019-08-22  |        13788 |              -3788 |
|     592 | aw       | 2019-08-23  |         4248 |               5752 |
|     592 | aw       | 2019-08-24  |         8233 |               1767 |
|     592 | aw       | 2019-08-25  |         3774 |               6226 |
|     592 | aw       | 2019-08-26  |        13054 |              -3054 |
|     592 | aw       | 2019-08-27  |        10668 |               -668 |
|     592 | aw       | 2019-08-28  |        16774 |              -6774 |
|     592 | aw       | 2019-08-29  |        14548 |              -4548 |
|     592 | aw       | 2019-08-31  |         9823 |                177 |
|     592 | aw       | 2019-08-30  |         2760 |               7240 |
|     592 | aw       | 2019-09-01  |        12023 |              -2023 |
|     592 | aw       | 2019-09-02  |         5278 |               4722 |
|     592 | aw       | 2019-09-03  |        12507 |              -2507 |
|     592 | aw       | 2019-09-04  |        14465 |              -4465 |
|     592 | aw       | 2019-09-05  |        13040 |              -3040 |
|     592 | aw       | 2019-09-06  |        12038 |              -2038 |
|     592 | aw       | 2019-09-07  |        10668 |               -668 |
|     592 | aw       | 2019-09-08  |         7853 |               2147 |
|     592 | aw       | 2019-09-09  |        12415 |              -2415 |
|     592 | aw       | 2019-09-10  |         9122 |                878 |
|     592 | aw       | 2019-09-11  |        13412 |              -3412 |
|     592 | aw       | 2019-09-12  |         9290 |                710 |
|     592 | aw       | 2019-09-14  |         3777 |               6223 |
|     592 | aw       | 2019-09-13  |        15219 |              -5219 |
|     592 | aw       | 2019-09-15  |         8295 |               1705 |
|     592 | aw       | 2019-09-16  |         7837 |               2163 |
|     592 | aw       | 2019-09-17  |        10216 |               -216 |
|     592 | aw       | 2019-09-18  |        10750 |               -750 |
|     592 | aw       | 2019-09-19  |        16538 |              -6538 |
|     592 | aw       | 2019-09-20  |        16885 |              -6885 |
|     592 | aw       | 2019-09-21  |        13456 |              -3456 |
|     592 | aw       | 2019-09-22  |         5000 |               5000 |
|     592 | aw       | 2019-09-23  |         6752 |               3248 |
|     592 | aw       | 2019-09-24  |        13703 |              -3703 |
|     592 | aw       | 2019-09-25  |        13115 |              -3115 |
|     592 | aw       | 2019-09-26  |         9806 |                194 |
|     592 | aw       | 2019-09-27  |         3202 |               6798 |
|     592 | aw       | 2019-09-28  |         4872 |               5128 |
|     592 | aw       | 2019-09-29  |         3818 |               6182 |
|     592 | aw       | 2019-09-30  |         6746 |               3254 |
|     592 | aw       | 2019-10-01  |        11966 |              -1966 |
|     592 | aw       | 2019-10-02  |         8207 |               1793 |
|     592 | aw       | 2019-10-03  |        10798 |               -798 |
|     592 | aw       | 2019-10-06  |         2887 |               7113 |
|     592 | aw       | 2019-10-05  |         7858 |               2142 |
|     592 | aw       | 2019-10-04  |        11715 |              -1715 |
|     592 | aw       | 2019-10-07  |        12313 |              -2313 |
|     592 | aw       | 2019-10-08  |        13868 |              -3868 |
|     592 | aw       | 2019-10-09  |        14140 |              -4140 |
|     592 | aw       | 2019-10-10  |        11819 |              -1819 |
|     592 | aw       | 2019-10-11  |        10182 |               -182 |
|     592 | aw       | 2019-10-12  |         2840 |               7160 |
|     592 | aw       | 2019-10-13  |         6033 |               3967 |
|     592 | aw       | 2019-10-14  |         7035 |               2965 |
|     592 | aw       | 2019-10-15  |        11194 |              -1194 |
|     592 | aw       | 2019-10-16  |         7806 |               2194 |
|     592 | aw       | 2019-10-17  |         8576 |               1424 |
|     592 | aw       | 2019-10-18  |        15703 |              -5703 |
|     592 | aw       | 2019-10-19  |        11780 |              -1780 |
|     592 | aw       | 2019-10-20  |        18143 |              -8143 |
|     592 | aw       | 2019-10-21  |         8700 |               1300 |
|     592 | aw       | 2019-10-22  |        12243 |              -2243 |
|     592 | aw       | 2019-10-23  |        18563 |              -8563 |
|     592 | aw       | 2019-10-24  |        12759 |              -2759 |
|     592 | aw       | 2019-10-25  |        10132 |               -132 |
|     592 | aw       | 2019-10-27  |         4267 |               5733 |
|     592 | aw       | 2019-10-26  |         2414 |               7586 |
|     592 | aw       | 2019-10-28  |        11751 |              -1751 |
|     592 | aw       | 2019-10-29  |        10365 |               -365 |
|     592 | aw       | 2019-10-30  |         9953 |                 47 |
|     592 | aw       | 2019-10-31  |        11557 |              -1557 |
|     592 | aw       | 2019-11-01  |        10892 |               -892 |
|     592 | aw       | 2019-11-02  |         7202 |               2798 |
|     592 | aw       | 2019-11-03  |         5094 |               4906 |
|     592 | aw       | 2019-11-04  |        11778 |              -1778 |
|     592 | aw       | 2019-11-05  |         9335 |                665 |
|     592 | aw       | 2019-11-06  |        10741 |               -741 |
|     592 | aw       | 2019-11-07  |        17268 |              -7268 |
|     592 | aw       | 2019-11-08  |         9809 |                191 |
|     592 | aw       | 2019-11-09  |         6222 |               3778 |
|     592 | aw       | 2019-11-10  |         2665 |               7335 |
|     592 | aw       | 2019-11-11  |        16555 |              -6555 |
|     592 | aw       | 2019-11-13  |         1606 |               8394 |
|     592 | aw       | 2019-11-12  |         7399 |               2601 |
|     592 | aw       | 2019-11-14  |         9685 |                315 |
|     592 | aw       | 2019-11-15  |        12505 |              -2505 |
|     592 | aw       | 2019-11-16  |        22707 |             -12707 |
|     592 | aw       | 2019-11-17  |        16785 |              -6785 |
|     592 | aw       | 2019-11-18  |         7111 |               2889 |
|     592 | aw       | 2019-11-19  |         7453 |               2547 |
|     592 | aw       | 2019-11-20  |        13119 |              -3119 |
|     592 | aw       | 2019-11-21  |        10021 |                -21 |
|     592 | aw       | 2019-11-22  |         7036 |               2964 |
|     475 | aw       | 2019-07-20  |         5622 |               4378 |
|     475 | aw       | 2019-07-21  |        14602 |              -4602 |
|     475 | aw       | 2019-07-22  |        10814 |               -814 |
|     475 | aw       | 2019-07-23  |         5897 |               4103 |
|     475 | aw       | 2019-07-24  |        18393 |              -8393 |
|     475 | aw       | 2019-07-25  |         8447 |               1553 |
|     475 | aw       | 2019-07-26  |         7598 |               2402 |
|     475 | aw       | 2019-07-27  |        21484 |             -11484 |
|     475 | aw       | 2019-07-28  |         2352 |               7648 |
|     475 | aw       | 2019-07-29  |        11366 |              -1366 |
|     475 | aw       | 2019-07-30  |        10878 |               -878 |
|     475 | aw       | 2019-07-31  |        11169 |              -1169 |
|     475 | aw       | 2019-08-01  |        10004 |                 -4 |
|     475 | aw       | 2019-08-02  |        10091 |                -91 |
|     475 | aw       | 2019-08-03  |        10941 |               -941 |
|     475 | aw       | 2019-08-04  |         9446 |                554 |
|     475 | aw       | 2019-08-05  |        11139 |              -1139 |
|     475 | aw       | 2019-08-06  |        12645 |              -2645 |
|     475 | aw       | 2019-08-07  |        11648 |              -1648 |
|     475 | aw       | 2019-08-08  |        10430 |               -430 |
|     475 | aw       | 2019-08-09  |           16 |               9984 |
|     475 | aw       | 2019-08-10  |            0 |              10000 |
|     475 | aw       | 2019-08-11  |        14456 |              -4456 |
|     475 | aw       | 2019-08-12  |        14152 |              -4152 |
|     475 | aw       | 2019-08-13  |        13451 |              -3451 |
|     475 | aw       | 2019-08-14  |        11947 |              -1947 |
|     475 | aw       | 2019-08-15  |        10917 |               -917 |
|     475 | aw       | 2019-08-16  |        10728 |               -728 |
|     475 | aw       | 2019-08-17  |         7202 |               2798 |
|     475 | aw       | 2019-08-18  |        12266 |              -2266 |
|     475 | aw       | 2019-08-19  |        11892 |              -1892 |
|     475 | aw       | 2019-08-20  |         8535 |               1465 |
|     475 | aw       | 2019-08-21  |         6203 |               3797 |
|     475 | aw       | 2019-08-22  |         9996 |                  4 |
|     475 | aw       | 2019-08-23  |         5219 |               4781 |
|     475 | aw       | 2019-08-24  |         8976 |               1024 |
|     475 | aw       | 2019-08-25  |         8813 |               1187 |
|     475 | aw       | 2019-08-26  |        11465 |              -1465 |
|     475 | aw       | 2019-08-27  |        17532 |              -7532 |
|     475 | aw       | 2019-08-28  |        11968 |              -1968 |
|     475 | aw       | 2019-08-29  |        15075 |              -5075 |
|     475 | aw       | 2019-08-30  |        15638 |              -5638 |
|     475 | aw       | 2019-08-31  |        12299 |              -2299 |
|     475 | aw       | 2019-09-01  |         9346 |                654 |
|     475 | aw       | 2019-09-02  |        11713 |              -1713 |
|     475 | aw       | 2019-09-03  |        14606 |              -4606 |
|     475 | aw       | 2019-09-04  |        15118 |              -5118 |
|     475 | aw       | 2019-09-05  |        14350 |              -4350 |
|     475 | aw       | 2019-09-06  |        13106 |              -3106 |
|     475 | aw       | 2019-09-07  |         7002 |               2998 |
|     475 | aw       | 2019-09-08  |        12523 |              -2523 |
|     475 | aw       | 2019-09-09  |         9184 |                816 |
|     475 | aw       | 2019-09-10  |        12215 |              -2215 |
|     475 | aw       | 2019-09-11  |        11515 |              -1515 |
|     475 | aw       | 2019-09-12  |        10423 |               -423 |
|     475 | aw       | 2019-09-13  |        10008 |                 -8 |
|     475 | aw       | 2019-09-14  |        11487 |              -1487 |
|     475 | aw       | 2019-09-15  |         6691 |               3309 |
|     475 | aw       | 2019-09-16  |        10137 |               -137 |
|     475 | aw       | 2019-09-17  |         8143 |               1857 |
|     475 | aw       | 2019-09-18  |        13194 |              -3194 |
|     475 | aw       | 2019-09-19  |         8196 |               1804 |
|     475 | aw       | 2019-09-20  |        11357 |              -1357 |
|     475 | aw       | 2019-09-21  |        13140 |              -3140 |
|     475 | aw       | 2019-09-22  |         9817 |                183 |
|     475 | aw       | 2019-09-23  |         9834 |                166 |
|     475 | aw       | 2019-09-24  |         9612 |                388 |
|     475 | aw       | 2019-09-25  |        11083 |              -1083 |
|     475 | aw       | 2019-09-26  |        15126 |              -5126 |
|     475 | aw       | 2019-09-27  |         6495 |               3505 |
|     475 | aw       | 2019-09-28  |        16910 |              -6910 |
|     475 | aw       | 2019-09-29  |        11043 |              -1043 |
|     475 | aw       | 2019-09-30  |        12806 |              -2806 |
|     475 | aw       | 2019-10-01  |         8984 |               1016 |
|     475 | aw       | 2019-10-02  |         8882 |               1118 |
|     475 | aw       | 2019-10-03  |         5603 |               4397 |
|     475 | aw       | 2019-10-04  |        11406 |              -1406 |
|     475 | aw       | 2019-10-05  |         9185 |                815 |
|     475 | aw       | 2019-10-06  |         8114 |               1886 |
|     601 | Active   | 2019-08-01  |         7712 |              -7312 |
|     601 | Active   | 2019-07-16  |            0 |              10000 |
|     601 | Active   | 2019-07-06  |            0 |              10000 |
|     601 | Active   | 2019-07-25  |        13013 |             -12613 |
|     601 | Active   | 2019-07-09  |            0 |              10000 |
|     601 | Active   | 2019-07-04  |            0 |              10000 |
|     601 | Active   | 2019-07-18  |        14977 |              -4977 |
|     601 | Active   | 2019-07-11  |        15413 |              -5413 |
|     601 | Active   | 2019-07-08  |            0 |              10000 |
|     601 | Active   | 2019-07-20  |            0 |              10000 |
|     601 | Active   | 2019-07-15  |            5 |               9995 |
|     601 | Active   | 2019-07-13  |         4495 |               5505 |
|     601 | Active   | 2019-07-31  |        10082 |              -9682 |
|     601 | Active   | 2019-07-22  |        10670 |             -10270 |
|     601 | Active   | 2019-08-02  |            0 |                400 |
|     601 | Active   | 2019-07-03  |         6708 |               3292 |
|     601 | Active   | 2019-07-26  |        10854 |             -10454 |
|     601 | Active   | 2019-07-12  |        10900 |               -900 |
|     601 | Active   | 2019-07-24  |        17843 |             -17443 |
|     601 | Active   | 2019-07-27  |         4774 |              -4374 |
|     601 | Active   | 2019-07-14  |            0 |              10000 |
|     601 | Active   | 2019-07-07  |            0 |              10000 |
|     601 | Active   | 2019-07-21  |            4 |                396 |
|     601 | Active   | 2019-07-05  |            0 |              10000 |
|     601 | Active   | 2019-07-28  |         4774 |              -4374 |
|     601 | Active   | 2019-07-19  |            0 |              10000 |
|     601 | Active   | 2019-07-10  |         8248 |               1752 |
|     601 | Active   | 2019-07-17  |         4932 |               5068 |
|     601 | Active   | 2019-07-29  |        11767 |             -11367 |
|     601 | Active   | 2019-08-05  |           11 |                789 |
|     601 | Active   | 2019-08-06  |            0 |                800 |
|     601 | Active   | 2019-08-03  |         6799 |              -6399 |
|     601 | Active   | 2019-08-04  |            0 |                800 |
|     601 | Active   | 2019-08-07  |        16374 |             -15574 |
|     601 | Active   | 2019-09-30  |         8858 |              -8058 |
|     601 | Active   | 2019-08-08  |         8858 |              -8058 |
|     601 | Active   | 2019-10-01  |            0 |                800 |
|     648 | Active   | 2019-06-29  |            0 |              10000 |
|     648 | Active   | 2019-06-22  |            0 |              10000 |
|     648 | Active   | 2019-06-17  |         3789 |               6211 |
|     648 | Active   | 2019-06-24  |            0 |              10000 |
|     648 | Active   | 2019-06-10  |         3940 |               6060 |
|     648 | Active   | 2019-07-12  |         2171 |               7829 |
|     648 | Active   | 2019-07-09  |            0 |              10000 |
|     648 | Active   | 2019-06-12  |        12180 |              -2180 |
|     648 | Active   | 2019-06-26  |            0 |              10000 |
|     648 | Active   | 2019-06-19  |          531 |               9469 |
|     648 | Active   | 2019-06-30  |            0 |              10000 |
|     648 | Active   | 2019-06-14  |          842 |               9158 |
|     648 | Active   | 2019-07-07  |            0 |              10000 |
|     648 | Active   | 2019-07-02  |            0 |              10000 |
|     648 | Active   | 2019-07-06  |            0 |              10000 |
|     648 | Active   | 2019-06-16  |          842 |               9158 |
|     648 | Active   | 2019-06-08  |         2789 |               7211 |
|     648 | Active   | 2019-06-23  |            0 |              10000 |
|     648 | Active   | 2019-06-28  |         3109 |               6891 |
|     648 | Active   | 2019-06-25  |            0 |              10000 |
|     648 | Active   | 2019-06-09  |         7059 |               2941 |
|     648 | Active   | 2019-07-05  |            0 |              10000 |
|     648 | Active   | 2019-07-01  |            0 |              10000 |
|     648 | Active   | 2019-07-04  |            0 |              10000 |
|     648 | Active   | 2019-07-11  |            0 |              10000 |
|     648 | Active   | 2019-06-11  |         5760 |               4240 |
|     648 | Active   | 2019-06-21  |          883 |               9117 |
|     648 | Active   | 2019-06-18  |         1229 |               8771 |
|     648 | Active   | 2019-07-24  |         2171 |              -1771 |
|     648 | Active   | 2019-07-25  |         3485 |              -3085 |
|     648 | Active   | 2019-07-26  |         7442 |              -7042 |
|     648 | Active   | 2019-07-27  |         7830 |              -7430 |
|     648 | Active   | 2019-07-28  |         5426 |              -4626 |
|     648 | Active   | 2019-07-29  |         9551 |              -8751 |
|     648 | Active   | 2019-07-30  |         3432 |              -2632 |
|     648 | Active   | 2019-07-31  |         3068 |              -2268 |
|     648 | Active   | 2019-08-02  |         5976 |              -5176 |
|     648 | Active   | 2019-08-03  |          138 |                662 |
|     648 | Active   | 2019-08-04  |            0 |               1200 |
|     648 | Active   | 2019-08-01  |        10137 |              -9337 |
|     648 | Active   | 2019-08-07  |        10120 |              -8920 |
|     648 | Active   | 2019-08-05  |         5337 |              -4137 |
|     648 | Active   | 2019-08-06  |         3978 |              -2778 |
|     648 | Active   | 2019-08-08  |         4323 |              -3123 |
|     648 | Active   | 2019-08-10  |        12281 |             -11081 |
|     648 | Active   | 2019-08-09  |         3503 |              -2303 |
|     648 | Active   | 2019-08-12  |         2750 |              -1150 |
|     648 | Active   | 2019-08-11  |        15671 |             -14071 |
|     648 | Active   | 2019-08-13  |         2129 |               -529 |
|     648 | Active   | 2019-08-14  |            0 |               1600 |
|     648 | Active   | 2019-08-15  |         8049 |              -6449 |
|     648 | Active   | 2019-08-16  |         3221 |              -1621 |
|     648 | Active   | 2019-08-19  |            0 |               2000 |
|     648 | Active   | 2019-08-17  |         6271 |              -4671 |
|     648 | Active   | 2019-08-20  |         1945 |                 55 |
|     648 | Active   | 2019-08-18  |         3221 |              -1221 |
|     648 | Active   | 2019-08-21  |         2529 |               -529 |
|     648 | Active   | 2019-08-23  |         7965 |              -5965 |
|     648 | Active   | 2019-08-22  |         8259 |              -6259 |
|     648 | Active   | 2019-08-24  |        15542 |             -13542 |
|     648 | Active   | 2019-08-25  |         7298 |              -4898 |
|     648 | Active   | 2019-08-26  |         5248 |              -2848 |
|     648 | Active   | 2019-08-29  |         8694 |              -6294 |
|     648 | Active   | 2019-08-28  |         1941 |                459 |
|     648 | Active   | 2019-08-30  |         6190 |              -3790 |
|     648 | Active   | 2019-08-27  |         7871 |              -5471 |
|     648 | Active   | 2019-08-31  |         5292 |              -2892 |
|     648 | Active   | 2019-09-01  |         6388 |              -3588 |
|     648 | Active   | 2019-09-04  |         1879 |                921 |
|     648 | Active   | 2019-09-03  |         7408 |              -4608 |
|     648 | Active   | 2019-09-02  |          115 |               2685 |
|     648 | Active   | 2019-09-05  |         2190 |                610 |
|     648 | Active   | 2019-09-06  |        15955 |             -13155 |
|     648 | Active   | 2019-09-07  |         1095 |               1705 |
|     648 | Active   | 2019-09-14  |         7937 |              -4737 |
|     648 | Active   | 2019-09-19  |         5602 |              -2402 |
|     648 | Active   | 2019-09-13  |         6504 |              -3304 |
|     648 | Active   | 2019-09-12  |         4523 |              -1323 |
|     648 | Active   | 2019-09-11  |         1455 |               1745 |
|     648 | Active   | 2019-09-10  |         8842 |              -5642 |
|     648 | Active   | 2019-09-18  |         6970 |              -3770 |
|     648 | Active   | 2019-09-09  |         5729 |              -2529 |
|     648 | Active   | 2019-09-17  |         7350 |              -4150 |
|     648 | Active   | 2019-09-16  |         5349 |              -2149 |
|     648 | Active   | 2019-09-15  |         4754 |              -1554 |
|     648 | Active   | 2019-09-08  |         7728 |              -4528 |
|     648 | Active   | 2019-09-20  |         5194 |              -1994 |
|     648 | Active   | 2019-09-21  |        11839 |              -8639 |
|     648 | Active   | 2019-09-23  |          716 |               2884 |
|     648 | Active   | 2019-09-22  |         8894 |              -5294 |
|     648 | Active   | 2019-09-24  |         7914 |              -4314 |
|     648 | Active   | 2019-09-25  |         8831 |              -5231 |
|     648 | Active   | 2019-09-26  |         8382 |              -4782 |
|     648 | Active   | 2019-09-27  |         3880 |               -280 |
|     648 | Active   | 2019-09-28  |        15935 |             -12335 |
|     648 | Active   | 2019-09-29  |        20610 |             -16610 |
|     648 | Active   | 2019-09-30  |         8107 |              -4107 |
|     648 | Active   | 2019-10-05  |        12229 |              -8229 |
|     648 | Active   | 2019-10-02  |         1882 |               2118 |
|     648 | Active   | 2019-10-01  |         4349 |               -349 |
|     648 | Active   | 2019-10-03  |         3329 |                671 |
|     648 | Active   | 2019-10-04  |         6393 |              -2393 |
|     648 | Active   | 2019-10-06  |         1589 |               2811 |
|     648 | Active   | 2019-10-08  |         6826 |              -2426 |
|     648 | Active   | 2019-10-09  |         3210 |               1190 |
|     648 | Active   | 2019-10-07  |         3263 |               1137 |
|     648 | Active   | 2019-10-11  |         3331 |               1069 |
|     648 | Active   | 2019-10-10  |          326 |               4074 |
|     648 | Active   | 2019-10-12  |         7315 |              -2915 |
|     648 | Active   | 2019-10-13  |         5298 |              -1198 |
|     648 | Active   | 2019-10-14  |        12185 |              -8085 |
|     648 | Active   | 2019-10-15  |         5716 |              -1616 |
|     648 | Active   | 2019-10-19  |         7566 |              -3466 |
|     648 | Active   | 2019-10-16  |         7045 |              -2945 |
|     648 | Active   | 2019-10-17  |         3102 |                998 |
|     648 | Active   | 2019-10-18  |         7818 |              -3718 |
|     648 | Active   | 2019-10-20  |         1077 |               3423 |
|     648 | Active   | 2019-10-21  |         6753 |              -2253 |
|     648 | Active   | 2019-10-22  |         6821 |              -2321 |
|     648 | Active   | 2019-10-23  |         6603 |              -2103 |
|     648 | Active   | 2019-10-24  |         7031 |              -2531 |
|     648 | Active   | 2019-10-25  |         7532 |              -3032 |
|     648 | Active   | 2019-10-26  |         2061 |               2439 |
|     648 | Active   | 2019-10-27  |            0 |               4900 |
|     648 | Active   | 2019-10-28  |        10739 |              -5839 |
|     648 | Active   | 2019-10-29  |         3417 |               1483 |
|     648 | Active   | 2019-10-30  |         7326 |              -2426 |
|     648 | Active   | 2019-10-31  |         6759 |              -1859 |
|     648 | Active   | 2019-11-01  |         8513 |              -3613 |
|     648 | Active   | 2019-11-02  |            0 |               4900 |
|     648 | Active   | 2019-11-03  |         6918 |              -1618 |
|     648 | Active   | 2019-11-04  |         5095 |                205 |
|     648 | Active   | 2019-11-07  |         2868 |               2432 |
|     648 | Active   | 2019-11-09  |         2186 |               3114 |
|     648 | Active   | 2019-11-05  |         5811 |               -511 |
|     648 | Active   | 2019-11-06  |         4737 |                563 |
|     648 | Active   | 2019-11-08  |         5218 |                 82 |
|     648 | Active   | 2019-11-10  |         1191 |               4509 |
|     648 | Active   | 2019-11-12  |         4227 |               1473 |
|     648 | Active   | 2019-11-11  |         7883 |              -2183 |
|     648 | Active   | 2019-11-13  |          879 |               4821 |
|     648 | Active   | 2019-11-15  |         3194 |               2506 |
|     648 | Active   | 2019-11-14  |         3224 |               2476 |
|     648 | Active   | 2019-11-16  |         8002 |              -2302 |
|     648 | Active   | 2019-11-17  |         8354 |              -3854 |
|     648 | Active   | 2019-11-18  |         2250 |               2250 |
|     648 | Active   | 2019-11-22  |         1534 |               2966 |
|     648 | Active   | 2019-11-21  |         5567 |              -1067 |
|     648 | Active   | 2019-11-19  |         4027 |                473 |
|     648 | Active   | 2019-11-20  |            0 |               4500 |
|     648 | Active   | 2019-11-23  |         8391 |              -3891 |
+---------+----------+-------------+--------------+--------------------+
736 rows in set (0.24 sec)

mysql> use ro_employees;
Database changed
mysql> show tables;
+------------------------+
| Tables_in_ro_employees |
+------------------------+
| departments            |
| dept_emp               |
| dept_manager           |
| employees              |
| salaries               |
| titles                 |
+------------------------+
6 rows in set (0.04 sec)

mysql> desc titles;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| emp_no    | int(11)     | NO   | PRI | NULL    |       |
| title     | varchar(50) | NO   | PRI | NULL    |       |
| from_date | date        | NO   | PRI | NULL    |       |
| to_date   | date        | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
4 rows in set (0.02 sec)

mysql> desc salaries;
+-----------+---------+------+-----+---------+-------+
| Field     | Type    | Null | Key | Default | Extra |
+-----------+---------+------+-----+---------+-------+
| emp_no    | int(11) | NO   | PRI | NULL    |       |
| salary    | int(11) | NO   |     | NULL    |       |
| from_date | date    | NO   | PRI | NULL    |       |
| to_date   | date    | NO   |     | NULL    |       |
+-----------+---------+------+-----+---------+-------+
4 rows in set (0.03 sec)

mysql> select count(distinct t.emp_no) from titles t join salaries s on t.emp_no=s.emp_no where t.from_date<='1986-01-01' and t.to_date>='1985-01-01' and t.title LIKE "%Engineer%";
+--------------------------+
| count(distinct t.emp_no) |
+--------------------------+
|                     9278 |
+--------------------------+
1 row in set (0.31 sec)

mysql> desc departments;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| dept_no   | char(4)     | NO   | PRI | NULL    |       |
| dept_name | varchar(40) | NO   | UNI | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
2 rows in set (0.02 sec)

mysql> desc dept_emp;
+-----------+---------+------+-----+---------+-------+
| Field     | Type    | Null | Key | Default | Extra |
+-----------+---------+------+-----+---------+-------+
| emp_no    | int(11) | NO   | PRI | NULL    |       |
| dept_no   | char(4) | NO   | PRI | NULL    |       |
| from_date | date    | NO   |     | NULL    |       |
| to_date   | date    | NO   |     | NULL    |       |
+-----------+---------+------+-----+---------+-------+
4 rows in set (0.03 sec)

mysql> select count(distinct d_e.emp_no) from dept_emp d_e join departments d on d_e.dept_no=d.dept_no where d_e.from_date<='1992-01-01' and d_e.to_date>='1985-01-01' and d.dept_name='Production';
+----------------------------+
| count(distinct d_e.emp_no) |
+----------------------------+
|                      31700 |
+----------------------------+
1 row in set (0.18 sec)

mysql> select e.first_name, e.last_name, s.salary, t.title from employees e join salaries s on e.emp_no=s.emp_no join titles t on s.emp_no=t.emp_no where s.to_date>=NOW() and t.to_date>=NOW() order by rand() limit 20;
+------------+---------------+--------+-----------------+
| first_name | last_name     | salary | title           |
+------------+---------------+--------+-----------------+
| Mitsuyuki  | Tibblin       |  57044 | Senior Staff    |
| Mihalis    | Kawashimo     |  87021 | Senior Staff    |
| Hausi      | Bruckman      |  86783 | Senior Staff    |
| Jinxi      | Siprelle      |  57105 | Senior Staff    |
| Shigeu     | Validov       |  57466 | Engineer        |
| Sanjai     | Marrevee      |  72404 | Engineer        |
| Sarita     | Klassen       |  94720 | Senior Engineer |
| Annemarie  | Bojadziev     |  61303 | Senior Engineer |
| Alejandro  | Pileggi       |  73260 | Senior Staff    |
| Shooichi   | Teitelbaum    |  95012 | Senior Staff    |
| Zeydy      | Waleschkowski |  96536 | Senior Staff    |
| Ghassan    | Munawer       |  99881 | Senior Staff    |
| Shiv       | Chorvat       |  66313 | Senior Engineer |
| Krister    | Gulla         | 114698 | Senior Staff    |
| Indrajit   | Tetzlaff      |  56921 | Engineer        |
| Yishay     | Hainaut       |  73228 | Senior Staff    |
| Kauko      | Marrevee      |  72915 | Senior Staff    |
| Boutros    | Esteva        |  53874 | Engineer        |
| Jessie     | Greibach      |  67619 | Senior Engineer |
| Moheb      | Lorcy         |  70795 | Senior Engineer |
+------------+---------------+--------+-----------------+
20 rows in set (4.09 sec)
```

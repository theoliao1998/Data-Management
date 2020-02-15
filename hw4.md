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
* 5 random cities that a population above 13000 and below 500,000 that don't speak English as an official language and are not a Republic could be as follows.  
```
+----------------+
| Name           |
+----------------+
| Miyakonojo     |
| Isesaki        |
| Khamis Mushayt |
| Cienfuegos     |
| Godhra         |
+----------------+
```

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

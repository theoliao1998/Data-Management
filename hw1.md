**From:** Xinhao Liao  
**To:** Raj Kumar  
**Date:** Week 1  

Hi Raj,

I am a new member of the database group. Glad to work with you as part of the Borromean team. After reading the materials and checking the databases, I think that I am able to answer your questions now.

The 3 types of relationships the author defines are one-to-one, one-to-many, and many-to-many relationships. For instance, if it’s required that one class has only one professor, and since one professor can have multiple classes, there is a one-to-many relationship between professors and classes. Similarly, since one class can have many students, and one student can be enrolled in many classes, there’s a many-to-many relationship between students and classes. And one student can only have one student id, and one student id corresponds to only one student, which implies a one-to-one relationship.

The author defines 2 different types of databases, which are the hierarchical database model and the network database model. I might use a hierarchical database to store data for the structure of a normal organization where one leader can have many subordinates, and one subordinate can only have one leader. For a relational database, I might use it to store more complicated information like the records of class enrollment with students’ and professors’ data related.

After connecting to the database server, I can see 9 databases, which are “information_schema”, “mysql”, “performance_schema”, “ro_company1”, “ro_employees”, “ro_query”, “ro_recipes”, “ro_research1”, and “sys”. 

Instead of 4 or 5, there are only 2 tables in the database “ro_query”, which are “home_value_by_zip” and “taxdata”.

There are 12 columns in the table “taxdata”, which are “id”, “ein”, “name”, “year”. “revenue”, “expenses”, “purpose”, “ptid”, “ptname”, “city”, “state”, and “url”.
 
Inside the “ro_employees” database, there are 443308 rows in the titles table.

I would store integers in “emp_no” inside the “titles” table inside the “ro_employees” database.

Best regards,  
Xinhao Liao


--  
<span style="color:blue">Database operation records</span>
```
mysql> show databases
    -> ;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| ro_company1        |
| ro_employees       |
| ro_query           |
| ro_recipes         |
| ro_research1       |
| sys                |
+--------------------+
9 rows in set (0.06 sec)

mysql> use ro_query;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+--------------------+
| Tables_in_ro_query |
+--------------------+
| home_value_by_zip  |
| taxdata            |
+--------------------+
2 rows in set (0.03 sec)

mysql> select * from taxdata limit 1
    -> ;
+----+-----------+----------------------------------------------------+------+---------+----------+---------+-----------+----------+-------------+-------+---------------------------------------------------------------------+
| id | ein       | name                                               | year | revenue | expenses | purpose | ptid      | ptname   | city        | state | url                                                                 |
+----+-----------+----------------------------------------------------+------+---------+----------+---------+-----------+----------+-------------+-------+---------------------------------------------------------------------+
|  1 | 742661023 | THE HARRIET & HARMON KELLEYFOUNDATION FOR THE ARTS | 2014 |       0 |        0 |         | P00286016 | JIM RICE | SAN ANTONIO | TX    | https://s3.amazonaws.com/irs-form-990/201543159349100344_public.xml |
+----+-----------+----------------------------------------------------+------+---------+----------+---------+-----------+----------+-------------+-------+---------------------------------------------------------------------+
1 row in set (0.02 sec)

mysql> desc taxdata;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| ein      | int(11)      | YES  |     | NULL    |                |
| name     | varchar(255) | YES  |     | NULL    |                |
| year     | int(11)      | YES  |     | NULL    |                |
| revenue  | bigint(20)   | YES  |     | NULL    |                |
| expenses | bigint(20)   | YES  |     | NULL    |                |
| purpose  | text         | YES  |     | NULL    |                |
| ptid     | varchar(255) | YES  |     | NULL    |                |
| ptname   | varchar(255) | YES  |     | NULL    |                |
| city     | varchar(255) | YES  |     | NULL    |                |
| state    | varchar(255) | YES  |     | NULL    |                |
| url      | varchar(255) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
12 rows in set (0.11 sec)

mysql> use ro_employees;
No connection. Trying to reconnect...
Connection id:    10
Current database: *** NONE ***

Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

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
6 rows in set (0.02 sec)

mysql> select count(1) from titles;
+----------+
| count(1) |
+----------+
|   443308 |
+----------+
1 row in set (0.06 sec)

mysql> desc titles;
ERROR 2013 (HY000): Lost connection to MySQL server during query
mysql> desc titles;
ERROR 2006 (HY000): MySQL server has gone away
No connection. Trying to reconnect...
Connection id:    8
Current database: ro_employees

+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| emp_no    | int(11)     | NO   | PRI | NULL    |       |
| title     | varchar(50) | NO   | PRI | NULL    |       |
| from_date | date        | NO   | PRI | NULL    |       |
| to_date   | date        | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
4 rows in set (0.44 sec)
````

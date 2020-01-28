**From:** Xinhao Liao  
**To:** Kelly Davenport (CTO)   
**Date:** Week 2  

Hi Kelly,  

I have checked the data can answer these questions now. The query records and documentations I created are appended in the end.  

Each investor will pay about $2112857.1429.

For questions related to the **ro_company1** dataset,  
* Company1 has 24 accounts.  
* The primary key of the accounts table is *account_id*.  
* The possible values that could be in the status field in the account table are 'ACTIVE', 'CLOSED', and 'FROZEN'.  
* About the company's top performers,  
  1) Employee ID 1 has opened the most company accounts.  
  2) Employee ID 1 started working at the company from 2001-06-22.  
* For data on the company's transaction history and their products, the required query could be  
`select txn_date, account_id from transaction order by txn_date desc, account_id;`, which gives the result  
```
+---------------------+------------+
| txn_date            | account_id |
+---------------------+------------+  
| 2004-12-28 00:00:00 |         15 |  
| 2004-10-28 00:00:00 |         22 |  
| 2004-09-30 00:00:00 |         12 |  
| 2004-06-30 00:00:00 |          3 |  
| 2004-06-30 00:00:00 |         23 |  
| 2004-01-27 00:00:00 |         13 |  
| 2004-01-12 00:00:00 |         17 |  
| 2003-09-12 00:00:00 |         10 |  
| 2003-07-30 00:00:00 |         21 |  
| 2003-07-30 00:00:00 |         28 |  
| 2002-12-15 00:00:00 |          8 |  
| 2002-11-23 00:00:00 |          7 |  
| 2002-09-30 00:00:00 |         24 |  
| 2002-08-24 00:00:00 |         14 |  
| 2001-05-23 00:00:00 |         18 |  
| 2001-05-23 00:00:00 |         19 |  
| 2001-03-12 00:00:00 |          4 |  
| 2001-03-12 00:00:00 |          5 |  
| 2000-01-15 00:00:00 |          1 |  
| 2000-01-15 00:00:00 |          2 |  
| 2000-01-15 00:00:00 |         11 |  
+---------------------+------------+
```
* The primary key in the transaction table is *txn_id*.  
* The unique product types offered are *Customer Accounts*, *Insurance Offerings*, and *Individual and Business Loans*.  
* For information related to different company divisions:  
  * 3 branches are located in MA.  
  * The required query could be `select name, address, zip, NOW() as querytime from branch;`, which gives the result  
```
+---------------+----------------------+-------+---------------------+
| name          | address              | zip   | querytime           |
+---------------+----------------------+-------+---------------------+
| Headquarters  | 3882 Main St.        | 02451 | 2020-01-28 20:31:19 |
| Woburn Branch | 422 Maple St.        | 01801 | 2020-01-28 20:31:19 |
| Quincy Branch | 125 Presidential Way | 02169 | 2020-01-28 20:31:19 |
| So. NH Branch | 378 Maynard Ln.      | 03079 | 2020-01-28 20:31:19 |
+---------------+----------------------+-------+---------------------+
```
  
For questions related to the **ro_query** database,   
  * Integer numbers can be stored in the year field.  
  * There are 65615 non-duplicated PTID entries (including null ptid).
  * The PTID are actually Preparer Tax Identification Number (PTIN) issued by Internal Revenue Service (IRS), which is used as the tax return preparer's identification number.  
  * EIN should be the Employer Identification Number assigned by IRS to business entities for identification in tax reporting.  
  * Using the query `select * from taxdata order by id desc limit 1;`, we can get the last entry in the taxdata table as follows:
```
+--------+-----------+--------------------------+------+---------+----------+----------------------------------------------------------------------+-----------+-------------+-------------+-------+---------------------------------------------------------------------+
| id     | ein       | name                     | year | revenue | expenses | purpose                                                              | ptid      | ptname      | city        | state | url                                                                 |
+--------+-----------+--------------------------+------+---------+----------+----------------------------------------------------------------------+-----------+-------------+-------------+-------+---------------------------------------------------------------------+
| 378304 | 351330448 | Big Brothers Big Sisters | 2015 |  353120 |   304867 | Help children to reach their potential through professional supports | P00932103 | Dana Bement | Bloomington | IN    | https://s3.amazonaws.com/irs-form-990/201642289349303444_public.xml |
+--------+-----------+--------------------------+------+---------+----------+----------------------------------------------------------------------+-----------+-------------+-------------+-------+---------------------------------------------------------------------+
```


```
mysql> select (30000000-15210000)/7;
+-----------------------+
| (30000000-15210000)/7 |
+-----------------------+
|          2112857.1429 |
+-----------------------+
1 row in set (0.03 sec)

mysql> use ro_company1 dataset;
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
11 rows in set (0.02 sec)

mysql> select account_id from account;
+------------+
| account_id |
+------------+
|         10 |
|         11 |
|         12 |
|         14 |
|         15 |
|         21 |
|         22 |
|         23 |
|          1 |
|          2 |
|          3 |
|          4 |
|          5 |
|         17 |
|         27 |
|          7 |
|          8 |
|         29 |
|         13 |
|         18 |
|         19 |
|         24 |
|         25 |
|         28 |
+------------+
24 rows in set (0.05 sec)

mysql> select account_id,open_emp_id from account order by open_emp_id;
+------------+-------------+
| account_id | open_emp_id |
+------------+-------------+
|         10 |           1 |
|         11 |           1 |
|         12 |           1 |
|         14 |           1 |
|         15 |           1 |
|         21 |           1 |
|         22 |           1 |
|         23 |           1 |
|          1 |          10 |
|          2 |          10 |
|          3 |          10 |
|          4 |          10 |
|          5 |          10 |
|         17 |          10 |
|         27 |          10 |
|          7 |          13 |
|          8 |          13 |
|         29 |          13 |
|         13 |          16 |
|         18 |          16 |
|         19 |          16 |
|         24 |          16 |
|         25 |          16 |
|         28 |          16 |
+------------+-------------+
24 rows in set (0.04 sec)

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
9 rows in set (0.04 sec)

mysql> select emp_id,start_date from employee limit 1;
+--------+------------+
| emp_id | start_date |
+--------+------------+
|      1 | 2001-06-22 |
+--------+------------+
1 row in set (0.03 sec)

mysql> desc transaction;
+---------------------+----------------------+------+-----+---------+----------------+
| Field               | Type                 | Null | Key | Default | Extra          |
+---------------------+----------------------+------+-----+---------+----------------+
| txn_id              | int(10) unsigned     | NO   | PRI | NULL    | auto_increment |
| txn_date            | datetime             | NO   |     | NULL    |                |
| account_id          | int(10) unsigned     | NO   | MUL | NULL    |                |
| txn_type_cd         | enum('DBT','CDT')    | YES  |     | NULL    |                |
| amount              | double(10,2)         | NO   |     | NULL    |                |
| teller_emp_id       | smallint(5) unsigned | YES  | MUL | NULL    |                |
| execution_branch_id | smallint(5) unsigned | YES  | MUL | NULL    |                |
| funds_avail_date    | datetime             | YES  |     | NULL    |                |
+---------------------+----------------------+------+-----+---------+----------------+
8 rows in set (0.03 sec)

mysql> select txn_date, account_id from transaction order by txn_date desc, account_id;
+---------------------+------------+
| txn_date            | account_id |
+---------------------+------------+
| 2004-12-28 00:00:00 |         15 |
| 2004-10-28 00:00:00 |         22 |
| 2004-09-30 00:00:00 |         12 |
| 2004-06-30 00:00:00 |          3 |
| 2004-06-30 00:00:00 |         23 |
| 2004-01-27 00:00:00 |         13 |
| 2004-01-12 00:00:00 |         17 |
| 2003-09-12 00:00:00 |         10 |
| 2003-07-30 00:00:00 |         21 |
| 2003-07-30 00:00:00 |         28 |
| 2002-12-15 00:00:00 |          8 |
| 2002-11-23 00:00:00 |          7 |
| 2002-09-30 00:00:00 |         24 |
| 2002-08-24 00:00:00 |         14 |
| 2001-05-23 00:00:00 |         18 |
| 2001-05-23 00:00:00 |         19 |
| 2001-03-12 00:00:00 |          4 |
| 2001-03-12 00:00:00 |          5 |
| 2000-01-15 00:00:00 |          1 |
| 2000-01-15 00:00:00 |          2 |
| 2000-01-15 00:00:00 |         11 |
+---------------------+------------+
21 rows in set (0.05 sec)

mysql> desc product_type;
+-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| product_type_cd | varchar(10) | NO   | PRI | NULL    |       |
| name            | varchar(50) | NO   |     | NULL    |       |
+-----------------+-------------+------+-----+---------+-------+
2 rows in set (0.03 sec)

mysql> select * from product_type;
+-----------------+-------------------------------+
| product_type_cd | name                          |
+-----------------+-------------------------------+
| ACCOUNT         | Customer Accounts             |
| INSURANCE       | Insurance Offerings           |
| LOAN            | Individual and Business Loans |
+-----------------+-------------------------------+
3 rows in set (0.05 sec)

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
6 rows in set (0.03 sec)

mysql> select branch_id, state order by state;
ERROR 1054 (42S22): Unknown column 'branch_id' in 'field list'
mysql> select branch_id, state from branch order by state;
+-----------+-------+
| branch_id | state |
+-----------+-------+
|         1 | MA    |
|         2 | MA    |
|         3 | MA    |
|         4 | NH    |
+-----------+-------+
4 rows in set (0.04 sec)

mysql> select name, address, zip, NOW() as querytime from branch;
+---------------+----------------------+-------+---------------------+
| name          | address              | zip   | querytime           |
+---------------+----------------------+-------+---------------------+
| Headquarters  | 3882 Main St.        | 02451 | 2020-01-28 20:31:19 |
| Woburn Branch | 422 Maple St.        | 01801 | 2020-01-28 20:31:19 |
| Quincy Branch | 125 Presidential Way | 02169 | 2020-01-28 20:31:19 |
| So. NH Branch | 378 Maynard Ln.      | 03079 | 2020-01-28 20:31:19 |
+---------------+----------------------+-------+---------------------+
4 rows in set (0.03 sec)

mysql> use ro_query;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
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
12 rows in set (0.03 sec)

mysql> select distinct ptid from taxdata limit 3;
+-----------+
| ptid      |
+-----------+
| P00286016 |
|           |
| P01414750 |
...
^C| P01202250 |
| P01202250 |
^C -- query aborted
+-----------+
65615 rows in set (0.64 sec)

select COUNT(distinct ptid) from taxdata;
+----------------------+
| COUNT(distinct ptid) |
+----------------------+
|                65615 |
+----------------------+
1 row in set (2.32 sec)

mysql> select distinct ptid from taxdata order by ptid limit 3;
+-----------+
| ptid      |
+-----------+
|           |
| P00000001 |
| P00000007 |
+-----------+
3 rows in set (0.64 sec)

mysql> select url from taxdata limit 1;
+---------------------------------------------------------------------+
| url                                                                 |
+---------------------------------------------------------------------+
| https://s3.amazonaws.com/irs-form-990/201543159349100344_public.xml |
+---------------------------------------------------------------------+
1 row in set (0.03 sec)

mysql> select * from taxdata order by id desc limit 1;
+--------+-----------+--------------------------+------+---------+----------+----------------------------------------------------------------------+-----------+-------------+-------------+-------+---------------------------------------------------------------------+
| id     | ein       | name                     | year | revenue | expenses | purpose                                                              | ptid      | ptname      | city        | state | url                                                                 |
+--------+-----------+--------------------------+------+---------+----------+----------------------------------------------------------------------+-----------+-------------+-------------+-------+---------------------------------------------------------------------+
| 378304 | 351330448 | Big Brothers Big Sisters | 2015 |  353120 |   304867 | Help children to reach their potential through professional supports | P00932103 | Dana Bement | Bloomington | IN    | https://s3.amazonaws.com/irs-form-990/201642289349303444_public.xml |
+--------+-----------+--------------------------+------+---------+----------+----------------------------------------------------------------------+-----------+-------------+-------------+-------+---------------------------------------------------------------------+
1 row in set (0.03 sec)

```

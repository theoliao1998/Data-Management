**From:** Xinhao Liao  
**To:** Lawrence Summerset  
**Date:** Week 5  

Hi Lawrence,  

You must have had a great time in Ireland! And I am more than willing to answer these questions for you. The query list id appended in the end.  

From the employee database  
(1) The number of employees born in each month is listed below.  
```
+-------+--------------------------+
| month | number of employees born |
+-------+--------------------------+
|     1 |                    25412 |
|     2 |                    23483 |
|     3 |                    25649 |
|     4 |                    24631 |
|     5 |                    25113 |
|     6 |                    24712 |
|     7 |                    25698 |
|     8 |                    25262 |
|     9 |                    24720 |
|    10 |                    25518 |
|    11 |                    24500 |
|    12 |                    25326 |
+-------+--------------------------+
```  
(3) The average salary by job title currently for all staff is listed as follows.  
```
+--------------------+------------------------+
| title              | current average salary |
+--------------------+------------------------+
| Senior Engineer    |             70823.4376 |
| Staff              |             67330.6652 |
| Senior Staff       |             80706.4959 |
| Engineer           |             59602.7378 |
| Assistant Engineer |             57317.5736 |
| Technique Leader   |             67506.5903 |
| Manager            |             77723.6667 |
+--------------------+------------------------+
```  
(4) The average salary for all folks that are currently employed by year of hire is listed as follows.  
```
+--------------+------------------------+
| year of hire | current average salary |
+--------------+------------------------+
|         1985 |             78870.3162 |
|         1986 |             77411.4463 |
|         1987 |             75927.5882 |
|         1988 |             74201.5604 |
|         1989 |             73053.4454 |
|         1990 |             71483.8574 |
|         1991 |             69812.8034 |
|         1992 |             68286.0711 |
|         1993 |             67090.8002 |
|         1994 |             65332.5509 |
|         1995 |             63705.1261 |
|         1996 |             62424.6746 |
|         1997 |             60794.5994 |
|         1998 |             59673.0602 |
|         1999 |             58199.3812 |
|         2000 |             58192.1111 |
+--------------+------------------------+
```  
  
From the research1 database  
(1) For the average number of steps for July by username, a list is give as below where NULL indicates that there's no record for the user in July.  
```
+----------------------------------+----------------------------------+
| username                         | average number of steps for July |
+----------------------------------+----------------------------------+
| 00e873bcbfa8c6171db3d1afbf6bf0cf |                       10718.5000 |
| 1de2e393b047677dcf7cf5f729c3afc4 |                       10242.9032 |
| 44a688027cc06a0ad4f399e3b7a1cc87 |                        2622.1176 |
| 44c2004f51c708cc7210544ac73dbd16 |                             NULL |
| 4b526cd67c901bae45be1443899a2dc3 |                             NULL |
| 5a4ff680a8ab622ab743bbc58092999c |                             NULL |
| 7233516567e4e178cdde26e9e6a9c72d |                             NULL |
| 82c8ca7904fea3535400823529ade611 |                        8735.7742 |
| a1ad3be33cf61d95d8f21a93a094c747 |                        5535.5185 |
| a2b2cec8c95bcca6a9f6278840fd4823 |                             NULL |
| b7ae0a8e76b941784be96aefae2a6fb3 |                             NULL |
| bf67797ffaefa186673678cc73767abe |                             NULL |
| c95edebebbb7ffac997419157cd0e4e9 |                        4313.0000 |
| f9f67f5beddc05e72d4c1715c26df95d |                             NULL |
+----------------------------------+----------------------------------+
```  

(2) For the user with the name 'f9f67f5beddc05e72d4c1715c26df95d', I tried to query the average number of minutes he/she sleeps each month with `select MONTH(fitbit_date) as month, AVG(fitbit_timeinbed) as "average number of minutes of sleep" from fitbit_sleep where user_id in (select uid from users_field_data where name='f9f67f5beddc05e72d4c1715c26df95d') group by month;`. But that gives me an empty set, which means that there is no sleep data on this user recorded.  

(4) A listing of each user_id and the if they met their goal on average per month is shown below, where NULL means no records, and for dolumn "whether meet the goal on average", 1 implies that the goal is met while 0 means the goal is not met.  
```
+---------+-------+----------------------------------+
| user_id | month | whether meet the goal on average |
+---------+-------+----------------------------------+
|      77 |  NULL |                             NULL |
|     148 |     5 |                                0 |
|     148 |     6 |                                0 |
|     148 |     7 |                                1 |
|     148 |     8 |                                1 |
|     148 |     9 |                                0 |
|     148 |    10 |                                1 |
|     148 |    11 |                                1 |
|     178 |  NULL |                             NULL |
|     197 |  NULL |                             NULL |
|     207 |     7 |                                1 |
|     207 |     8 |                                1 |
|     207 |     9 |                                0 |
|     207 |    10 |                                1 |
|     250 |  NULL |                             NULL |
|     458 |  NULL |                             NULL |
|     475 |     7 |                                1 |
|     475 |     8 |                                1 |
|     475 |     9 |                                1 |
|     475 |    10 |                                0 |
|     540 |  NULL |                             NULL |
|     558 |  NULL |                             NULL |
|     592 |     5 |                                1 |
|     592 |     6 |                                1 |
|     592 |     7 |                                0 |
|     592 |     8 |                                0 |
|     592 |     9 |                                1 |
|     592 |    10 |                                1 |
|     592 |    11 |                                1 |
|     601 |     7 |                                0 |
|     601 |     8 |                                1 |
|     601 |     9 |                                1 |
|     601 |    10 |                                0 |
|     648 |     6 |                                0 |
|     648 |     7 |                                0 |
|     648 |     8 |                                1 |
|     648 |     9 |                                1 |
|     648 |    10 |                                1 |
|     648 |    11 |                                0 |
|     907 |  NULL |                             NULL |
+---------+-------+----------------------------------+
```

(5) For users who get more than 8 hours of sleep, the list is too long (with 172 rows). A sample of the user_id's, the names and the days is shown as follows, which is obtained from the query `select s.user_id, u.name as user_name, s.fitbit_date from fitbit_sleep s left join users_field_data u on u.uid=s.user_id where (fitbit_timeinbed/60) > 8 order by rand() limit 10;`.  
```
+---------+----------------------------------+-------------+
| user_id | user_name                        | fitbit_date |
+---------+----------------------------------+-------------+
|     475 | 00e873bcbfa8c6171db3d1afbf6bf0cf | 2019-07-25  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-07-04  |
|     592 | 82c8ca7904fea3535400823529ade611 | 2019-08-02  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-09-05  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-07-10  |
|     592 | 82c8ca7904fea3535400823529ade611 | 2019-08-16  |
|     475 | 00e873bcbfa8c6171db3d1afbf6bf0cf | 2019-07-28  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-09-20  |
|     592 | 82c8ca7904fea3535400823529ade611 | 2019-09-14  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-10-04  |
+---------+----------------------------------+-------------+
```

And Raj hasn't told me anything about that.  

Best,  

Xinhao Liao  
Datebase Team Member    
Borromean Digitial  


--  
<span style="color:blue">Database query list</span>   
```
mysql> use ro_employees;
No connection. Trying to reconnect...
Connection id:    47
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
6 rows in set (0.03 sec)

mysql> desc employees;
+------------+---------------+------+-----+---------+-------+
| Field      | Type          | Null | Key | Default | Extra |
+------------+---------------+------+-----+---------+-------+
| emp_no     | int(11)       | NO   | PRI | NULL    |       |
| birth_date | date          | NO   |     | NULL    |       |
| first_name | varchar(14)   | NO   |     | NULL    |       |
| last_name  | varchar(16)   | NO   |     | NULL    |       |
| gender     | enum('M','F') | NO   |     | NULL    |       |
| hire_date  | date          | NO   |     | NULL    |       |
+------------+---------------+------+-----+---------+-------+
6 rows in set (0.03 sec)

mysql> select MONTH(birth_date) as month, count(1) as "number of employees born" from employees group by MONTH(birth_date) order by month;
+-------+--------------------------+
| month | number of employees born |
+-------+--------------------------+
|     1 |                    25412 |
|     2 |                    23483 |
|     3 |                    25649 |
|     4 |                    24631 |
|     5 |                    25113 |
|     6 |                    24712 |
|     7 |                    25698 |
|     8 |                    25262 |
|     9 |                    24720 |
|    10 |                    25518 |
|    11 |                    24500 |
|    12 |                    25326 |
+-------+--------------------------+
12 rows in set (0.17 sec)

mysql> select t.title, AVG(s.salary) as "current average salary" from salaries s join titles t on s.emp_no = t.emp_no where s.to_date >= NOW() and t.to_date >= NOW() group by t.title;
+--------------------+------------------------+
| title              | current average salary |
+--------------------+------------------------+
| Senior Engineer    |             70823.4376 |
| Staff              |             67330.6652 |
| Senior Staff       |             80706.4959 |
| Engineer           |             59602.7378 |
| Assistant Engineer |             57317.5736 |
| Technique Leader   |             67506.5903 |
| Manager            |             77723.6667 |
+--------------------+------------------------+
7 rows in set (2.97 sec)

mysql> select YEAR(e.hire_date) as "year of hire", AVG(s.salary) as "current average salary" from salaries s join employees e on e.emp_no=s.emp_no where s.to_date>=NOW() group by YEAR(e.hire_date) order by YEAR(e.hire_date);
+--------------+------------------------+
| year of hire | current average salary |
+--------------+------------------------+
|         1985 |             78870.3162 |
|         1986 |             77411.4463 |
|         1987 |             75927.5882 |
|         1988 |             74201.5604 |
|         1989 |             73053.4454 |
|         1990 |             71483.8574 |
|         1991 |             69812.8034 |
|         1992 |             68286.0711 |
|         1993 |             67090.8002 |
|         1994 |             65332.5509 |
|         1995 |             63705.1261 |
|         1996 |             62424.6746 |
|         1997 |             60794.5994 |
|         1998 |             59673.0602 |
|         1999 |             58199.3812 |
|         2000 |             58192.1111 |
+--------------+------------------------+
16 rows in set (2.17 sec)

mysql> use ro_research1;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

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
4 rows in set (0.04 sec)

mysql> desc users_field_data;
+----------+------------------+------+-----+---------+-------+
| Field    | Type             | Null | Key | Default | Extra |
+----------+------------------+------+-----+---------+-------+
| uid      | int(10) unsigned | NO   | PRI | NULL    |       |
| langcode | varchar(12)      | NO   | PRI | NULL    |       |
| name     | varchar(60)      | NO   | MUL | NULL    |       |
| mail     | varchar(254)     | YES  | MUL | NULL    |       |
| timezone | varchar(32)      | YES  |     | NULL    |       |
+----------+------------------+------+-----+---------+-------+
5 rows in set (0.03 sec)

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
11 rows in set (0.02 sec)

mysql> select u.name as username, avg(d.fitbit_steps) as "average number of steps for July" from users_field_data u left join day_entity d on u.uid=d.user_id where MONTH(d.fitbit_date)=7 or d.fitbit_date IS NULL group by u.name;
+----------------------------------+----------------------------------+
| username                         | average number of steps for July |
+----------------------------------+----------------------------------+
| 00e873bcbfa8c6171db3d1afbf6bf0cf |                       10718.5000 |
| 1de2e393b047677dcf7cf5f729c3afc4 |                       10242.9032 |
| 44a688027cc06a0ad4f399e3b7a1cc87 |                        2622.1176 |
| 44c2004f51c708cc7210544ac73dbd16 |                             NULL |
| 4b526cd67c901bae45be1443899a2dc3 |                             NULL |
| 5a4ff680a8ab622ab743bbc58092999c |                             NULL |
| 7233516567e4e178cdde26e9e6a9c72d |                             NULL |
| 82c8ca7904fea3535400823529ade611 |                        8735.7742 |
| a1ad3be33cf61d95d8f21a93a094c747 |                        5535.5185 |
| a2b2cec8c95bcca6a9f6278840fd4823 |                             NULL |
| b7ae0a8e76b941784be96aefae2a6fb3 |                             NULL |
| bf67797ffaefa186673678cc73767abe |                             NULL |
| c95edebebbb7ffac997419157cd0e4e9 |                        4313.0000 |
| f9f67f5beddc05e72d4c1715c26df95d |                             NULL |
+----------------------------------+----------------------------------+
14 rows in set (0.03 sec)

mysql> select u.uid as user_id, MONTH(d.fitbit_date) as month, avg(d.fitbit_steps)>avg(d.fitbit_goal) as "whether meet the goal on average"  from users_field_data u left join day_entity d on u.uid=d.user_id group by u.uid, month order by u.uid, month;
+---------+-------+----------------------------------+
| user_id | month | whether meet the goal on average |
+---------+-------+----------------------------------+
|      77 |  NULL |                             NULL |
|     148 |     5 |                                0 |
|     148 |     6 |                                0 |
|     148 |     7 |                                1 |
|     148 |     8 |                                1 |
|     148 |     9 |                                0 |
|     148 |    10 |                                1 |
|     148 |    11 |                                1 |
|     178 |  NULL |                             NULL |
|     197 |  NULL |                             NULL |
|     207 |     7 |                                1 |
|     207 |     8 |                                1 |
|     207 |     9 |                                0 |
|     207 |    10 |                                1 |
|     250 |  NULL |                             NULL |
|     458 |  NULL |                             NULL |
|     475 |     7 |                                1 |
|     475 |     8 |                                1 |
|     475 |     9 |                                1 |
|     475 |    10 |                                0 |
|     540 |  NULL |                             NULL |
|     558 |  NULL |                             NULL |
|     592 |     5 |                                1 |
|     592 |     6 |                                1 |
|     592 |     7 |                                0 |
|     592 |     8 |                                0 |
|     592 |     9 |                                1 |
|     592 |    10 |                                1 |
|     592 |    11 |                                1 |
|     601 |     7 |                                0 |
|     601 |     8 |                                1 |
|     601 |     9 |                                1 |
|     601 |    10 |                                0 |
|     648 |     6 |                                0 |
|     648 |     7 |                                0 |
|     648 |     8 |                                1 |
|     648 |     9 |                                1 |
|     648 |    10 |                                1 |
|     648 |    11 |                                0 |
|     907 |  NULL |                             NULL |
+---------+-------+----------------------------------+
40 rows in set (0.03 sec)

mysql> select count(1) from fitbit_sleep s left join users_field_data u on u.uid=s.user_id where (fitbit_timeinbed/60) > 8;
+----------+
| count(1) |
+----------+
|      172 |
+----------+
1 row in set (0.03 sec)

mysql> select s.user_id, u.name as user_name, s.fitbit_date from fitbit_sleep s left join users_field_data u on u.uid=s.user_id where (fitbit_timeinbed/60) > 8 order by rand() limit 10;
+---------+----------------------------------+-------------+
| user_id | user_name                        | fitbit_date |
+---------+----------------------------------+-------------+
|     475 | 00e873bcbfa8c6171db3d1afbf6bf0cf | 2019-07-25  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-07-04  |
|     592 | 82c8ca7904fea3535400823529ade611 | 2019-08-02  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-09-05  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-07-10  |
|     592 | 82c8ca7904fea3535400823529ade611 | 2019-08-16  |
|     475 | 00e873bcbfa8c6171db3d1afbf6bf0cf | 2019-07-28  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-09-20  |
|     592 | 82c8ca7904fea3535400823529ade611 | 2019-09-14  |
|     148 | 1de2e393b047677dcf7cf5f729c3afc4 | 2019-10-04  |
+---------+----------------------------------+-------------+
10 rows in set (0.03 sec)

mysql> select MONTH(fitbit_date) as month, AVG(fitbit_timeinbed) as "average number of minutes of sleep" from fitbit_sleep where user_id in (select uid from users_field_data where name='f9f67f5beddc05e72d4c1715c26df95d') group by month;
Empty set (0.02 sec)

```

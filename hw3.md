**From:** Xinhao Liao  
**To:** Raj Kumar  
**Date:** Week 3  

Hi Raj,  

I have checked the database and am able to answer these questions now. The query records are appended in the end. The code for querying tweet data is appended in *tweet.py*. And the updated documentation is appended in *documentation.pdf*.  

For question about revenue,  
* 245 Ann Arbor-based companies (rows) are listed in the database in 2014.  
* A list of the names of ALL of the companies that generated more than $10,000,000,000 (ten billion dollars) in 2014 is shown below. There are 19 companies in total.   

```
+---------------------------------------------------------------+
| name                                                          |
+---------------------------------------------------------------+
| IHC HEALTH SERVICES INC                                       |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F               |
| Banner Health                                                 |
| KAISER FOUNDATION HEALTH PLAN INC                             |
| Thrivent Financial for Lutherans                              |
| UAW RETIREE MEDICAL BENEFITS TRUST                            |
| KAISER FOUNDATION HOSPITALS                                   |
| Massachusetts Institute of Technology                         |
| UPMC GROUP                                                    |
| Cornell University                                            |
| Trustees of the University of Pennsylvania                    |
| President and Fellows of Harvard College                      |
| YALE UNIVERSITY                                               |
| STATE EMPLOYEES' CREDIT UNION                                 |
| DUKE UNIVERSITY                                               |
| Howard Hughes Medical Institute                               |
| Partners HealthCare System Inc & AffiliatesGroup Return       |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY |
| DIGNITY HEALTH                                                |
+---------------------------------------------------------------+
```  

* As for unique companies generated a revenue of more than $1,000,000,000 (one billion dollars) in any year, there is only one more company, which is "WORKERS' COMPENSATION REINSURANCE ASSOCIATION".

For expenses,  
*  The top 20 unique companies by expenses in 2013 and their expenses are shown below.  

```
+---------------------------------------------------------+-------------+
| name                                                    | expenses    |
+---------------------------------------------------------+-------------+
| KAISER FOUNDATION HEALTH PLAN INC                       | 41982288055 |
| UNIVERSITY OF ROCHESTER                                 |  2776536619 |
| ST FRANCIS HOSPITAL AND MEDICAL CENTER                  |   713077460 |
| WELLSTAR HEALTH SYSTEM INC                              |   660400156 |
| SKY LAKES MEDICAL CENTER                                |   488333644 |
| NAPLES COMMUNITY HOSPITAL INC                           |   426168844 |
| YAKIMA VALLEY MEMORIAL HOSPITAL                         |   401985865 |
| EMBRY-RIDDLE AERONAUTICAL UNIVERSITY INC                |   374154000 |
| ST MARY'S HOSPITAL & MEDICAL CENTERINC                  |   372041256 |
| St Barnabas Hospital                                    |   349321637 |
| HOSPITAL COMMITTEE FOR THE LIVERMOREPLEASANTON AREA     |   341257233 |
| VALLEY PRESBYTERIAN HOSPITAL                            |   273789797 |
| WINCHESTER HOSPITAL                                     |   264605951 |
| TEAMSTERS WESTERN REGION AND NEW JERSEYHEALTH CARE FUND |   231059337 |
| OROVILLE HOSPITAL                                       |   200242937 |
| ST JOSEPH HOSPITAL OF EUREKA                            |   196999313 |
| SWARTHMORE COLLEGE                                      |   168742729 |
| ST FRANCIS HOSPITAL - POUGHKEEPSIE                      |   164506124 |
| Vail Clinic Inc                                         |   159617575 |
| TUSKEGEE UNIVERSITY                                     |   152572824 |
+---------------------------------------------------------+-------------+
```  

* For companies that made between $1-100,000 in revenue and between $10000-200,000 in expenses, the list could be too long. So randomly selected 20 companies' EINs and cities are listed here, which are obtained from the query `select distinct ein, city from taxdata where revenue BETWEEN 1 AND 100000 and expenses BETWEEN 10000 AND 200000 order by rand() limit 20;`.  

```
+-----------+---------------+
| ein       | city          |
+-----------+---------------+
| 541945858 | ROCHESTER     |
| 273084801 | Los Angeles   |
| 770319903 | Los Gatos     |
| 431769903 | Van Buren     |
| 521990279 | Silver Spring |
| 930782729 | PORTLAND      |
| 237168819 | NEW BRITAIN   |
| 263613626 | MEMPHIS       |
| 231034791 | GETTYSBURG    |
| 386100681 | Flint         |
| 680657977 | SWARTZ CREEK  |
| 237372144 | Portland      |
| 113649939 | MEXICO        |
| 141865407 | ORISKANY      |
| 521410219 | Germantown    |
| 273558027 | PEEKSKILL     |
| 382896155 | GRAND RAPIDS  |
| 136134882 | STATEN ISLAND |
| 223523449 | Allentown     |
| 710467353 | CLARKSVILLE   |
+-----------+---------------+
```
  
For queries about specific words,  
* There are 359 companies with the "toy" anywhere in the ‘purpose’ field.  
* There are 2796 rows having both the word ‘smith’ in the ‘ptname’ field and reported revenue (e.g. revenue is not empty or 0).  
* The company names and length of the names for 50 random companies with a ptid of P01345770 are listed below.  

```
+-----------------------------------------------------+----------------+
| name                                                | length of name |
+-----------------------------------------------------+----------------+
| The Rivera Krall Family Foundation                  |             34 |
| The Kao Family Foundation                           |             25 |
| Dixon and Carol Doll Family Foundation              |             38 |
| The Joyce Family Foundation                         |             27 |
| The Burt's Bees Greater Good Foundation             |             39 |
| The Watts Family Foundation                         |             27 |
| Witman Family Foundation                            |             24 |
| The Bess Family Foundation                          |             26 |
| BunnyJack Gives Foundation                          |             26 |
| YDFW Inc                                            |              8 |
| The Caine Family Foundation                         |             27 |
| The El-Erian Family Foundation                      |             30 |
| The Hill Family Charitable Foundation               |             37 |
| Spillers Family Foundation                          |             26 |
| The Migdol Family Foundation Inc                    |             32 |
| The SlimGenics Foundation                           |             25 |
| The Regeneration Foundation                         |             27 |
| Weseley Family Charitable Foundation                |             36 |
| The Surplus Line Association of ArizonaFoundation   |             49 |
| The Foreside Foundation                             |             23 |
| John and Diane Scelfo Charitable Foundation         |             43 |
| The 3 Dimensional Wealth Foundation                 |             35 |
| Monasse Foundation                                  |             18 |
| Barbetta Family Foundation                          |             26 |
| The Wayland E Noland Foundation                     |             31 |
| NewCity Foundation                                  |             18 |
| McKiernan Family Foundation                         |             27 |
| Tom Russell Charitable Foundation Inc               |             37 |
| Chauncey Foundation                                 |             19 |
| William H Wood Family Foundation                    |             32 |
| The Trailviews Foundation                           |             25 |
| The Taking Flight Foundation                        |             28 |
| Gobioff Foundation                                  |             18 |
| Yad Ozer Foundation                                 |             19 |
| Plumeria Family Foundation                          |             26 |
| Flora & Doris Denova Foundation                     |             31 |
| Brigham Family Foundation                           |             25 |
| Trebek Family Foundation                            |             24 |
| The Anne R Monroe Foundation                        |             28 |
| The KL Holbrook Serendipitous Foundation            |             40 |
| AFNOVA Inc                                          |             10 |
| The Loftus Family Foundation                        |             28 |
| William Newkirk and Cheryl Tschanz FamilyFoundation |             51 |
| The King-Guffey Family Foundation                   |             33 |
| Burg Family Foundation                              |             22 |
| Start It Foundation                                 |             19 |
| Bill and Faye Stallings Family Foundation           |             41 |
| The Peter and Michelle Detkin FamilyFoundation      |             46 |
| D&P Roberts Family Foundation                       |             29 |
| The Mark E Pollack Foundation                       |             29 |
+-----------------------------------------------------+----------------+
```  

* The number of companies that have a ‘purpose’ field containing less than 10 characters is 51548.  

For employee's data,  
* We can ues the query `select count(1) from employees where year(hire_date) in (1994,1995,1990);` to query the number of folks that got  hired in 1994, 1995 and 1990. And the result is 52560.  
* For a count of all 'Senior Engineer' that were at the company on 1986-06-26, we can use the query `select count(1) from titles where title = 'Senior Engineer' and from_date <= '1986-06-26' and to_date >= '1986-06-26';` and obtain the result which is 2795.  
* A list of unique names of folks that have had a title of "Engineer" can be queried with `select distinct first_name, last_name from employees where emp_no in (select distinct emp_no from titles where title = 'Engineer');`. Since there are 111930 unique names in total, only 50 of them are randomly selected and listed here.  

```
+-------------+-------------+
| first_name  | last_name   |
+-------------+-------------+
| Xianlong    | Perng       |
| Frazer      | Kitsuregawa |
| Akemi       | Prampolini  |
| Quingbo     | Alblas      |
| LiMin       | Crouzet     |
| Toong       | Feinberg    |
| Girolamo    | Heering     |
| Gadiel      | Karlin      |
| Goo         | Shigei      |
| Godehard    | Merkl       |
| Georg       | Pollock     |
| Danel       | Rodite      |
| Kazuhide    | Kowalchuk   |
| Dipayan     | Kugler      |
| Zhensheng   | Hiyoshi     |
| Shay        | Delaune     |
| Chiranjit   | Velardi     |
| Almudena    | Comte       |
| Moni        | Trelles     |
| Krister     | Brendel     |
| Bouchung    | Adachi      |
| Cullen      | Kopetz      |
| Rasikan     | Veevers     |
| Golgen      | Lally       |
| Bartek      | Honglei     |
| Aris        | Legleitner  |
| Takahiro    | Murthy      |
| True        | Capobianchi |
| Constantino | Liesche     |
| Ranga       | Baak        |
| Jacopo      | Erie        |
| Moie        | Danner      |
| Trygve      | Wegerle     |
| Elvis       | Pusterhofer |
| Debatosh    | Ernst       |
| Brewster    | Schaad      |
| Mana        | Griswold    |
| Kendra      | Scharstein  |
| Dmitri      | Stavenow    |
| Hercules    | Maliniak    |
| Dulce       | Kisuki      |
| Shietung    | Skafidas    |
| Sajjad      | Ramaiah     |
| Thanasis    | Percebois   |
| Baziley     | Oxenboll    |
| Sanjiv      | Dredge      |
| Jiang       | Emmerich    |
| Florina     | Potthoff    |
| Saeko       | Wendorf     |
| Kristinn    | Leuchs      |
+-------------+-------------+
```

The 20 randomly selected tweets are obtained from the code in *tweets.py* and given as below.  

```
['Congrats Sindu Giri 👏\n#umsialumni https://t.co/O9vSib7beB', 1]
['Q3: How will the idea of traditional learning shift?', 0]
["HAPPENING NOW! Join us today for UMSI's QuasiCon 2018 a FREE annual gathering that brings information professionals… https://t.co/QOrqV7qBdG", 0]
['.@umsi professor @LionelPeterRob1 was featured on The Lynn Martin show discussing #automatedvehicles! Check it out… https://t.co/aCyDwc0LFj', 2]
['RT @christinacz: Tyree’s hacking the @Allied_Media site and showing us how #amc2018 #TC2018 https://t.co/uhxz6Ia3iR', 1]
['RT @Cs2019Our: This #OurCS2019 project applies user experience research, human-centered design, and interaction design to understand how sm…', 2]
['UMSI students showcase their research, display their projects, and participate in lightning talks about local and g… https://t.co/2I4nqOiEUv', 0]
['RT @Ismail_badache: ACM Table of Contents with all #SIGIR2018 papers is now online here.  \nhttps://t.co/vkqmFzT1g6\n(PDFs available July 8th…', 3]
['RT @gaycyborg: Myself and @_rnbrewer repping @umsi at the session on Making Core Memory lead by @SamShorey at #iConf19. Learning about hist…', 3]
['RT @drchuck: How I record my MOOC lectures (updated) - https://t.co/Gj7PwzmUqt', 1]
['📣 Today is the last day to register for the Fall 2019 Student Exposition 📣 https://t.co/yKse1F38UW https://t.co/nKjCs4nAYu', 0]
["Thanks! Can't wait for 2019 ✨ @igniteumxi https://t.co/054ZSrg98G", 0]
['UMSI senior Jessica Vu is studying UX and is spending her Alternative Spring Break in Detroit working at… https://t.co/FzxxGT7K0t', 1]
["Congrats to Sarita Schoenebeck on her recent promotion to associate professor with tenure 👏She's best known for her… https://t.co/DrLpYWiZPN", 1]
['RT @cab938: @houshuang @umsi @jpgard @las18ed And, the platform for replication we developed is completely open source on GitHub https://t.…', 4]
['.@UChicago assistant professor @saskatchewin looks at gender inequality in labor markets through a study of male an… https://t.co/p52iL6RTGi', 0]
['MSI student Desiree McLain is using information to remove sociotechnical barriers to entrepreneurship in #Detroit.… https://t.co/uBjdD8txrV', 0]
['RT @sdemonner: Anthony Whyte sharing his experience as a Lecturer for the @umsi SI 664 course this Fall with the ITS Teaching &amp; Learning te…', 5]
['RT @an_dre_a_: My awesome ta got me a document for Christmas ❤️ https://t.co/pt3ogiRzpt', 1]
['@uofmbec @UMengineering @UMich @michigan_AI @UMRobotics @UMichResearch 👏👏👏', 0]
```  

And for the last three questions,  
1) There will be ProgrammingError when there's something wrong in programming in MySQL. For instance, when using a table that is not found. DataError occurs when something goes wrong about data processing. For instance, when a number is divided by 0.  
2) Lists will be returned by **fetch all**.  
3) We should close the cursor with *.close()* on the cursor. And this is done in my code.

That's all of the results. And I hope they will help!

Best regards,
Xinhao Liao

--  
<span style="color:blue">Database query list</span>   
```
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

mysql> select count(distinct ein) from taxdata where year = 2014 and city = 'Ann Arbor';
+---------------------+
| count(distinct ein) |
+---------------------+
|                 245 |
+---------------------+
1 row in set (0.46 sec)

mysql> select distinct name from taxdata where revenue > 10000000000 and year = 2014;
+---------------------------------------------------------------+
| name                                                          |
+---------------------------------------------------------------+
| IHC HEALTH SERVICES INC                                       |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F               |
| Banner Health                                                 |
| KAISER FOUNDATION HEALTH PLAN INC                             |
| Thrivent Financial for Lutherans                              |
| UAW RETIREE MEDICAL BENEFITS TRUST                            |
| KAISER FOUNDATION HOSPITALS                                   |
| Massachusetts Institute of Technology                         |
| UPMC GROUP                                                    |
| Cornell University                                            |
| Trustees of the University of Pennsylvania                    |
| President and Fellows of Harvard College                      |
| YALE UNIVERSITY                                               |
| STATE EMPLOYEES' CREDIT UNION                                 |
| DUKE UNIVERSITY                                               |
| Howard Hughes Medical Institute                               |
| Partners HealthCare System Inc & AffiliatesGroup Return       |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY |
| DIGNITY HEALTH                                                |
+---------------------------------------------------------------+
19 rows in set (1.12 sec)

mysql> select distinct name from taxdata where revenue > 10000000000;
ERROR 2006 (HY000): MySQL server has gone away
No connection. Trying to reconnect...
Connection id:    59
Current database: ro_query

+---------------------------------------------------------------+
| name                                                          |
+---------------------------------------------------------------+
| IHC HEALTH SERVICES INC                                       |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F               |
| KAISER FOUNDATION HEALTH PLAN INC                             |
| Banner Health                                                 |
| KAISER FOUNDATION HOSPITALS                                   |
| Thrivent Financial for Lutherans                              |
| UAW RETIREE MEDICAL BENEFITS TRUST                            |
| Massachusetts Institute of Technology                         |
| UPMC GROUP                                                    |
| Cornell University                                            |
| Trustees of the University of Pennsylvania                    |
| President and Fellows of Harvard College                      |
| YALE UNIVERSITY                                               |
| STATE EMPLOYEES' CREDIT UNION                                 |
| DUKE UNIVERSITY                                               |
| Howard Hughes Medical Institute                               |
| Partners HealthCare System Inc & AffiliatesGroup Return       |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY |
| WORKERS' COMPENSATION REINSURANCE ASSOCIATION                 |
| DIGNITY HEALTH                                                |
+---------------------------------------------------------------+
20 rows in set (0.68 sec)

mysql> select distinct name, expenses from taxdata where year = 2013 order by expenses desc limit 20;
+---------------------------------------------------------+-------------+
| name                                                    | expenses    |
+---------------------------------------------------------+-------------+
| KAISER FOUNDATION HEALTH PLAN INC                       | 41982288055 |
| UNIVERSITY OF ROCHESTER                                 |  2776536619 |
| ST FRANCIS HOSPITAL AND MEDICAL CENTER                  |   713077460 |
| WELLSTAR HEALTH SYSTEM INC                              |   660400156 |
| SKY LAKES MEDICAL CENTER                                |   488333644 |
| NAPLES COMMUNITY HOSPITAL INC                           |   426168844 |
| YAKIMA VALLEY MEMORIAL HOSPITAL                         |   401985865 |
| EMBRY-RIDDLE AERONAUTICAL UNIVERSITY INC                |   374154000 |
| ST MARY'S HOSPITAL & MEDICAL CENTERINC                  |   372041256 |
| St Barnabas Hospital                                    |   349321637 |
| HOSPITAL COMMITTEE FOR THE LIVERMOREPLEASANTON AREA     |   341257233 |
| VALLEY PRESBYTERIAN HOSPITAL                            |   273789797 |
| WINCHESTER HOSPITAL                                     |   264605951 |
| TEAMSTERS WESTERN REGION AND NEW JERSEYHEALTH CARE FUND |   231059337 |
| OROVILLE HOSPITAL                                       |   200242937 |
| ST JOSEPH HOSPITAL OF EUREKA                            |   196999313 |
| SWARTHMORE COLLEGE                                      |   168742729 |
| ST FRANCIS HOSPITAL - POUGHKEEPSIE                      |   164506124 |
| Vail Clinic Inc                                         |   159617575 |
| TUSKEGEE UNIVERSITY                                     |   152572824 |
+---------------------------------------------------------+-------------+
20 rows in set (0.34 sec)

mysql> select distinct ein, city from taxdata where revenue BETWEEN 1 AND 100000 and expenses BETWEEN 10000 AND 200000 order by rand() limit 20;
+-----------+---------------+
| ein       | city          |
+-----------+---------------+
| 541945858 | ROCHESTER     |
| 273084801 | Los Angeles   |
| 770319903 | Los Gatos     |
| 431769903 | Van Buren     |
| 521990279 | Silver Spring |
| 930782729 | PORTLAND      |
| 237168819 | NEW BRITAIN   |
| 263613626 | MEMPHIS       |
| 231034791 | GETTYSBURG    |
| 386100681 | Flint         |
| 680657977 | SWARTZ CREEK  |
| 237372144 | Portland      |
| 113649939 | MEXICO        |
| 141865407 | ORISKANY      |
| 521410219 | Germantown    |
| 273558027 | PEEKSKILL     |
| 382896155 | GRAND RAPIDS  |
| 136134882 | STATEN ISLAND |
| 223523449 | Allentown     |
| 710467353 | CLARKSVILLE   |
+-----------+---------------+
20 rows in set (0.54 sec)

mysql> select count(distinct ein) from taxdata where purpose LIKE "%toy%";
+---------------------+
| count(distinct ein) |
+---------------------+
|                 359 |
+---------------------+
1 row in set (2.54 sec)

mysql> select count(1) from taxdata where ptname LIKE "%smith%" and revenue IS NOT NULL and revenue != 0;
+----------+
| count(1) |
+----------+
|     2796 |
+----------+
1 row in set (0.44 sec)

mysql> select distinct name, LENGTH(name) as 'length of name' from taxdata where ptid = 'P01345770' order by rand() limit 50;
+-----------------------------------------------------+----------------+
| name                                                | length of name |
+-----------------------------------------------------+----------------+
| The Rivera Krall Family Foundation                  |             34 |
| The Kao Family Foundation                           |             25 |
| Dixon and Carol Doll Family Foundation              |             38 |
| The Joyce Family Foundation                         |             27 |
| The Burt's Bees Greater Good Foundation             |             39 |
| The Watts Family Foundation                         |             27 |
| Witman Family Foundation                            |             24 |
| The Bess Family Foundation                          |             26 |
| BunnyJack Gives Foundation                          |             26 |
| YDFW Inc                                            |              8 |
| The Caine Family Foundation                         |             27 |
| The El-Erian Family Foundation                      |             30 |
| The Hill Family Charitable Foundation               |             37 |
| Spillers Family Foundation                          |             26 |
| The Migdol Family Foundation Inc                    |             32 |
| The SlimGenics Foundation                           |             25 |
| The Regeneration Foundation                         |             27 |
| Weseley Family Charitable Foundation                |             36 |
| The Surplus Line Association of ArizonaFoundation   |             49 |
| The Foreside Foundation                             |             23 |
| John and Diane Scelfo Charitable Foundation         |             43 |
| The 3 Dimensional Wealth Foundation                 |             35 |
| Monasse Foundation                                  |             18 |
| Barbetta Family Foundation                          |             26 |
| The Wayland E Noland Foundation                     |             31 |
| NewCity Foundation                                  |             18 |
| McKiernan Family Foundation                         |             27 |
| Tom Russell Charitable Foundation Inc               |             37 |
| Chauncey Foundation                                 |             19 |
| William H Wood Family Foundation                    |             32 |
| The Trailviews Foundation                           |             25 |
| The Taking Flight Foundation                        |             28 |
| Gobioff Foundation                                  |             18 |
| Yad Ozer Foundation                                 |             19 |
| Plumeria Family Foundation                          |             26 |
| Flora & Doris Denova Foundation                     |             31 |
| Brigham Family Foundation                           |             25 |
| Trebek Family Foundation                            |             24 |
| The Anne R Monroe Foundation                        |             28 |
| The KL Holbrook Serendipitous Foundation            |             40 |
| AFNOVA Inc                                          |             10 |
| The Loftus Family Foundation                        |             28 |
| William Newkirk and Cheryl Tschanz FamilyFoundation |             51 |
| The King-Guffey Family Foundation                   |             33 |
| Burg Family Foundation                              |             22 |
| Start It Foundation                                 |             19 |
| Bill and Faye Stallings Family Foundation           |             41 |
| The Peter and Michelle Detkin FamilyFoundation      |             46 |
| D&P Roberts Family Foundation                       |             29 |
| The Mark E Pollack Foundation                       |             29 |
+-----------------------------------------------------+----------------+
50 rows in set (0.36 sec)

mysql> select count(distinct ein) from taxdata where purpose IS NOT NULL and LENGTH(purpose)<10;
+---------------------+
| count(distinct ein) |
+---------------------+
|               51548 |
+---------------------+
1 row in set (0.47 sec)

mysql> SHOW DATABASES;
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
| ro_twitter         |
| sys                |
+--------------------+
10 rows in set (0.05 sec)

mysql> use ro_employees;
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

mysql> select * from employees limit 1;
+--------+------------+------------+-----------+--------+------------+
| emp_no | birth_date | first_name | last_name | gender | hire_date  |
+--------+------------+------------+-----------+--------+------------+
|  10001 | 1953-09-02 | Georgi     | Facello   | M      | 1986-06-26 |
+--------+------------+------------+-----------+--------+------------+
1 row in set (0.05 sec)

mysql> select count(1) from employees where year(hire_date) in (1994,1995,1990);
+----------+
| count(1) |
+----------+
|    52560 |
+----------+
1 row in set (0.46 sec)

mysql> desc titles;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| emp_no    | int(11)     | NO   | PRI | NULL    |       |
| title     | varchar(50) | NO   | PRI | NULL    |       |
| from_date | date        | NO   | PRI | NULL    |       |
| to_date   | date        | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
4 rows in set (0.03 sec)

mysql> select * from titles limit 1;
+--------+-----------------+------------+------------+
| emp_no | title           | from_date  | to_date    |
+--------+-----------------+------------+------------+
|  10001 | Senior Engineer | 1986-06-26 | 9999-01-01 |
+--------+-----------------+------------+------------+
1 row in set (0.03 sec)

mysql> select count(1) from titles where title = 'Senior Engineer' and from_date <= '1986-06-26' and to_date >= '1986-06-26';
+----------+
| count(1) |
+----------+
|     2795 |
+----------+
1 row in set (0.72 sec)

mysql> select distinct first_name, last_name from employees where emp_no in (select distinct emp_no from titles where title = 'Engineer');
^C^C -- query aborted
+----------------+------------------+
| first_name     | last_name        |
+----------------+------------------+
+----------------+------------------+
111930 rows in set (1.31 sec)

mysql> select distinct first_name, last_name from employees where emp_no in (select distinct emp_no from titles where title = 'Engineer') order by rand() limit 50;
+-------------+-------------+
| first_name  | last_name   |
+-------------+-------------+
| Xianlong    | Perng       |
| Frazer      | Kitsuregawa |
| Akemi       | Prampolini  |
| Quingbo     | Alblas      |
| LiMin       | Crouzet     |
| Toong       | Feinberg    |
| Girolamo    | Heering     |
| Gadiel      | Karlin      |
| Goo         | Shigei      |
| Godehard    | Merkl       |
| Georg       | Pollock     |
| Danel       | Rodite      |
| Kazuhide    | Kowalchuk   |
| Dipayan     | Kugler      |
| Zhensheng   | Hiyoshi     |
| Shay        | Delaune     |
| Chiranjit   | Velardi     |
| Almudena    | Comte       |
| Moni        | Trelles     |
| Krister     | Brendel     |
| Bouchung    | Adachi      |
| Cullen      | Kopetz      |
| Rasikan     | Veevers     |
| Golgen      | Lally       |
| Bartek      | Honglei     |
| Aris        | Legleitner  |
| Takahiro    | Murthy      |
| True        | Capobianchi |
| Constantino | Liesche     |
| Ranga       | Baak        |
| Jacopo      | Erie        |
| Moie        | Danner      |
| Trygve      | Wegerle     |
| Elvis       | Pusterhofer |
| Debatosh    | Ernst       |
| Brewster    | Schaad      |
| Mana        | Griswold    |
| Kendra      | Scharstein  |
| Dmitri      | Stavenow    |
| Hercules    | Maliniak    |
| Dulce       | Kisuki      |
| Shietung    | Skafidas    |
| Sajjad      | Ramaiah     |
| Thanasis    | Percebois   |
| Baziley     | Oxenboll    |
| Sanjiv      | Dredge      |
| Jiang       | Emmerich    |
| Florina     | Potthoff    |
| Saeko       | Wendorf     |
| Kristinn    | Leuchs      |
+-------------+-------------+
50 rows in set (0.76 sec)

mysql> show databases;
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
| ro_twitter         |
| sys                |
+--------------------+
10 rows in set (0.03 sec)

mysql> use ro_twitter;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------------+
| Tables_in_ro_twitter |
+----------------------+
| tweets               |
+----------------------+
1 row in set (0.02 sec)

mysql> desc tweets;
+-------+------------+------+-----+---------+-------+
| Field | Type       | Null | Key | Default | Extra |
+-------+------------+------+-----+---------+-------+
| id    | bigint(20) | NO   | PRI | NULL    |       |
| tweet | longtext   | YES  |     | NULL    |       |
+-------+------------+------+-----+---------+-------+
2 rows in set (0.02 sec)
```

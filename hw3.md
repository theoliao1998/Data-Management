**From:** Xinhao Liao  
**To:** Raj Kumar  
**Date:** Week 1  

Hi Raj,  

I have checked the database and am able to answer these questions now. The query records are appended in the end and the documentations I created is appended in documentation.pdf.  

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
* For companies that made between $1-100,000 in revenue and between $10000-200,000 in expenses, the list could be too long. So randomly selected 20 companies' EINs and cities are listed here.
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

```

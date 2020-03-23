**From:** Xinhao Liao  
**To:** Lawrence  

Hi Lawrence,  

I hope you have a good week. I have created all the databases and tables needed. The queries are appended in the end. And database exports of each database are also dumped and attached.

Best,
Xinhao Liao


--  
Database query list  
```
mysql> create database newspaper_website;
Query OK, 1 row affected (0.04 sec)

mysql> use newspaper_website;
Database changed

mysql> CREATE TABLE `newspaper_website`.`Stories` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `sectionID` INT NOT NULL,
    ->   `content` TEXT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.11 sec)

mysql> CREATE TABLE `newspaper_website`.`Sections` (
    ->   `ID` INT NOT NULL  AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.10 sec)

mysql> CREATE TABLE `newspaper_website`.`Comments` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `content` TEXT NULL,
    ->   `story_id` INT NOT NULL,
    ->   `reader_id` INT NOT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.09 sec)

mysql> CREATE TABLE `newspaper_website`.`Readers` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.09 sec)

mysql> CREATE TABLE `newspaper_website`.`Authors` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.09 sec)

mysql> CREATE TABLE `newspaper_website`.`Authoring` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `story_id` INT NOT NULL,
    ->   `author_id` INT NOT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.10 sec)

mysql> create database library_circulation;
Query OK, 1 row affected (0.08 sec)

mysql> use library_circulation;
Database changed

mysql> CREATE TABLE `library_circulation`.`Books` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `title` VARCHAR(255) NOT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.10 sec)

mysql> CREATE TABLE `library_circulation`.`Patrons` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NOT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.10 sec)

mysql> CREATE TABLE `library_circulation`.`Circulation_records` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `book_id` INT NOT NULL,
    ->   `patron_id` INT NOT NULL,
    ->   `check_in_data` DATETIME NULL,
    ->   `check_out_date` DATETIME NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
ERROR 2006 (HY000): MySQL server has gone away
No connection. Trying to reconnect...
Connection id:    32
Current database: library_circulation

Query OK, 0 rows affected (0.37 sec)

mysql> create database employee_training;
Query OK, 1 row affected (0.07 sec)

mysql> use employee_training;
Database changed
mysql> CREATE TABLE `employee_training`.`Teachers` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NOT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.09 sec)

mysql> CREATE TABLE `employee_training`.`Classes` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `teacher_id` INT NOT NULL,
    ->   `objectives` TEXT NULL,
    ->   `start_data` DATETIME NULL,
    ->   `end_date` DATETIME NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.10 sec)


mysql> CREATE TABLE `employee_training`.`Employees` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NOT NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.08 sec)

mysql> CREATE TABLE `employee_training`.`Registered_records` (
    ->   `ID` INT NOT NULL AUTO_INCREMENT,
    ->   `class_id` INT NOT NULL,
    ->   `emp_id` INT NOT NULL,
    ->   `registered_data` DATETIME NULL,
    ->   `cancelled_date` DATETIME NULL,
    ->   CONSTRAINT pk PRIMARY KEY (`ID`));
Query OK, 0 rows affected (0.13 sec)

mysql> exit
Bye
```

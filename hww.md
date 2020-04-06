**From:** Xinhao Liao  
**To:** Dr Freestone  

Hi Dr Freestone,  

I am glad to be involved in the program Mindful Michigan and help in building the system.  

I have already created the database and inserted some sample fake data as required. The queries are listed in the end. Also, the database is exported to *Mindful_Michigan.sql*, which is attached.  

Best,  
Xinhao Liao  

------  
Query List  
```sql
create database Mindful_Michigan;

create table employees
(
	emp_id int auto_increment,
	name varchar(255) not null,
	start_date date not null,
	constraint employees_pk
		primary key (emp_id)
);

create table methods
(
	id int auto_increment,
	name varchar(255) not null,
	constraint methods_pk
		primary key (id)
);

create table practice_mindfulness
(
	id int auto_increment,
	emp_id int not null,
	method_id int not null,
	start_time datetime not null,
	stop_time datetime null,
	constraint practice_mindfulness_pk
		primary key (id),
	constraint practice_mindfulness_employees_emp_id_fk
		foreign key (emp_id) references employees (emp_id)
			on update cascade on delete cascade,
	constraint practice_mindfulness_methods_id_fk
		foreign key (method_id) references methods (id)
			on update cascade on delete cascade
);

create table daily_best_practice
(
	emp_id int not null,
	date date not null,
	if_breathe boolean not null,
	if_exercise boolean not null,
	if_sleep_well boolean not null,
	if_drink_water boolean not null,
	if_be_kind boolean not null,
	constraint daily_best_practice_pk
		primary key (emp_id,date),
	constraint daily_best_practice_employees_emp_id_fk
		foreign key (emp_id) references employees (emp_id)
			on update cascade on delete cascade
);

INSERT INTO Mindful_Michigan.methods (name) VALUES ('yoga');

INSERT INTO Mindful_Michigan.methods (name) VALUES ('deep breathing');

INSERT INTO Mindful_Michigan.employees (name, start_date) VALUES ('Xinhao Liao', '2020-04-01');

INSERT INTO Mindful_Michigan.practice_mindfulness (emp_id, method_id, start_time, stop_time) VALUES (1, 2, '2020-04-01 00:00:00', '2020-04-01 23:59:59');

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-01', 1, 0, 1, 1, 1);

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-02', 1, 0, 0, 1, 1);

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-03', 1, 0, 1, 1, 1);

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-04', 1, 0, 0, 1, 1);

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-05', 1, 0, 1, 1, 1);

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-06', 1, 0, 0, 1, 1);

INSERT INTO Mindful_Michigan.daily_best_practice (emp_id, date, if_breathe, if_exercise, if_sleep_well, if_drink_water, if_be_kind) VALUES (1, '2020-04-07', 1, 0, 1, 1, 1);
```

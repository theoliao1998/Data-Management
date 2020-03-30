Hi Raj,

I have already inserted 5-10 rows of sample data into the tables.

And then I select the table **Comments** in the Database **newspaper_website**, and randomly delete three rows of data with the query as follows.  
```sql
delete from newspaper_website.Comments order by rand() limit 3;
```
After that, I further update the **content** value of the last row of this table with the query as follows.  
```sql
UPDATE newspaper_website.Comments t SET t.content = 'It''s a darn shame that the facility closed after all these years!!!' order by t.ID desc limit 1;
```

All the queries are appended in the end.  

Best,  
Xinhao Liao

----
Query list  
```sql
use newspaper_website;

INSERT INTO newspaper_website.Stories (sectionID, content) VALUES (1, 'Closure of Michigan roller hockey mecca leaves players, employees heartbroken');

INSERT INTO newspaper_website.Stories (sectionID, content) VALUES (2, 'Can Japan’s Economy Get Any Worse? It May Soon Find Out');

INSERT INTO newspaper_website.Stories (sectionID, content) VALUES (3, 'WDIV''s Evrod Cassimy shares update on COVID-19 recovery');

INSERT INTO newspaper_website.Stories (sectionID, content) VALUES (3, 'Ann Arbor Summer Festival cancels indoor shows');

INSERT INTO newspaper_website.Stories (sectionID, content) VALUES (2, 'La-Z-Boy lays off 6,800, slashes compensation, closes plants, stores');

INSERT INTO newspaper_website.Sections (name) VALUES ('Sports');

INSERT INTO newspaper_website.Sections (name) VALUES ('Business');

INSERT INTO newspaper_website.Sections (name) VALUES ('Entertainment');

INSERT INTO newspaper_website.Sections (name) VALUES ('Politics');

INSERT INTO newspaper_website.Sections (name) VALUES ('Technology');

INSERT INTO newspaper_website.Authors (name) VALUES ('Gregg Krupa');

INSERT INTO newspaper_website.Authors (name) VALUES ('Nolan Bianchi');

INSERT INTO newspaper_website.Authors (name) VALUES ('Ben Dooley');

INSERT INTO newspaper_website.Authors (name) VALUES ('Makiko Inoue');

INSERT INTO newspaper_website.Authors (name) VALUES ('Melody Baetens');

INSERT INTO newspaper_website.Authoring (story_id, author_id) VALUES (1, 2);

INSERT INTO newspaper_website.Authoring (story_id, author_id) VALUES (2, 3);

INSERT INTO newspaper_website.Authoring (story_id, author_id) VALUES (2, 4);

INSERT INTO newspaper_website.Authoring (story_id, author_id) VALUES (3, 5);

INSERT INTO newspaper_website.Authoring (story_id, author_id) VALUES (4, 5);

INSERT INTO newspaper_website.Authoring (story_id, author_id) VALUES (5, 1);

INSERT INTO newspaper_website.Readers (name) VALUES ('Kenneth J. Dillon');

INSERT INTO newspaper_website.Readers (name) VALUES ('Alan Quellmalz');

INSERT INTO newspaper_website.Readers (name) VALUES ('Jackson Lini');

INSERT INTO newspaper_website.Readers (name) VALUES ('James Zohoury');

INSERT INTO newspaper_website.Readers (name) VALUES ('David Weaver');

INSERT INTO newspaper_website.Comments (content, story_id, reader_id) VALUES ('Even though Japan mishandled the cruise ship episode, the Olympics issue, and testing, it has far fewer confirmed coronavirus cases than other large, advanced countries.  The recent uptick in cases should not distract us from asking the critical question of what the Japanese may be doing right.  My bets are on wearing face masks and gargling, which is a common way to ward off respiratory infections in Japan and is supported by many Japanese research studies.  Americans have finally started to talk about wearing face masks, but gargling hardly gets a mention.', 2, 1);

INSERT INTO newspaper_website.Comments (content, story_id, reader_id) VALUES ('And so do the employees still have health care during this temporary time? Medicare for All...I can see Canada.', 5, 2);

INSERT INTO newspaper_website.Comments (content, story_id, reader_id) VALUES ('I know I read or heard somewhere that this stimulus package has something to the effect of paying the "full" salary for up to four months for those who lost their jobs due to the coronavirus virus. If true, maybe La-Z-Boy figured it made financial sense to layoff it''s workforce and the let the Goverenment pick up the tab. Truthfully, I don''t know how the Government could afford to do this. Seems in would incentivise companies to lay workers off. Maybe this was something the democrats proposed that never made into the bill?', 5, 3);

INSERT INTO newspaper_website.Comments (content, story_id, reader_id) VALUES ('That is very sad news. I was looking forward to my kids playing there when they were old enough. It was a great place filled with great people. It will be missed.
                   Z', 1, 4);

INSERT INTO newspaper_website.Comments (content, story_id, reader_id) VALUES ('It''s a darn shame that the facility closed after all these years.', 1, 5);

use library_circulation;

INSERT INTO library_circulation.Books (title) VALUES ('The Book of Why: The New Science of Cause and Effect');

INSERT INTO library_circulation.Books (title) VALUES ('What Do We Know about War?');

INSERT INTO library_circulation.Books (title) VALUES ('Probabilistic Reasoning in Intelligent Systems: Networks of Plausible Inference');

INSERT INTO library_circulation.Books (title) VALUES ('Outliers: The Story of Success');

INSERT INTO library_circulation.Books (title) VALUES ('Thinking, Fast and Slow');

INSERT INTO library_circulation.Patrons (name) VALUES ('Robert Smith');

INSERT INTO library_circulation.Patrons (name) VALUES ('Mark Edward');

INSERT INTO library_circulation.Patrons (name) VALUES ('Thomas Black');

INSERT INTO library_circulation.Patrons (name) VALUES ('David Smith');

INSERT INTO library_circulation.Patrons (name) VALUES ('James Carlos');

INSERT INTO library_circulation.Circulation_records (book_id, patron_id, check_in_data, check_out_date) VALUES (1, 3, '2019-03-30 14:38:54', '2019-04-25 17:39:03');

INSERT INTO library_circulation.Circulation_records (book_id, patron_id, check_in_data, check_out_date) VALUES (1, 1, '2019-05-19 19:22:35', '2019-06-30 10:23:58');

INSERT INTO library_circulation.Circulation_records (book_id, patron_id, check_in_data, check_out_date) VALUES (5, 4, '2019-04-25 14:12:26', '2019-05-25 12:40:40');

INSERT INTO library_circulation.Circulation_records (book_id, patron_id, check_in_data, check_out_date) VALUES (2, 1, '2019-06-30 17:41:17', '2019-07-21 09:19:41');

INSERT INTO library_circulation.Circulation_records (book_id, patron_id, check_in_data, check_out_date) VALUES (3, 1, '2019-07-21 16:42:16', '2019-08-18 10:00:42');

use employee_training;

INSERT INTO employee_training.Classes (teacher_id, objectives, start_data, end_date) VALUES (1, 'Mastering presentations with PowerPoint ', '2018-04-26 00:00:00', '2018-06-30 00:00:00');

INSERT INTO employee_training.Classes (teacher_id, objectives, start_data, end_date) VALUES (3, 'Mastering Excel spreadsheets', '2018-03-01 00:00:00', '2020-05-30 00:00:00');

INSERT INTO employee_training.Classes (teacher_id, objectives, start_data, end_date) VALUES (2, 'Learning how to conduct interviews. ', '2019-03-30 00:00:00', '2019-07-01 00:00:00');

INSERT INTO employee_training.Classes (teacher_id, objectives, start_data, end_date) VALUES (2, 'Learning communicating skills.', '2019-03-30 00:00:00', '2019-07-01 00:00:00');

INSERT INTO employee_training.Classes (teacher_id, objectives, start_data, end_date) VALUES (4, 'Learning strategic planning skills.', '2019-09-03 00:00:00', '2019-12-12 00:00:00');

INSERT INTO employee_training.Classes (teacher_id, objectives, start_data, end_date) VALUES (5, 'Mastering Adobe Photoshop', '2019-09-30 00:00:00', '2019-12-15 00:00:00');

INSERT INTO employee_training.Teachers (name) VALUES ('Robert Smith');

INSERT INTO employee_training.Teachers (name) VALUES ('James Johnson');

INSERT INTO employee_training.Teachers (name) VALUES ('Maria Garcia');

INSERT INTO employee_training.Teachers (name) VALUES ('Chris Lee');

INSERT INTO employee_training.Teachers (name) VALUES ('Paul Brown');

INSERT INTO employee_training.Employees (name) VALUES ('John Smith');

INSERT INTO employee_training.Employees (name) VALUES ('David William');

INSERT INTO employee_training.Employees (name) VALUES ('Daniel Ma');

INSERT INTO employee_training.Employees (name) VALUES ('Sarah Smith');

INSERT INTO employee_training.Employees (name) VALUES ('Juan Carlos');

INSERT INTO employee_training.Registered_records (class_id, emp_id, registered_data, cancelled_date) VALUES (1, 1, '2018-04-25 14:21:37', null);

INSERT INTO employee_training.Registered_records (class_id, emp_id, registered_data, cancelled_date) VALUES (2, 1, '2018-03-01 13:11:13', '2018-03-15 18:23:05');

INSERT INTO employee_training.Registered_records (class_id, emp_id, registered_data, cancelled_date) VALUES (5, 3, '2019-09-01 21:18:54', null);

INSERT INTO employee_training.Registered_records (class_id, emp_id, registered_data, cancelled_date) VALUES (4, 3, '2019-03-29 12:25:07', '2019-04-05 20:25:24');

INSERT INTO employee_training.Registered_records (class_id, emp_id, registered_data, cancelled_date) VALUES (3, 2, '2019-03-30 09:26:12', null);

delete from newspaper_website.Comments order by rand() limit 3;

UPDATE newspaper_website.Comments t SET t.content = 'It''s a darn shame that the facility closed after all these years!!!' order by t.ID desc limit 1;
```

**From:** Xinhao Liao  
**To:** Lawrence Summerset  

Hi Raj,  

I hope you have a good week. I have completed the work for this week and will show it as follows.

For the newspaper website, I design the database and create a ER diagram for it as follows based on the description. For some tables like *Stories*, we might also add some extra fields like **title**,**publish_date** if needed. But the overall structure should remain the same.
![image](https://user-images.githubusercontent.com/53862461/76786004-d4b5fb80-678c-11ea-9708-527191f10f51.png)

For the new circulation system of a library, a basic design according to the description is given below. Here the book refers to a book entity, and more details about the book might be added (possibly to extra tables) if needed.
![image](https://user-images.githubusercontent.com/53862461/76788870-1f864200-6792-11ea-9a01-3c7a5a81393b.png)

And for the internal employee training information, the database is designed according to the description and given below. 
![image](https://user-images.githubusercontent.com/53862461/76792528-9e32ad80-6799-11ea-81c5-c3f6f8ee06ea.png)

To copy the database, I first export the database with the following command in my terminal outside of any mysql shell
```shell
mysqldump -h 34.68.154.83 --port 10586 -u theoliao-rw -pXXXXX world > mars.sql 
```
where **XXXXX** refers to my password. Then I connect to mysql shell (in the readwrite mode) with the command 
```shell
mysql -h 34.68.154.83 --port 10586 -u theoliao-rw -pXXXXX
```
and then create the database *mars* as follows in mysql shell.
```sql
create database mars;
```
After that, I exited the mysql shell, and use the following command in the terminal to import the exported database as database *mars*.
```shell
mysql -h 34.68.154.83 --port 10586 -u theoliao-rw -pXXXXX mars < mars.sql
```
Then, the database is successfully copied, and we can use `use mars` in mysql shell and see the same tables that are in world now.  

Best regards,  
Xinhao Liao

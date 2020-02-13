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
  
```

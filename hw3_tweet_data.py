#!/usr/bin/env python
# coding: utf-8

# In[29]:


import pymysql
import json

con = pymysql.connect(host="34.68.154.83", port=10586,user="theoliao-ro",password="",database="ro_twitter",cursorclass=pymysql.cursors.DictCursor) # connect to the database


cur = con.cursor()
cur.execute("select tweet from tweets order by rand() limit 20;") # execute the query
for row in cur:
    tmp = json.loads(row["tweet"]) # parse the json in one row
    print([tmp["text"],tmp["retweet_count"] if "retweet_count" in tmp else 0]) # if 'retweet_count' is not a valid key, the count is 0

cur.close() # close the cursor

```sql
mysql> use HospitalInfo;

mysql> select CONCAT(h.Address,', ',c1.CityName,', ',c2.CountyName,', ',s.StateName,' ',h.ZIP_Code) from Hospitals h join City c1 on h.City=c1.CityId join County c2 on c1.CountyId=c2.CountyId join State s on c2.StateId=s.StateId where s.StateName='MI' order by h.Overall_rating desc limit 5;  
+---------------------------------------------------------------------------------------+
| CONCAT(h.Address,', ',c1.CityName,', ',c2.CountyName,', ',s.StateName,' ',h.ZIP_Code) |
+---------------------------------------------------------------------------------------+
| 416 CONNABLE AVE, PETOSKEY, EMMET, MI 49770                                           |
| 775 S MAIN ST, CHELSEA, WASHTENAW, MI 48118                                           |
| 602 MICHIGAN AVE, HOLLAND, OTTAWA, MI 49423                                           |
| 615 S BOWER STREET, GREENVILLE, MONTCALM, MI 48838                                    |
| 200 N MADISON, MARSHALL, CALHOUN, MI 49068                                            |
+---------------------------------------------------------------------------------------+  
5 rows in set (0.05 sec)

mysql> select h.Hospital_Name from Hospitals h join Rating_Records r1 on h.Hospital_Id=r1.Hospital_Id join Ratings r2 on r1.Rating_Id=r2.Rating_Id where r2.Rating_Name in ('Above the national average','Same as the national average') group by h.Hospital_Id having count(1)=7 order by rand() limit 5;
+--------------------------------------+
| Hospital_Name                        |
+--------------------------------------+
| LAKEVIEW MEDICAL CENTER              |
| ASANTE ROGUE REGIONAL MEDICAL CENTER |
| ST MARYS HOSPITAL MEDICAL CTR        |
| OVERLAKE HOSPITAL MEDICAL CENTER     |
| NORTH KANSAS CITY HOSPITAL           |
+--------------------------------------+
5 rows in set (0.04 sec)

mysql> select h.Hospital_Name from Hospitals h join Rating_Records r1 on h.Hospital_Id=r1.Hospital_Id join Ratings r2 on r1.Rating_Id=r2.Rating_Id join City c1 on h.City=c1.CityId join County c2 on c1.CountyId=c2.CountyId join State s on c2.StateId=s.StateId where s.StateName='MI' and r2.Rating_Name in ('Above the national average','Same as the national average') group by h.Hospital_Id having count(1)=(select count(*) as c from Criteria_Info);
+--------------------------------------------+
| Hospital_Name                              |
+--------------------------------------------+
| SPECTRUM HEALTH LUDINGTON HOSPITAL         |
| ST JOHN RIVER DISTRICT HOSPITAL            |
| BRONSON SOUTH HAVEN HOSPITAL               |
| SPECTRUM HEALTH UNITED HOSPITAL            |
| SPECTRUM HEALTH ZEELAND COMMUNITY HOSPITAL |
| HOLLAND COMMUNITY HOSPITAL                 |
| NORTH OTTAWA COMMUNITY HEALTH SYSTEM       |
| OAKLAWN HOSPITAL                           |
| SAINT MARY'S HEALTH CARE                   |
| OTSEGO MEMORIAL HOSPITAL                   |
| SAINT JOSEPH MERCY LIVINGSTON HOSPITAL     |
| COMMUNITY HEALTH CENTER OF BRANCH COUNTY   |
| HILLSDALE HOSPITAL                         |
| UP HEALTH SYSTEM PORTAGE                   |
| MUNSON HEALTHCARE GRAYLING HOSPITAL        |
| STURGIS HOSPITAL                           |
| DICKINSON COUNTY MEMORIAL HOSPITAL         |
| PROMEDICA BIXBY HOSPITAL                   |
| CHIPPEWA COUNTY WAR MEMORIAL HOSPITAL      |
| MCLAREN CENTRAL MICHIGAN                   |
| ST JOSEPH MERCY CHELSEA                    |
| MIDMICHIGAN MEDICAL CENTER-MIDLAND         |
| SPECTRUM HEALTH BIG RAPIDS HOSPITAL        |
| MCLAREN - NORTHERN MICHIGAN                |
| WEST SHORE MEDICAL CENTER                  |
| MIDMICHIGAN MEDICAL CENTER-GRATIOT         |
+--------------------------------------------+
26 rows in set (0.04 sec)
```

Query List

0. Choose the database used.  
```sql
use HospitalInfo;
```
1. What are the full addresses of the top5 hospitals in MI?
```sql
select
   h.Hospital_Name, CONCAT(h.Address, ', ', c1.CityName, ', ', c2.CountyName, ',', s.StateName, ' ', h.ZIP_Code) as Full_Address 
from
   Hospitals h 
   join
      City c1 
      on h.City = c1.CityId 
   join
      County c2 
      on c1.CountyId = c2.CountyId 
   join
      State s 
      on c2.StateId = s.StateId 
where
   s.StateName = 'MI' 
order by
   h.Overall_Rating desc limit 5;

+---------------------------------+---------------------------------------------------+
| Hospital_Name                   | Full_Address                                      |
+---------------------------------+---------------------------------------------------+
| MCLAREN - NORTHERN MICHIGAN     | 416 CONNABLE AVE, PETOSKEY, EMMET,MI 49770        |
| ST JOSEPH MERCY CHELSEA         | 775 S MAIN ST, CHELSEA, WASHTENAW,MI 48118        |
| HOLLAND COMMUNITY HOSPITAL      | 602 MICHIGAN AVE, HOLLAND, OTTAWA,MI 49423        |
| SPECTRUM HEALTH UNITED HOSPITAL | 615 S BOWER STREET, GREENVILLE, MONTCALM,MI 48838 |
| OAKLAWN HOSPITAL                | 200 N MADISON, MARSHALL, CALHOUN,MI 49068         |
+---------------------------------+---------------------------------------------------+
5 rows in set (0.04 sec)
```

2. List the hospitals in Michigan whose criteria comparisons are all above or the same as the national average.
```sql
select
   h.Hospital_Name 
from
   Hospitals h 
   join
      Rating_Records r1 
      on h.Hospital_Id = r1.Hospital_Id 
   join
      Ratings r2 
      on r1.Rating_Id = r2.Rating_Id 
   join
      City c1 
      on h.City = c1.CityId 
   join
      County c2 
      on c1.CountyId = c2.CountyId 
   join
      State s 
      on c2.StateId = s.StateId 
where
   s.StateName = 'MI' 
   and r2.Rating_Name in 
   (
      'Above the national average',
      'Same as the national average'
   )
group by
   h.Hospital_Id 
having
   count(1) = 
   (
      select
         count(*) as c 
      from
         Criteria_Info
   )
;

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
26 rows in set (0.03 sec)
```

3. List the hospitals in Michigan whose criteria comparisons are all above or the same as the national average.
```sql
select
   h.Overall_Rating,
   count(if(h.Hospital_Id in 
   (
      select distinct
         h.Hospital_Id 
      from
         Hospitals h 
         join
            Rating_Records r1 
            on h.Hospital_Id = r1.Hospital_Id 
         join
            Ratings r2 
            on r1.Rating_Id = r2.Rating_Id 
      where
         r2.Rating_Name in 
         (
            'Above the national average',
            'Same as the national average'
         )
      group by
         h.Hospital_Id 
      having
         count(1) = 
         (
            select
               count(1) 
            from
               Criteria_Info
         )
   )
, 1, NULL)) / count(1) as Likelihood 
from
   Hospitals h 
group by
   h.Overall_Rating 
order by
   h.Overall_Rating;
 
+----------------+------------+
| Overall_Rating | Likelihood |
+----------------+------------+
|           NULL |     0.0000 |
|              1 |     0.0000 |
|              2 |     0.0044 |
|              3 |     0.1147 |
|              4 |     0.3142 |
|              5 |     0.5244 |
+----------------+------------+
6 rows in set (0.06 sec)
```

4. Which state has most hospitals whose overall rating is higher than the average overall ratings?
```sql
select
   s.StateName 
from
   Hospitals h 
   join
      City c1 
      on h.City = c1.CityId 
   join
      County c2 
      on c1.CountyId = c2.CountyId 
   join
      State s 
      on c2.StateId = s.StateId 
where
   h.Overall_Rating > (
   select
      avg(Overall_Rating) 
   from
      Hospitals) 
   group by
      s.StateId 
   order by
      count(1) desc limit 1;
      
+-----------+
| StateName |
+-----------+
| TX        |
+-----------+
1 row in set (0.02 sec)
```

5. What’s the criteria that comprises most hospitals above national average rating?
```sql
select
   cr.Criteria_Name 
from
   Hospitals h 
   join
      Rating_Records r1 
      on h.Hospital_Id = r1.Hospital_Id 
   join
      Ratings r2 
      on r1.Rating_Id = r2.Rating_Id 
   join
      Criteria_Info cr 
      on r1.Criteria_Id = cr.Criteria_Id 
where
   r2.Rating_Name = 'Above the national average' 
group by
   r1.Criteria_Id 
order by
   count(1) desc limit 1;

+----------------------------------------+
| Criteria_Name                          |
+----------------------------------------+
| Patient experience national comparison |
+----------------------------------------+
1 row in set (0.04 sec)
```

6. Is it generally true that the overall ratings of hospitals who have both emergency service and efficient use of EHR is higher than those who don’t have?
```sql
select
(h.Emergency_Services = 1 
   and h.Efficient_EHR = 1) as Have_Both_Emergency_Services_and_Efficient_EHR,
   avg(h.Overall_Rating) as Average_Overall_Rating 
from
   Hospitals h 
group by
(h.Emergency_Services = 1 
   and h.Efficient_EHR = 1);
   
+------------------------------------------------+------------------------+
| Have_Both_Emergency_Services_and_Efficient_EHR | Average_Overall_Rating |
+------------------------------------------------+------------------------+
|                                              1 |                 3.0529 |
|                                              0 |                 3.2584 |
|                                           NULL |                 3.2778 |
+------------------------------------------------+------------------------+
3 rows in set (0.03 sec)
```

7. How many missing values of each criteria are there?
```sql
select
   cr.Criteria_Name,
   (
(
      select
         count(1) 
      from
         Hospitals) - count(1)
   )
   as Missing_Number 
from
   Hospitals h 
   join
      Rating_Records r1 
      on h.Hospital_Id = r1.Hospital_Id 
   join
      Ratings r2 
      on r1.Rating_Id = r2.Rating_Id 
   join
      Criteria_Info cr 
      on r1.Criteria_Id = cr.Criteria_Id 
group by
   r1.Criteria_Id;
   
+------------------------------------------------------+----------------+
| Criteria_Name                                        | Missing_Number |
+------------------------------------------------------+----------------+
| Effectiveness of care national comparison            |           1202 |
| Efficient use of medical imaging national comparison |           2033 |
| Mortality national comparison                        |           1352 |
| Patient experience national comparison               |           1369 |
| Readmission national comparison                      |           1017 |
| Safety of care national comparison                   |           2168 |
| Timeliness of care national comparison               |           1266 |
+------------------------------------------------------+----------------+
7 rows in set (0.15 sec)
```

8. Which type of ownership of hospitals has the highest overall rating?
```sql
select
   o.OwnershipType 
from
   Hospitals h 
   join
      Hospital_Ownership o 
      on h.Ownership = o.OwnershipId 
group by
   h.Ownership 
order by
   avg(h.Overall_Rating) desc limit 1;
   
+---------------+
| OwnershipType |
+---------------+
| Physician     |
+---------------+
```

9. How likely is a hospital which has above-national-average Patient experience also has above-national-average Effectiveness of care?
```sql
select
   count(if(r2.Rating_Name = 'Above the national average' 
   and cr.Criteria_Name = 'Effectiveness of care national comparison', 1, NULL)) / count(distinct(h.Hospital_Id)) as Likelihood 
from
   Hospitals h 
   join
      Rating_Records r1 
      on h.Hospital_Id = r1.Hospital_Id 
   join
      Ratings r2 
      on r1.Rating_Id = r2.Rating_Id 
   join
      Criteria_Info cr 
      on r1.Criteria_Id = cr.Criteria_Id 
where
   h.Hospital_Id in 
   (
      select distinct
         h.Hospital_Id 
      from
         Hospitals h 
         join
            Rating_Records r1 
            on h.Hospital_Id = r1.Hospital_Id 
         join
            Ratings r2 
            on r1.Rating_Id = r2.Rating_Id 
         join
            Criteria_Info cr 
            on r1.Criteria_Id = cr.Criteria_Id 
      where
         r2.Rating_Name = 'Above the national average' 
         and cr.Criteria_Name = 'Patient experience national comparison'
   )
;

+------------+
| Likelihood |
+------------+
|     0.0486 |
+------------+
1 row in set (0.05 sec)
```

10. Are hospitals with Emergency Services generally more likely to have Mortality national comparison ratings better than the national average?
```sql
select
   Emergency_Services,
   count(if(r2.Rating_Name = 'Above the national average' 
   and cr.Criteria_Name = 'Mortality national comparison', 1, NULL)) / count(distinct(h.Hospital_Id)) as 'Likelihood to have Mortality national comparison ratings better than the national average' 
from
   Hospitals h 
   left join
      Rating_Records r1 
      on h.Hospital_Id = r1.Hospital_Id 
   left join
      Ratings r2 
      on r1.Rating_Id = r2.Rating_Id 
   left join
      Criteria_Info cr 
      on r1.Criteria_Id = cr.Criteria_Id 
group by
   Emergency_Services;
 
+--------------------+-------------------------------------------------------------------------------------------+
| Emergency_Services | Likelihood to have Mortality national comparison ratings better than the national average |
+--------------------+-------------------------------------------------------------------------------------------+
|                  0 |                                                                                    0.0222 |
|                  1 |                                                                                    0.0874 |
+--------------------+-------------------------------------------------------------------------------------------+
2 rows in set (0.08 sec)
```

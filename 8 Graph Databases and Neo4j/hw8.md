# CSE 344 Homework 8: Graph Databases and Neo4j

**Objectives:**  To practice writing queries over the graph data model and practice using a NoSQL database system (Neo4j). To compare different data models.

**Assigned date:** Tuesday, March 10, 2020.

**Due date:** Monday, March 16, 2020. You have 1 week for this homework. NOTE THAT YOU CANNOT USE LATE DAYS. 

**What to turn in:**

A single file for each question, i.e., `q1.cypher`, `q2.cypher` etc in the `submission` directory.   It should contain commands executable by Neo4j, and any text answers should be comments in the file (start comment lines with `//` as in Java).

**Resources**

- [documentation for Cypher](https://neo4j.com/developer/cypher-query-language/). In particular, these pages are relevent:
  - [Guide from SQL to Cypher](https://neo4j.com/developer/guide-sql-to-cypher/)
  - [MATCH](https://neo4j.com/docs/cypher-manual/current/clauses/match/)
  - [OPTIONAL MATCH](https://neo4j.com/docs/cypher-manual/current/clauses/optional-match/)
  - [AGGREGATING](https://neo4j.com/docs/cypher-manual/current/functions/aggregating/)
  - [WITH](https://neo4j.com/docs/cypher-manual/current/clauses/with/)
  - ["HAVING" equivalent](https://neo4j.com/developer/kb/how-do-i-achieve-the-equivalent-of-a-sql-having-clause-with-cypher/)
  - [FUNCTIONS](https://neo4j.com/docs/cypher-manual/4.0/functions/)

## Assignment Details

In this homework, you will be writing Cypher queries over the graph data model implemented in [Neo4j](https://neo4j.com/). Neo4j is a company that provides a graph database implementation and has [open-sourced their Cypher language](https://www.opencypher.org/) to help it become a standard graph query language.

### Mondial Dataset

You will run queries over the [Mondial database](https://www.dbis.informatik.uni-goettingen.de/Mondial/), a geographical dataset aggregated from multiple sources, the same dataset used for the previous homework. Note that the as is common in real-world aggregated data, the Mondial dataset is "messy"; some data may differ from the previous homework, so similar queries might get different results. 

We have provided the dataset in Cypher CSV format, converted from the [RDF format](https://www.dbis.informatik.uni-goettingen.de/Mondial/Mondial-RDF/mondial.n3) available online, for use in Neo4j.

### Setting up Neo4j

The easiest way to try out Neo4j is to create a sandbox that they host for you. Note that sandboxes expire after a few days. They will send you an email to extend you sandbox so you can keep it running for the duration of the assignment. If your sandbox does expire, you can create a new one following the same steps. 

<details>
<summary>If you'd prefer to install and run Neo4j yourself, click here to view instructions.</summary>

>    If you'd like to run on your own computer:
>    
>    1. Download the latest version of neo4j from https://neo4j.com/download-center/#community.
>    
>    2. Follow the installation and start up instructions it provides for your OS.
>    
>    3. When your neo4j instance is running you can enter the query interface by visiting [http://localhost:7474/browser/](http://localhost:7474/browser/) in your favorite web browser. 
>    
>    4. To shutdown neo4j, run `bin/neo4j stop` in the terminal from your neo4j installation directory.
>    
>    If you'd like to run on attu or the home VM, note that they're running an old kernel, so you'll need to use an old version of neo4j.
>    
>    1. Download version 3.2.12 from [here](https://go.neo4j.com/download-thanks.html?edition=community&release=3.2.12&flavour=unix&_ga=2.115921603.433497260.1583038878-1480802045.1575089804).
>    
>    2. Install neo4j using the installation instructions at https://neo4j.com/docs/operations-manual/3.2/installation/linux/tarball/.
>    
>    3. On attu, make sure you specify a distinct port so that you don't accidentally use someone else's instance.
>       Add the line `org.neo4j.server.webserver.port=<your port number>` to the `conf/neo4j.properties` file before starting.
>    
>    4. To start neo4j, run `bin/neo4j start` in the terminal from your neo4j installation directory.
>    
>    5. When your neo4j instance is running you can enter the query interface by visiting [http://localhost:7474/browser/](http://localhost:7474/browser/) in your favorite web browser. 
>    
>    6. To shutdown neo4j, run `bin/neo4j stop` in the terminal from your neo4j installation directory.
>    
>    Then proceed to step 7 to import the data.
>
>    Also note: older versions of Cypher had different functions, so you'll have to replace `toInteger` with `toInt` and remove `datetime` calls while importing data. The documentation for this version of Cypher is [here](https://neo4j.com/docs/2.3.12/cypher-query-lang.html).

</details>
</p>

1. Visit https://sandbox.neo4j.com/ and click "Launch Sandbox". 

2. Create an account using any credentials you like.

3. On the "Select a project" modal, select "Blank Project" and then click "Launch Project".

4. Participate in the tutorial if you'd like, or click the x to close the tutorial.

5. Click "Open Neo4j Browser" on your blank sandbox.

6. Again, participate in the tutorial if you'd like, or click the x to close the tutorial.

7. Import the data.

   First we'll import the nodes:

  ```
  LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/mondial_for_neo4j.csv' AS row
  WITH toInteger(row.elevation) AS elevation, toInteger(row.population) AS population,  toFloat(row.latitude) AS latitude, toFloat(row.longitude) AS longitude, toFloat(row.length) AS length, toFloat(row.area) AS area, toFloat(row.depth) AS depth, toFloat(row.gdpAgri) AS gdpAgri, toFloat(row.gdpInd) AS gdpInd, toFloat(row.gdpServ)AS gdpServ, toFloat(row.gdpTotal) AS gdpTotal, datetime(row.democracyindependenceDate) AS democracyindependenceDate, toFloat(row.infantMortality) AS infantMortality, toFloat(row.inflation) AS  inflation, toFloat(row.populationGrowth) AS populationGrowth, toFloat(row.unemployment) AS unemployment, toFloat(row.percent) AS percent, row AS row
  FOREACH(bel IN CASE WHEN row._labels = ":BelievedBy:Resource" THEN [1] END |
  MERGE (n:BelievedBy:Resource {id: row._id})
    SET n.percent = percent, n.uri = row.uri)  
  FOREACH(border IN CASE WHEN row._labels = ":Border:Resource" THEN [1] END |
  MERGE (b:Border:Resource {id: row._id})
    SET b.length = length, b.uri = row.uri)
  FOREACH(n IN CASE WHEN row._labels = ":Country:Resource" THEN [1] END |
  MERGE (b:Country:Resource {id: row._id})
    SET b.area = area, b.carCode = row.carCode, b.gdpAgri = gdpAgri, b.gdpInd = gdpInd, b.gdpServ = gdpServ, b.gdpTotal = gdpTotal, b.government = row.government, b.democracyindependenceDate = democracyindependenceDate, b.infantMortality = infantMortality, b.inflation = inflation, b.localname = row.localname, b.name = row.name, b.population = population, b.populationGrowth = populationGrowth, b.unemployment = unemployment, b.uri = row.uri)
  FOREACH(n IN CASE WHEN row._labels = ":City:Resource" THEN [1] END |
  MERGE (b:City:Resource {id: row._id})
    SET b.elevation = elevation, b.latitude = latitude, b.longitude = longitude, b.name = row.name, b.population = population, b.uri = row.uri)
  FOREACH(bel IN CASE WHEN row._labels = ":EthnicProportion:Resource" THEN [1] END |
  MERGE (n:EthnicProportion:Resource {id: row._id})
    SET n.percent = percent, n.uri = row.uri)
  FOREACH(bel IN CASE WHEN row._labels = ":EthnicGroup:Resource" THEN [1] END |
  MERGE (n:EthnicGroup:Resource {id: row._id})
    SET n.name = row.name, n.uri = row.uri)  
  FOREACH(n IN CASE WHEN row._labels = ":Mountain:Resource" THEN [1] END |
  MERGE (b:Mountain:Resource {id: row._id})
    SET b.elevation = elevation, b.latitude = latitude, b.longitude = longitude, b.name = row.name, b.uri = row.uri)
  FOREACH(n IN CASE WHEN row._labels = ":Religion:Resource" THEN [1] END |
  MERGE (b:Resource:Religion {id: row._id})
    SET b.name = row.name, b.uri = row.uri)
  FOREACH(n IN CASE WHEN row._labels = ":Resource:Sea" THEN [1] END |
  MERGE (b:Resource:Sea {id: row._id})
    SET b.area = area, b.depth = depth, b.name = row.name, b.uri = row.uri)
    
   // Should create 6449 nodes and set 36240 properties
   ```
   
   Then run each of these separately to import the relationships:
   ```
   LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/neighbor-relations.csv' AS row
   WITH row WHERE row._type ='neighbor'
   MATCH (c1:Country {id:row._start})
   MATCH (c2:Country {id:row._end})
   CREATE (c1)-[:neighbor]->(c2)

   // should create 650 relationships
   ```

   ```
   LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/isborderof-relations.csv' AS row
   WITH row WHERE row._type ='isBorderOf'
   MATCH (n1:Border {id:row._start})
   MATCH (n2:Country {id:row._end})
   CREATE (n1)-[:isBorderOf]->(n2)

   // Should create 650 relationships
   ```

   ```
   LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/locatedin-relations.csv' AS row
   WITH row WHERE row._type ='locatedIn'
   MATCH (n1 {id:row._start})
   MATCH (n2:Country {id:row._end})
   WHERE n1:Sea OR n1:Mountain
   CREATE (n1)-[:locatedIn]->(n2)

   // Should create 792 relationships
   ```

   ```
   LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/hascity-relations.csv' AS row
   WITH row WHERE row._type ='hasCity'
   MATCH (n1:Country {id:row._start})
   MATCH (n2:City {id:row._end})
   CREATE (n1)-[:hasCity]->(n2)

   // Should create 3458 relationships
   ```

   ```
   LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/onreligion-relations.csv' AS row
   WITH row WHERE row._type ='onReligion'
   MATCH (n1:BelievedBy {id:row._start})
   MATCH (n2:Religion {id:row._end})
   CREATE (n1)-[:onReligion]->(n2)

  // Should create 663 relationships
  ```

  ```
  LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/religioninfo-relations.csv' AS row
   WITH row WHERE row._type ='religionInfo-'
   MATCH (n1:BelievedBy {id:row._start})
   MATCH (n2:Country {id:row._end})
   CREATE (n1)-[:`religionInfo-`]->(n2)

  // Should create 663 relationships
  ```

  ```
  LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/ethnicinfo-relations.csv' AS row
   WITH row WHERE row._type ='ethnicInfo-'
   MATCH (n1:EthnicProportion {id:row._start})
   MATCH (n2:Country {id:row._end})
   CREATE (n1)-[:`ethnicInfo-`]->(n2)

  // Should create 892 relationships
  ```

   ```
   LOAD CSV WITH HEADERS FROM 'https://courses.cs.washington.edu/courses/cse344/20wi/homework/onethnicgroup-relations.csv' AS row
   WITH row WHERE row._type ='onEthnicGroup'
   MATCH (n1:EthnicProportion {id:row._start})
   MATCH (n2:EthnicGroup {id:row._end})
   CREATE (n1)-[:onEthnicGroup]->(n2)

  // Should create 892 relationships
  ```

   Try this query to see if things are running correctly:
   ```
   MATCH (n:Country)
   RETURN n
   LIMIT 25
   ```

8. Explore and familiarize yourself! Hit the database icon to explore the data, enter ":play start" and do the "Jump into Code" tutorial. 

    For practice, run, examine, modify these queries. They contain useful templates for the questions on the homework: make sure you understand them.

    ```
    // return the set of countries
    MATCH (n:Country)
    RETURN n
    ```
    
    ```
    // return just their names, alphabetically
    MATCH (n:Country)
    RETURN n.name
    ORDER BY n.name;
    ```

    ```
    // find a specific node
    MATCH (s:Sea {name:"Pacific Ocean"})
    RETURN s
    ```

    ```
    // return count of how many countries have each form of government
    MATCH (n:Country)
    WITH n.government AS government, count(n) AS count
    RETURN government, count
    ORDER BY count DESC
    ```
    
    ```
    // this query to find edges has no results...
    MATCH (c:Country)-[i:isBorderOf]->(b:Border)
    RETURN i
    
    // ...because  the direction of the edges is inverted; fix it:
    MATCH (b:Border)-[i:isBorderOf]->(c:Country)
    RETURN i
    ```

    ```
    // compound identifiers need to be surrounded by backquotes:
    MATCH (:Country)<-[ei:`ethnicInfo-`]-(:EthnicProportion)
    RETURN ei
    ```

### Problems (100 points)

**For all questions asking to report free response-type questions, please leave your responses in comments**

*Here are some questions to familiarize you with unique features of the graph model.*

1. Retrieve the names of all countries that are neighbors of France, sorted alphabetically. Name your output attribute ``country``. [Result Size: 8 rows] 


2. Retrieve the names of all countries that are within three "hops" of France. For instance, Poland is next to Germany, which is next to Belgium, which is next to France, so Poland, Germany, and Belgium would all be within three hops. List the names alphabetically, and do not include duplicate names or "France". Name your output attribute ``country``. Free-response: How would you do this in SQL? [Result Size: 26 rows]


3. Retrieve the minimum number of hops between countries you would need to get from France to Finland. This is the length of the shortest path between them. In our example above, the path from France to Poland is length 3. Name your output attribute ``length``. [Result size: 1 row]


*Here are some questions that you answered with SQL++ in the previous homework. Note that joins no longer have to be done explicitly on country code, instead, joins are done implicitly by following edges.*


4. For each country return its name, its population, and the number of religions, sorted alphabetically by country. Report 0 religions for countries without religions. Name your output attributes ``country``, ``population``, ``num_religions``. [Result Size: 244 rows]


5. For each religion return the number of countries where it occurs; order them in decreasing number of countries. Name your output attributes ``religion``, ``num_countries``. [Result size: 50 rows]


6. For each ethnic group, return the number of countries where it occurs, as well as the total population world-wide of that group.  Hint: you need to multiply the ethnicity’s percentage with the country’s population. The values are already numeric, but make sure that your percentages make sense). Name your output attributes ``ethnic_group``, ``num_countries``, ``total_population``. You can leave your final `total_population` as a `float` if you like. [Result Size: 380 rows)]


7. Compute the list of all mountains, their heights, and the countries where they are located.  You should return a list consisting of the mountain name, its height, and country name, in descending order of the height, then ascending order of country name. Name your output attributes ``mountain``, ``height``,  ``country``. [Result Size: 439 rows]
    
      Hint: Some mountains can be located in more than one country. You need to output them for each country they are located in.


8. Find all countries bordering two or more seas. For each country in your list, return its name and the list of the names of the bordering seas, in decreasing order of the number of seas. Name your output attributes ``country``, ``seas``.  The attribute ``seas`` should be a list of strings. [Result Size: 81 rows of `"country":..., "seas": [...]`]


9. Return all landlocked countries.  A country is landlocked if it borders no sea. For each country in your list, return its name, in decreasing order of the country's area. Note: you'll need an additional clause, but this should be an easy query to derive from the previous one. Name your output attributes ``country``, ``area``. [Result Size: 46 rows]


10. Find all distinct pairs of countries that share both a mountain and a sea.  Your query should return a list of pairs of country names.  Avoid including a country with itself, like in (France, France), and avoid listing both (France, Korea) and (Korea, France) (not a real answer). Name your output attributes ``first_country``, ``second_country``. Add a comment comparing the runtime of this query to the runtime of question 9 in the previous homework and explaining the difference. [Result Size: 15 rows]


### Submission Instructions

Write your answers in a file for each question: `q1.cypher`, ... `q10.cypher` in the submission directory. Leave your short-answer responses in comments.

**Important**: To remind you, in order for your answers to be added to the git repo, 
you need to explicitly add each file:

```sh
$ git add q1.cypher ...
```

**Again, just because your code has been committed on your local machine does not mean that it has been 
submitted -- it needs to be on GitLab!**

and push to make sure your code is uploaded to GitLab:
```sh
$ git commit
$ git push
```

As with previous assignments, make sure you check the results afterwards to make sure that your files
have been committed.

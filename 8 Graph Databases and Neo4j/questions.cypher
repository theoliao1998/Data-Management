// q1
// Retrieve the names of all countries that are neighbors of France, sorted alphabetically. 
// Name your output attribute country. [Result Size: 8 rows]
MATCH (c:Country) - [i:neighbor] - (:Country {name:"France"}) 
RETURN c.name AS country 
ORDER BY c.name

// q2
// Retrieve the names of all countries that are within three "hops" of France. 
// For instance, Poland is next to Germany, which is next to Belgium, 
// which is next to France, so Poland, Germany, and Belgium would all be within three hops. 
// List the names alphabetically, and do not include duplicate names or "France". 
// Name your output attribute country. 
// Free-response: How would you do this in SQL? [Result Size: 26 rows]
MATCH (c:Country) - [:neighbor*1..3]-(:Country {name:"France"}) 
WHERE c.name<>"France"
RETURN DISTINCT c.name AS country ORDER BY c.name


// q3
// Retrieve the minimum number of hops between countries you would need to get from France to Finland. 
// This is the length of the shortest path between them. 
// In our example above, the path from France to Poland is length 3. 
// Name your output attribute length. [Result size: 1 row]
MATCH (c1:Country { name: 'France' }), 
(c2:Country { name: 'Finland' }), 
p = shortestPath((c1)-[*]-(c2))
RETURN LENGTH(p) AS length

// q4
// For each country return its name, its population, and the number of religions, sorted alphabetically by country. 
// Report 0 religions for countries without religions. 
// Name your output attributes country, population, num_religions. [Result Size: 244 rows]
MATCH (c:Country) OPTIONAL MATCH (c) <- [:`religionInfo-`] - (:BelievedBy) - [:onReligion] -> (r:Religion)
RETURN c.name AS country, c.population AS population, COUNT(DISTINCT r) AS num_religions
ORDER BY country

// q5
// For each religion return the number of countries where it occurs; 
// order them in decreasing number of countries. Name your output attributes religion, num_countries. [Result size: 50 rows]
MATCH (r:Religion) OPTIONAL MATCH (c:Country) <- [:`religionInfo-`] - (:BelievedBy) - [:onReligion] -> (r)
RETURN r.name AS religion, COUNT(DISTINCT c) AS num_countries
ORDER BY num_countries DESC

// q6
// For each ethnic group, return the number of countries where it occurs, as well as the total population world-wide of that group.
// Hint: you need to multiply the ethnicity’s percentage with the country’s population. 
// The values are already numeric, but make sure that your percentages make sense). 
// Name your output attributes ethnic_group, num_countries, total_population. 
// You can leave your final total_population as a float if you like. [Result Size: 380 rows)]
MATCH (eg:EthnicGroup) OPTIONAL MATCH (eg) <- [:onEthnicGroup] - (ep:EthnicProportion) - [:`ethnicInfo-`] -> (c:Country)
RETURN eg.name AS ethnic_group, COUNT(DISTINCT c) AS num_countries, SUM(ep.percent * c.population / 100) AS total_population

// q7
// Compute the list of all mountains, their heights, and the countries where they are located.  
// You should return a list consisting of the mountain name, its height, and country name, 
// in descending order of the height, then ascending order of country name.
// Name your output attributes mountain, height,  country. [Result Size: 439 rows]
// Hint: Some mountains can be located in more than one country. 
// You need to output them for each country they are located in.
MATCH (m:Mountain) OPTIONAL MATCH (m) - [:locatedIn] -> (c:Country)
RETURN m.name AS mountain, m.latitude AS height, c.name AS country
ORDER BY height DESC, mountain

// q8
// Find all countries bordering two or more seas. 
// For each country in your list, return its name and the list of the names of the bordering seas, 
// in decreasing order of the number of seas. Name your output attributes country, seas. 
// The attribute seas should be a list of strings. [Result Size: 81 rows of "country":..., "seas": [...]]
MATCH (c:Country) <- [:locatedIn] - (s:Sea)
WITH COUNT(s) AS cnt, c.name AS country, COLLECT(s.name) AS seas
WHERE cnt >= 2
RETURN country, seas
ORDER BY cnt DESC

// q9
// Return all landlocked countries.  
// A country is landlocked if it borders no sea. 
// For each country in your list, return its name, in decreasing order of the country's area. 
// Note: you'll need an additional clause, but this should be an easy query to derive from the previous one. 
// Name your output attributes country, area. [Result Size: 46 rows]
MATCH (c:Country)
WHERE NOT (c) <- [:locatedIn] - (:Sea)
RETURN c.name AS country, c.area AS area
ORDER BY area DESC

// q10
// Find all distinct pairs of countries that share both a mountain and a sea.  
// Your query should return a list of pairs of country names.  
// Avoid including a country with itself, like in (France, France), 
// and avoid listing both (France, Korea) and (Korea, France) (not a real answer).
// Name your output attributes first_country, second_country.
// Add a comment comparing the runtime of this query to the runtime of question 9 in the previous homework 
// and explaining the difference. [Result Size: 15 rows]
MATCH (c1:Country), (c2:Country)
WHERE (c1) <- [:locatedIn] - (:Sea) - [:locatedIn] -> (c2) 
AND (c1) <- [:locatedIn] - (:Mountain) - [:locatedIn] -> (c2) 
AND c1.name < c2.name
RETURN c1.name AS first_country, c2.name AS second_country
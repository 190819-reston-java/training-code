-- '--' makes comments in sql
-- use Ctrl+/, same as Eclipse

-- SELECT statements query the database -- they just read data, dont change it
SELECT * FROM films;

SELECT * FROM artists;

SELECT title FROM films;

-- use Ctrl + Space to autocomplete
-- use Ctrl + Enter to run queries
SELECT title, fulltext 
FROM films;

-- aliasing
SELECT title AS "Album Title" FROM albums;

SELECT * FROM tracks;

SELECT *
FROM tracks
WHERE milliseconds > 300000 AND composer IS NOT NULL;

-- all tracks that start with A:
SELECT "name" AS "Track", composer AS "Composer", milliseconds
FROM tracks
WHERE "name" < 'B' AND "name" > 'A' AND composer IS NOT NULL;

-- BETWEEN
SELECT * FROM employees
WHERE id BETWEEN 5 AND 30;

-- More in-depth SELECT:
-- Six main clauses: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY

SELECT * FROM customers;

-- Number of customer in each Country
SELECT country, COUNT(*)
FROM customers
GROUP BY country;

--COUNT is an aggregate function.  Other Aggregates:
-- SUM, MAX, AVG, MIN, ...

-- Last name lastest in the alphabet from each country
SELECT country, MAX(last_name)
FROM customers
GROUP BY country;

--next up is HAVING.
-- where WHERE conditions on individual rows
-- HAVING conditions on groups

SELECT country, COUNT(*) AS "Number of Customers"
FROM customers
WHERE state IS NOT NULL
GROUP BY country
HAVING COUNT(*) > 1;

--next up is ORDER BY
-- just orders the results
SELECT country, COUNT(*) AS "Number of Customers"
FROM customers
WHERE state IS NOT NULL
GROUP BY country
HAVING COUNT(*) > 1
ORDER BY COUNT(*);


SELECT state, COUNT(*)
FROM customers
WHERE state IS NOT NULL AND country = 'USA'
GROUP BY state
HAVING COUNT(*) < 2
ORDER BY state;

--The logical order: FROM, WHERE, GROUP BY, HAVING, ORDER BY, SELECT


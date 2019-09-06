-- exercises.  some require looking things up!

-- 1. list all customers (full names, customer ID, and country)
--    who are not in the US.
SELECT first_name, last_name, id, country
FROM customers
WHERE country != 'USA';

-- 2. list all customers from brazil.
SELECT first_name, last_name, id, country
FROM customers
WHERE country = 'Brazil';

-- 3. list all sales agents.
SELECT first_name, last_name, title
FROM employees
WHERE title = 'Sales Support Agent';

-- 4. show a list of all countries in billing addresses on invoices.
--    (there should not be duplicates in the list, figure out how to do that)
SELECT DISTINCT billing_country
FROM invoices;

-- 5. how many invoices were there in 2009, and what was the
--    sales total for that year? what about 2011 (can use a separate query)?
SELECT CAST(EXTRACT(YEAR FROM invoice_date) AS TEXT) AS "Year", COUNT(*) AS "Number of Invoices", SUM(total) AS "Sales Total"
FROM invoices
GROUP BY EXTRACT(YEAR FROM invoice_date)
ORDER BY EXTRACT(YEAR FROM invoice_date);

SELECT SUBSTRING(CAST(invoice_date AS TEXT), 1, 4) AS "Year", COUNT(*) AS "Invoices", SUM(total) AS "Sales"
FROM invoices
GROUP BY SUBSTRING(CAST(invoice_date AS TEXT), 1, 4)
ORDER BY SUBSTRING(CAST(invoice_date AS TEXT), 1, 4);

-- 6. how many line items were there for invoice #37?
SELECT invoice_id, COUNT(*)
FROM invoice_lines
GROUP BY invoice_id
ORDER BY invoice_id;

-- 7. how many invoices per country?
SELECT billing_country AS "Country", COUNT(*) AS "Number of Invoices"
FROM invoices
GROUP BY billing_country;

-- 8. show total sales per country,
--    ordered by highest sales first (figure out how to do that)
SELECT billing_country AS "Country", SUM(total) AS "Total Sales"
FROM invoices
GROUP BY billing_country
ORDER BY SUM(total) DESC;


-- exercises.  some require looking things up!
-- 1. list all customers (full names, customer ID, and country)
--    who are not in the US.
SELECT first_name, last_name, id, country
FROM customers
WHERE country != 'USA';

-- 2. list all customers from brazil.
SELECT *
FROM customers
WHERE country = 'Brazil';

-- 3. list all sales agents.
SELECT *
FROM employees
WHERE title LIKE '%Sales%';

-- 4. show a list of all countries in billing addresses on invoices.
--    (there should not be duplicates in the list, figure out how to do that)
SELECT DISTINCT billing_country
FROM invoices
ORDER BY billing_country;

-- 5. how many invoices were there in 2009, and what was the
--    sales total for that year? what about 2011 (can use a separate query)?
SELECT COUNT(*), SUM(total)
FROM invoices
WHERE CAST(invoice_date AS TEXT) LIKE '2009%';

SELECT COUNT(*), SUM(total)
FROM invoices
WHERE invoice_date > '2008-12-31' AND invoice_date < '2010-01-01';

SELECT COUNT(*), SUM(total)
FROM invoices
WHERE invoice_date BETWEEN '2009-01-01' AND '2010-01-01';

SELECT COUNT(*), SUM(total)
FROM invoices
WHERE EXTRACT(YEAR FROM invoice_date) >= 2009 AND EXTRACT(YEAR FROM invoice_date) < 2010;

SELECT invoice_date
FROM invoices;

-- 6. how many line items were there for invoice #37?
SELECT id,quantity
FROM invoice_lines
WHERE invoice_id = 37;

SELECT invoice_id, COUNT(*) AS "Lines"
FROM invoice_lines
GROUP BY invoice_id
ORDER BY invoice_id;

-- 7. how many invoices per country?
SELECT billing_country, COUNT(*)
FROM invoices
GROUP BY billing_country
ORDER BY billing_country;

-- 8. show total sales per country,
--    ordered by highest sales first (figure out how to do that)
SELECT billing_country, SUM(total)
FROM invoices
GROUP BY billing_country
ORDER BY SUM(total) DESC;




-- exercises:

-- 1. insert two new records into the employee table.
INSERT INTO employees (last_name, first_name) VALUES
	('King', 'Adam'),
	('Goldblum', 'Jeff');

SELECT * FROM employees ORDER BY id DESC;

-- 2. insert two new records into the tracks table.
INSERT INTO tracks (name, media_type_id, milliseconds, unit_price) VALUES
	('Rad song '''' 1', 5, 300000, 40),
	('Rad song 2', 5, 300000, 45);

SELECT * FROM tracks ORDER BY id DESC;

-- 3. update customer Aaron Mitchell's name to Robert Walter
UPDATE customers SET
	first_name = 'Robert',
	last_name = 'Walter'
WHERE first_name = 'Aaron' AND last_name = 'Mitchell';

SELECT * FROM customers;

-- 4. delete one of the employees you inserted.
DELETE FROM employees WHERE first_name = 'Adam' AND last_name = 'King';

-- 5. delete customer Robert Walter. you'll also need to remove all
--    other rows in other tables that ultimately depend on his existence
--    via foreign key relationships to get past the error.

DELETE FROM customers WHERE first_name = 'Robert' AND last_name = 'Walter';

DELETE FROM invoices
WHERE customer_id IN (
	SELECT id FROM customers
	WHERE first_name = 'Robert' AND last_name = 'Walter');
	
DELETE FROM invoice_lines
WHERE invoice_id IN (
	SELECT id FROM invoices
	WHERE customer_id IN (
		SELECT id FROM customers
		WHERE first_name = 'Robert' AND last_name = 'Walter'
	)
);

-- exercises:

-- 1. insert two new records into the employee table.

SELECT * FROM employees ORDER BY id DESC;

INSERT INTO employees (last_name, first_name) VALUES
	('Jordan', 'Micheal'),
	('Jobs', 'Steve');

-- 2. insert two new records into the tracks table.

SELECT * FROM tracks ORDER BY id DESC;

INSERT INTO tracks (name, media_type_id, milliseconds, unit_price) VALUES
	('Rad song 1', 4, 300000, 0.98),
	('Rad song 3', 4, 340000, 20.0);

-- 3. update customer Aaron Mitchell's name to Robert Walter

SELECT * FROM customers ORDER BY id;

UPDATE customers SET
	first_name = 'Robert',
	last_name = 'Walter'
WHERE first_name = 'Aaron' AND last_name = 'Mitchell';

-- 4. delete one of the employees you inserted.

SELECT * FROM employees ORDER BY id DESC;

DELETE FROM employees WHERE id = 10;

-- 5. delete customer Robert Walter. you'll also need to remove all
--    other rows in other tables that ultimately depend on his existence
--    via foreign key relationships to get past the error.

SELECT * FROM customers ORDER BY id;

DELETE FROM customers WHERE first_name = 'Robert' AND last_name = 'Walter';

DELETE FROM invoices
WHERE customer_id IN (
	SELECT id FROM customers
	WHERE first_name = 'Robert' AND last_name = 'Walter'
);

DELETE FROM invoice_lines
--SELECT * FROM invoice_lines
WHERE invoice_id IN (
	SELECT id FROM invoices
	WHERE customer_id IN (
		SELECT id FROM customers
		WHERE first_name = 'Robert' AND last_name = 'Walter'
	)
);

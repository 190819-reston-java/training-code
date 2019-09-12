-- We need the chinook database for this file.
--SELECT * FROM customers;

-- use CREATE OR REPLACE if you're going to be rewriting
CREATE OR REPLACE FUNCTION get_current_time() RETURNS TIME WITH TIME ZONE
AS
$$
	SELECT current_time;
	-- NO RETURN statement because functions implicitly return last statement
$$ LANGUAGE SQL;-- Declare function language after function

SELECT get_current_time();
--SELECT CAST(get_current_time() AS TIME);

CREATE OR REPLACE FUNCTION string_literal_tests() RETURNS VARCHAR(40)
AS
$func$
	SELECT 'Hello';
$func$ LANGUAGE SQL;

SELECT string_literal_tests();

SELECT SUBSTRING(first_name,1,1) AS "First Initial", SUBSTRING(last_name,1,1) AS "Last Initial" 
FROM customers;

-- take in INTEGER id -- note SERIAL is interchangeable with INTEGER
CREATE OR REPLACE FUNCTION get_customer_initials(customer_id INTEGER) RETURNS VARCHAR(2)
AS
$$
	-- String concat in postgres with ||
	SELECT SUBSTRING(first_name,1,1) || SUBSTRING(last_name,1,1)
	FROM customers
	WHERE id = customer_id;
$$ LANGUAGE SQL;

SELECT get_customer_initials(2);

SELECT get_customer_initials(id)
FROM customers;

-- We can write functions that returns SETs -- as in, resultsets
CREATE OR REPLACE FUNCTION employees_before_1970() RETURNS SETOF employees
AS
$$
	SELECT * FROM employees
	WHERE EXTRACT(YEAR FROM birth_date) < 1970;
$$ LANGUAGE SQL;

SELECT * FROM employees_before_1970();

SELECT get_customer_initials(id) FROM employees_before_1970();

-- ^ taking resultset from an existing table
-- THis one creates a new table to return
CREATE OR REPLACE FUNCTION employee_names() RETURNS TABLE(
	first_name VARCHAR(30),
	last_name VARCHAR(30)
	) AS
$$
	SELECT first_name, last_name FROM employees;
$$ LANGUAGE SQL;

SELECT employee_names(); -- just the record

SELECT * FROM employee_names(); --select all columns from each record







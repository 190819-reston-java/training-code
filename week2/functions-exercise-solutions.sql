-- exercises
-- 1. create a function that returns the length of a track
CREATE OR REPLACE FUNCTION get_track_length(track_id INTEGER) RETURNS INTEGER
AS
$$
	SELECT milliseconds FROM tracks WHERE id = track_id;
$$ LANGUAGE SQL;

SELECT get_track_length(id), milliseconds FROM tracks;

-- 2. create a function that returns the average total of all
--    invoices
CREATE OR REPLACE FUNCTION average_total_of_invoices() RETURNS NUMERIC(4,2)
AS 
$$
	SELECT AVG(total) FROM invoices;
$$ LANGUAGE SQL;

SELECT average_total_of_invoices();

-- 3. create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_track() RETURNS SETOF tracks
AS
$$
	SELECT * FROM tracks WHERE unit_price = (SELECT MAX(unit_price) FROM tracks) LIMIT 1;
$$ LANGUAGE SQL;

SELECT * FROM most_expensive_track();

-- 4. create a function that returns the average price of all invoice line
--    items
CREATE OR REPLACE FUNCTION average_price_of_invoice_lines() RETURNS NUMERIC(4,2)
AS
$$
	SELECT AVG(unit_price) FROM invoice_lines;
$$ LANGUAGE SQL;

SELECT average_price_of_invoice_lines();

-- 6. create a function that, given an employee, returns all the employees he
--    manages (that report to him).
CREATE OR REPLACE FUNCTION employees_managed_by(manager_id INTEGER) RETURNS SETOF employees
AS
$$
	SELECT * FROM employees WHERE reports_to = manager_id;
$$ LANGUAGE SQL;

SELECT * FROM employees_managed_by(1);

-- 7. create a function that, given an invoice id, will delete that
--    invoice, including all associated invoice line items.
CREATE OR REPLACE FUNCTION delete_invoice(delete_id INTEGER) RETURNS VOID
AS
$$
	DELETE FROM invoice_lines WHERE invoice_id = delete_id;
	DELETE FROM invoices WHERE id = delete_id;
$$ LANGUAGE SQL;

SELECT * FROM invoices;

SELECT delete_invoice(1);



-- exercises
-- 1. create a function that returns the length of a track
CREATE OR REPLACE FUNCTION get_track_length(track_id INTEGER) RETURNS INTEGER
AS
$$
	SELECT milliseconds FROM tracks WHERE id = track_id;
$$ LANGUAGE SQL;

SELECT get_track_length(id), milliseconds FROM tracks;

-- 2. create a function that returns the average total of all
--    invoices
DROP FUNCTION average_total_of_invoices();
--return type mystery here:
CREATE OR REPLACE FUNCTION average_total_of_invoices() RETURNS NUMERIC(4,2)
AS
$$
	SELECT AVG(total) FROM invoices;
$$ LANGUAGE SQL;

SELECT average_total_of_invoices();

-- 3. create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_track() RETURNS SETOF tracks
AS
$$
	SELECT * FROM tracks 
	ORDER BY unit_price DESC, milliseconds DESC, bytes DESC
	LIMIT 1;
$$ LANGUAGE SQL;

SELECT * FROM most_expensive_track();

-- 4. create a function that returns the average price of all invoice line
--    items
CREATE OR REPLACE FUNCTION average_price_of_invoice_lines() RETURNS NUMERIC(4,2)
AS
$$
	SELECT AVG(unit_price) FROM invoice_lines;
$$ LANGUAGE SQL;

SELECT average_price_of_invoice_lines();

-- 6. create a function that, given an employee, returns all the employees he
--    manages (that report to him).
DROP FUNCTION employees_reporting_to(INTEGER);
CREATE OR REPLACE FUNCTION employees_reporting_to(manager_id INTEGER) RETURNS SETOF employees
AS 
$$
	SELECT * FROM employees
	WHERE reports_to = manager_id;
$$ LANGUAGE SQL;

SELECT * FROM employees_reporting_to(1);

-- 7. create a function that, given an invoice id, will delete that
--    invoice, including all associated invoice line items.
CREATE OR REPLACE FUNCTION delete_invoice(delete_id INTEGER) RETURNS VOID
AS
$$
	DELETE FROM invoice_lines WHERE invoice_id = delete_id;
	DELETE FROM invoices WHERE id = delete_id;
$$ LANGUAGE SQL;

-- Quick transaction demo (bonus!) :
BEGIN;
SELECT * FROM invoices;

SELECT delete_invoice(3);

SELECT * FROM invoices;
ROLLBACK;
SELECT * FROM invoices;
COMMIT;

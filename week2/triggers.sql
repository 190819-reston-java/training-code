-- triggers do something (a function) in response to UPDATEs, DELETEs, INSERTs on the DB
-- We can set them up to happen BEFORE, AFTER, or INSTEAD OF 
-- 	(though INSTEAD OF is limited to views)

--everything we do in a tirgger must be represented by a function
CREATE OR REPLACE FUNCTION skip_delete_invoice_too_expensive() RETURNS TRIGGER
AS
$$
	BEGIN
		-- RAISE is how we throw exception-like things in SQL
		RAISE 'deleting expensive invoices is prohibited';
	END;
$$ LANGUAGE plpgsql; -- programmatic SQL

CREATE TRIGGER prevent_expensive_invoice_deletion
BEFORE DELETE
ON invoices
FOR EACH ROW -- This operates by record instead of by statement. Alt: FOR EACH STATEMENT
-- WHen using triggers with rows, we have 2 special "tables": OLD and NEW
-- they represent the OLD version of the row and the NEW version.  Note DELETE has no NEW
-- and INSERT has no OLD.
WHEN (OLD.total > 20) -- total is more than 20$
EXECUTE PROCEDURE skip_delete_invoice_too_expensive();

SELECT * FROM invoices;

-- This throws our error:
DELETE FROM invoices WHERE id = 96;

DROP TABLE players;
CREATE TABLE players (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL UNIQUE,
	num INTEGER NULL,
	position VARCHAR(2) CHECK(position IN ('C','P','1B','2B','3B','SS','LF','RF','CF','WB')),
	batting_average NUMERIC(4,3),
	last_updated TIMESTAMP WITH TIME ZONE DEFAULT(CURRENT_TIMESTAMP)
);

--DELETE FROM players;
INSERT INTO players VALUES
	(DEFAULT, 'Test name 1', 99, '1B', 0.333, DEFAULT),
	(DEFAULT, 'Test name 2', 99, 'C', 0.333, DEFAULT),
	(DEFAULT, 'Test name 3', 99, '3B', 0.333, DEFAULT);

SELECT * FROM players;

CREATE OR REPLACE FUNCTION players_last_updated() RETURNS TRIGGER
AS
$$
BEGIN
	NEW.last_updated = CURRENT_TIMESTAMP;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_players_last_updated
BEFORE UPDATE
ON players
FOR EACH ROW
EXECUTE PROCEDURE players_last_updated();

UPDATE players SET num = 98 WHERE id = 3;

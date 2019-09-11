--CREATE DATABASE players;
--DROP DATABASE players;

--DROP TABLE players;
CREATE TABLE players (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL UNIQUE,
	num INTEGER NULL,
	position VARCHAR(2) CHECK(position IN ('C','P','1B','2B','3B','SS','LF','RF','CF','WB')),
	batting_average NUMERIC(4,3)
);

--DELETE FROM players;
INSERT INTO players VALUES
	(DEFAULT, 'Test name 1', 99, '1B', 0.333),
	(DEFAULT, 'Test name 2', 99, 'C', 0.333),
	(DEFAULT, 'Test name 3', 99, '3B', 0.333);

SELECT * FROM players;

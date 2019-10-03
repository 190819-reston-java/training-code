CREATE TABLE actors (
	id SERIAL PRIMARY KEY,
	name VARCHAR(300),
	stage_name VARCHAR(300),
	height NUMERIC(8,2)
);

INSERT INTO actors VALUES
	(DEFAULT, 'Jeff Goldblum', NULL, 6),
	(DEFAULT, 'Pierce Brosnan', 'Bond', 6.2);
	
SELECT * FROM actors;

DROP TABLE actors;

CREATE TABLE directors (
	id SERIAL PRIMARY KEY,
	name VARCHAR(300)
);

CREATE TABLE movies (
	id SERIAL PRIMARY KEY,
	title VARCHAR(300),
	genre VARCHAR(30),
	director_id INTEGER,
	FOREIGN KEY (director_id) REFERENCES directors(id)
);

SELECT * FROM directors;
SELECT * FROM movies;

INSERT INTO directors VALUES 
	(DEFAULT, 'Victor Fleming'),
	(DEFAULT, 'Yasujiro Ozu');
	
INSERT INTO movies VALUES
	(DEFAULT, 'Gone With the Wind', 'Action', 2),
	(DEFAULT, 'The Wizard of Oz', 'Action', 2),
	(DEFAULT, 'Tokyo Story', 'Action', 3),
	(DEFAULT, 'Late Spring', 'Action', 3);
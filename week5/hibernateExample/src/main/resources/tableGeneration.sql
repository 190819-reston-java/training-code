DROP TABLE actors;
DROP TABLE movies;
DROP TABLE directors;

CREATE TABLE actors (
	id SERIAL PRIMARY KEY,
	name VARCHAR(300),
	stage_name VARCHAR(300),
	height NUMERIC(8,2)
);

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

CREATE TABLE movie_actor (
	movie_id INTEGER NOT NULL,
	actor_id INTEGER NOT NULL,
	FOREIGN KEY (movie_id) REFERENCES movies(id),
	FOREIGN KEY (actor_id) REFERENCES actors(id)
);

INSERT INTO actors VALUES
	(DEFAULT, 'Jeff Goldblum', NULL, 6),
	(DEFAULT, 'Pierce Brosnan', 'Bond', 6.2),
	(DEFAULT, 'Clark Gable', NULL, 5),
	(DEFAULT, 'Vivien Leigh', NULL, 5),
	(DEFAULT, 'Judy Garland', NULL, 4);

INSERT INTO directors VALUES 
	(DEFAULT, 'Victor Fleming'),
	(DEFAULT, 'Yasujiro Ozu');
	
INSERT INTO movies VALUES
	(DEFAULT, 'Gone With the Wind', 'Action', 1),
	(DEFAULT, 'The Wizard of Oz', 'Action', 1),
	(DEFAULT, 'Tokyo Story', 'Action', 2),
	(DEFAULT, 'Late Spring', 'Action', 2);
	
INSERT INTO movie_actor VALUES
	(1, 3),
	(1, 4),
	(2, 5);
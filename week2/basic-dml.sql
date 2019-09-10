-- DML : Data Manipulation Language
-- INSERT, UPDATE, DELETE (sometimes SELECT)

SELECT * FROM genres;

-- add rows with INSERT
INSERT INTO genres (name) VALUES ('Misc 1');
-- specify which values : don't specify id
INSERT INTO genres (id, name) VALUES (27, 'Misc 2');

-- save time:
INSERT INTO genres (name) VALUES 
	('Misc 3'),
	('Misc 4');
	
-- DELETE to delete rows
-- This line will delete all rows:
-- DELETE FROM genres;

-- instead, DELETE with WHERE:
DELETE FROM genres
WHERE id >= 28;

-- UPDATE to change records

-- set name Misc 4 to Miscellaneous 1 and id to 28
UPDATE genres SET
	name = 'Miscellaneous 1',
	id = 28
	-- more key = value pairs can go here, comma-separated
	WHERE name = 'Misc 4';



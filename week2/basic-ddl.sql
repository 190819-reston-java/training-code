-- DDL : Data Definition Language
-- language used to work with tables and other, largers things (schemas, databases).
-- not aware of individual rows.  DBs hold schemas, which hold tables.

CREATE DATABASE mydb;
DROP DATABASE mydb; -- DROP keyword deletes, but only when closed.

CREATE SCHEMA myschema; -- a grouping/namespace for tables
DROP SCHEMA myschema;

-- 3 DDL keywords: CREATE, DROP, ALTER

CREATE SCHEMA restaurant_reviews;

-- we can specify schema.table, or we can change default search path:

-- look for tables in restaurant_reviews first, then public:
SET search_path TO restaurant_reviews, public;

CREATE TABLE restaurant_reviews.reviews (
	-- We specify columns with name and datatype:
	-- name: id, type: SERIAL, constraints: NOT NULL
	id SERIAL NOT NULL UNIQUE,
	-- SERIAL is datatype used for ids, makes a unique identifier for each row
	reviewer CHARACTER VARYING(100), -- can abbreviate to VARCHAR
	-- VARCHAR is text with a limit on size, in this case 100 characters.
	score NUMERIC(4, 2) NOT NULL, -- 4 digits total, 2 after the decimal: XX.XX
	_content TEXT NULL, --variable length text, NULL means NULLable
	-- TIMESTAMP WITH TIME ZONE is a datatype
	last_updated TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT(current_timestamp),
	-- This WILL BE a foreign key, but we haven't created the foreign key part yet
	restaurant_id INTEGER NOT NULL,
	-- In addition to columns, we can specify constraints
	-- PRIMARY KEY type constraint operates on column id
	CONSTRAINT pk_reviews_id PRIMARY KEY (id),
	CONSTRAINT chk_review_score_min_0 CHECK (score >= 0),
	-- Each reviewer can only review each restaurant once:
	CONSTRAINT u_reviewer_restaurant_id UNIQUE (restaurant_id, reviewer)
);

--DROP TABLE restaurant_reviews.reviews;

CREATE TABLE restaurant_reviews.restaurants (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	cuisine VARCHAR(100) NULL,
	address_line_1 VARCHAR(100) NOT NULL,
	address_line_2 VARCHAR(100) NULL,
	city VARCHAR(100) NOT NULL,
	state VARCHAR(100) NOT NULL,
	country VARCHAR(100) NOT NULL,
	zipcode VARCHAR(10) NULL,
	opening_time TIME WITHOUT TIME ZONE NULL DEFAULT('9:00 AM'),
	closing_time TIME WITHOUT TIME ZONE NULL DEFAULT('10:00 PM')
);

-- ALTER changes tables -- use it to add columns or constraints
-- IF you add columns they must have default or be NULLable
ALTER TABLE restaurant_reviews.reviews
	ADD CONSTRAINT fk_reviews_restaurants_Nto1
	FOREIGN KEY (restaurant_id) REFERENCES restaurant_reviews.restaurants (id);
	
-- This FOREIGN KEY just ensures all our restaurant_id values actually
-- point to a restaurant
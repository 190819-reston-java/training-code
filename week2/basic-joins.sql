
-- JOINs allow us to combine tables in a resultset
-- two (or more) joined tables have records that include
-- columns from ALL joined tables.
 SELECT
	*
FROM
	tracks
INNER JOIN genres ON
	tracks.genre_id = genres.id;

SELECT
	tracks.name AS "Track",
	tracks.genre_id,
	genres.id,
	genres.name AS "Genre"
FROM
	tracks
INNER JOIN genres ON
	tracks.genre_id = genres.id
WHERE
	genres.name = 'Metal';

SELECT
	tracks.name AS "Song",
	albums.title AS "Album",
	artists.name AS "Artist"
FROM
	tracks
INNER JOIN albums ON
	tracks.album_id = albums.id
INNER JOIN artists ON
	albums.artist_id = artists.id;

SELECT
	tracks.name AS "Song",
	albums.title AS "Album",
	artists.name AS "Artist"
FROM
	tracks
INNER JOIN albums ON
	tracks.album_id = albums.id
INNER JOIN artists ON
	albums.artist_id = artists.id;

-- INNER JOIN only includes a record if it matches another record
-- (if the ON condition is satisfied).
-- LEFT, RIGHT, and OUTER/FULL JOINs work similarly, but if the condition
-- is false for a record in every case, that record might be included:
-- LEFT includes all from left table, RIGHT from right, and OUTER from both

-- count of albums + tracks
SELECT COUNT(*)
FROM tracks
	FULL JOIN albums ON false;

-- count of tracks
SELECT COUNT(*)
FROM tracks
	LEFT JOIN albums ON false;
	
-- count of albums
SELECT COUNT(*)
FROM tracks
	RIGHT JOIN albums ON false;

SELECT
	*
FROM
	tracks
FULL JOIN genres ON
	tracks.genre_id = genres.id
WHERE tracks.genre_id IS NULL;
	

package com.revature.models;

import java.time.LocalDate;
import java.util.Set;

public interface IMovie {

	int getId();

	void setId(int id);

	String getTitle();

	void setTitle(String title);

	MovieGenre getGenre();

	void setGenre(MovieGenre genre);

	Set<IActor> getActors();

	void setActors(Set<IActor> actors);

	int getLength();

	void setLength(int length);

	IDirector getDirector();

	void setDirector(IDirector director);

	MPAA getRating();

	void setRating(MPAA rating);

	String getDescription();

	void setDescription(String description);

	LocalDate getReleaseDate();

	void setReleaseDate(LocalDate releaseDate);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}
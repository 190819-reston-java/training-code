package com.revature.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Movie implements Serializable, IMovie {

	private static final long serialVersionUID = 3030097922006848590L;
	
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private MovieGenre genre;
	
	@Column
	@JoinTable(name = "actor_movie", 
			   joinColumns = { @JoinColumn(name = "movie_id") },
			   inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<IActor> actors  = new HashSet<>();
	
	@Column
	private int length; // In minutes
	
	@Column
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private IDirector director;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private MPAA rating;
	
	@Column
	@Length(max = 400)
	private String description;
	
	@Column
	private LocalDate releaseDate;
	
	public Movie() {
		super();
	}

	public Movie(int id, String title, MovieGenre genre, Set<IActor> actors, int length, IDirector director,
			MPAA rating, String description, LocalDate releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.actors = actors;
		this.length = length;
		this.director = director;
		this.rating = rating;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public MovieGenre getGenre() {
		return genre;
	}

	@Override
	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	@Override
	public Set<IActor> getActors() {
		return actors;
	}

	@Override
	public void setActors(Set<IActor> actors) {
		this.actors = actors;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public IDirector getDirector() {
		return director;
	}

	@Override
	public void setDirector(IDirector director) {
		this.director = director;
	}

	@Override
	public MPAA getRating() {
		return rating;
	}

	@Override
	public void setRating(MPAA rating) {
		this.rating = rating;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	@Override
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, director, genre, id, length, rating, releaseDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Movie)) {
			return false;
		}
		Movie other = (Movie) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(director, other.director) && genre == other.genre && id == other.id
				&& length == other.length && rating == other.rating && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genres=" + genre + ", actors=" + actors + ", length="
				+ length + ", director=" + director + ", rating=" + rating + ", description=" + description
				+ ", releaseDate=" + releaseDate + "]";
	}
}

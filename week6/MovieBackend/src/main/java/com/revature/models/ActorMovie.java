package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "actor_movie")
public class ActorMovie {
	
	@Id
	@Column(name = "actor_movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private IActor actor;
	
	@Column
	private IMovie movie;

	public ActorMovie() {
		super();
	}

	public ActorMovie(int id, IActor actor, IMovie movie) {
		super();
		this.id = id;
		this.actor = actor;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IActor getActor() {
		return actor;
	}

	public void setActor(IActor actor) {
		this.actor = actor;
	}

	public IMovie getMovie() {
		return movie;
	}

	public void setMovie(IMovie movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actor, id, movie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ActorMovie)) {
			return false;
		}
		ActorMovie other = (ActorMovie) obj;
		return Objects.equals(actor, other.actor) && id == other.id && Objects.equals(movie, other.movie);
	}

	@Override
	public String toString() {
		return "ActorMovie [id=" + id + ", actor=" + actor + ", movie=" + movie + "]";
	}
}

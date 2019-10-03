package com.revature;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This class is our first Hibernate example.  We'll use the JPA annotations
 * to specify how this class will be mapped to a relation in an RDBMS
 * @author Revature
 */
@Entity
@Table(name="actors")
public class Actor {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="id" )
	private long id;
	
	@Column( name="name" )
	private String name;
	
	@Column( name="stage_name" )
	private String stageName;
	
	@Column( name="height" )
	private double height;
	
	@ManyToMany( mappedBy = "actors", fetch = FetchType.LAZY )
	private Set<Movie> movies = new HashSet<Movie>();
	
	public Actor() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", stageName=" + stageName + ", height=" + height + "]";
	}

}

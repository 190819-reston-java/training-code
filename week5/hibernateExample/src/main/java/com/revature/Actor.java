package com.revature;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="stage_name")
	private String stageName;
	
	@Column(name="height")
	private double height;
	
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

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", stageName=" + stageName + ", height=" + height + "]";
	}

}

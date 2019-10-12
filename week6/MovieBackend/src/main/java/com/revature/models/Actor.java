package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Actor implements Serializable, IActor {

	private static final long serialVersionUID = 2189768803635051012L;

	@Id
	@Column(name = "actor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String IMDBlink;
	
	public Actor() {
		super();
	}

	public Actor(int id, String firstname, String lastname, String iMDBlink) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		IMDBlink = iMDBlink;
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
	public String getFirstname() {
		return firstname;
	}

	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String getIMDBlink() {
		return IMDBlink;
	}

	@Override
	public void setIMDBlink(String iMDBlink) {
		IMDBlink = iMDBlink;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IMDBlink, firstname, id, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Actor)) {
			return false;
		}
		Actor other = (Actor) obj;
		return Objects.equals(IMDBlink, other.IMDBlink) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname);
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", IMDBlink=" + IMDBlink
				+ "]";
	}
}

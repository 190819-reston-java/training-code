package com.revature.models;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {

	private static final long serialVersionUID = -7020619477594468968L;
	
	private String firstname = "John";
	private String lastname;
	
	@Autowired
	private List<Account> accounts;
	
	private String email;

	public User() {
		super();
	}
	
	public User(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public User(String firstname, String lastname, List<Account> accounts, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.accounts = accounts;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, email, firstname, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname);
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", accounts=" + accounts + ", email=" + email
				+ "]";
	}
}

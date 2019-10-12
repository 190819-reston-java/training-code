package com.revature.models;

public interface IActor {

	int getId();

	void setId(int id);

	String getFirstname();

	void setFirstname(String firstname);

	String getLastname();

	void setLastname(String lastname);

	String getIMDBlink();

	void setIMDBlink(String iMDBlink);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}
package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Account;
import com.revature.models.User;

@Repository
public class UserRepository {
	
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Steve", "Jobs", new ArrayList<Account>(), "test@example.com"));
		users.add(new User("John", "Smith", new ArrayList<Account>(), "test@example.com"));
		
		return users;
	}

	@Override
	public String toString() {
		return "UserRepository [findAll()=" + findAll() + "]";
	}
}

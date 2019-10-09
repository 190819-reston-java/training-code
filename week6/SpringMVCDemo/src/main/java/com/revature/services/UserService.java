package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Account;
import com.revature.models.User;

@Service
public class UserService {
	
	private List<User> users = new ArrayList<User>();

	public UserService() {
		super();
		users.add(new User(1, "Steve", "Jobs", new Account(2000000)));
		users.add(new User(2, "John", "Smith", new Account(20)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}
		
		return null;
	}
	
	public boolean exists(int id) {
		for(User u : users) {
			if(id == u.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	public User upsert(User u) {
		if(exists(u.getId())) {
			User found = findOne(u.getId());
			found.setFirstname(u.getFirstname());
			found.setLastname(u.getLastname());
			found.setAccount(u.getAccount());
		} else {
			u.setId(users.size() + 1);
			users.add(u);
		}
		
		return u;
	}
}

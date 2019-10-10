package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findByAccount(Account account) {
		return userRepository.findByAccount(account);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}

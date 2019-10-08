package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserService() {
		super();
		System.out.println("No Arg Constructor");
	}

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		System.out.println("1 Arg Constructor");
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	/*
	 * public void setUserRepository(UserRepository userRepository) {
	 * this.userRepository = userRepository;
	 * System.out.println("setRepository method"); }
	 */
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public String toString() {
		return "UserService [userRepository=" + userRepository + ", findAll()=" + findAll() + "]";
	}
}

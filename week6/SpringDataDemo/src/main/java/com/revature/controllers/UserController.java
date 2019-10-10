package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/account")
	public ResponseEntity<User> findByAccount(@RequestBody Account account) {
		User u = userService.findByAccount(account);
		
		return ResponseEntity.ok(u);
	}
	
	@PutMapping
	public ResponseEntity<User> upsert(@RequestBody User user) {
		User u = userService.save(user);
		
		return ResponseEntity.ok(u);
	}
}

package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Account;
import com.revature.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByAccount(Account account);

}

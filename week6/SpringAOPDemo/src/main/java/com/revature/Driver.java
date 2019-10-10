package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Account;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		User u = (User) ac.getBean("user");
		
		System.out.println(u);
		Account account = (Account) ac.getBean("account");
		account.setAmount(500);
		u.setAccount(account);
		u.setId(1);
		u.setFirstname("Jodie");
		u.setLastname("Conrad");
		
		System.out.println(u);
		
		u.getAccount().deposit(200);
		
		u.getAccount().withdraw(500);
		u.getAccount().withdraw(500);
		
		((ClassPathXmlApplicationContext) ac).close();
	}
}

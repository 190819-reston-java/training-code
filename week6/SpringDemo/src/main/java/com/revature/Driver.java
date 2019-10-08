package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {

		/*
		 * ApplicationContext ac = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * 
		 * User user = (User) ac.getBean("user");
		 * 
		 * System.out.println(user);
		 * 
		 * UserService userService = (UserService) ac.getBean("userService");
		 * 
		 * System.out.println(userService);
		 */
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		User user = (User) ac.getBean("user");
		user.setLastname("New last name");
		
		System.out.println(user);
		
	}
}

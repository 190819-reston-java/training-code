package com.revature;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDAO userDAO = (IUserDAO) ac.getBean("userDAO");
		
		List<User> users = userDAO.findAll();
		
		for(User u : users) {
			System.out.println(u);
		}
		
//		System.out.println(userDAO.findOne(2));
		
		((ClassPathXmlApplicationContext) ac).close();
	}

}

package com.revature;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.repositories.PlayerDao;
import com.revature.repositories.PlayerDaoImplPjdbc;

/**
 * This class exists to run demos separate from the Players App
 * @author Revature
 *
 */
public class DemoDriver {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PlayerDao playerDao = new PlayerDaoImplPjdbc();
		
		System.out.println("Please give name to find in DB:");
		//If we pass in:
		// ';UPDATE players SET name='Malicious' WHERE name='Adam
		// Then we can affect the database however we like.
		//More common is:
		// ';DROP TABLE players;SELECT '
		//playerDao.demoSQLInjection(sc.nextLine());
		
	}
	
}

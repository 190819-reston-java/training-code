package com.revature.controller;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.model.Player;
import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;

public class PlayerCLI {
	
	private static Scanner sc = new Scanner(System.in);
	
	//This should go in a Service:
	private static Player selectedPlayer = null;
	
	public static void menu() {
		Arrays.asList(
				"Welcome to the menu.",
				"Select an option:",
				"1 : show all player info",
				"2 : select a player",
				"3 : send player to bat",
				"4 : exit",
				"")
				.forEach((String s)->{System.out.println(s);});
		
		String userInput = sc.nextLine();
		
		switch(userInput) {
		case "1":
			printAllPlayerInfo();
			break;
		case "2":
			printPlayerNameList();
			changeSelectedPlayer();
			break;
		case "3":
			sendPlayerToBat();
			break;
		case "4":
			System.out.println("Exiting. Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("Input not recognized");
		}
		menu();
		
	}
	
	//These methods ought be in a Service (the Service layer):
	
	//This should go in Service as well:
	private static PlayerDAO playerDAO = new PlayerDAOImplPJDBC();

	private static void sendPlayerToBat() {
		// TODO Auto-generated method stub
		
	}

	private static void changeSelectedPlayer() {
		// TODO Auto-generated method stub
		
	}

	private static void printPlayerNameList() {
		// TODO Auto-generated method stub
		
	}

	private static void printAllPlayerInfo() {
		// TODO Auto-generated method stub
		
	}

}

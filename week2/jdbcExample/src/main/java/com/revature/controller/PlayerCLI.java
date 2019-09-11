package com.revature.controller;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.model.Player;
import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;

public class PlayerCLI {
	
	private static Scanner sc = new Scanner(System.in);
	
	//This should go in a Service:
	private static Player selectedPlayer = new Player(
			0L, "Default", 0L, "C", 0);
	
	public static void menu() {
		Arrays.asList(
				"Welcome to the menu.",
				"Select an option:",
				"1 : show all player info",
				"2 : select a player",
				"3 : send player to bat",
				"4 : exit",
				"",
				"Current Selected Player:",
				selectedPlayer.toString(),
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
		System.out.println("Number of pitches? : ");
		long userInput = Long.parseLong(sc.nextLine());
		
		int hitCounter = 0;
		int missCounter = 0;
		double avg = selectedPlayer.getBattingAverage();
		
		for(int i=0; i<userInput; i++) {
			if(Math.random() < avg) {
				hitCounter++;
				System.out.println("a hit!");
			} else {
				missCounter++;
				System.out.println("missed!");
			}
		}
		
		double newAvg = ((double) hitCounter) / 
				((double) (hitCounter + missCounter));
		
		selectedPlayer.setBattingAverage(newAvg);
		
		playerDAO.updatePlayer(selectedPlayer);
		
	}

	private static void changeSelectedPlayer() {
		System.out.println("Select a player: ");
		//can throw NumberFormatException, we'll let it die
		long userInput = Long.parseLong(sc.nextLine());
		selectedPlayer = playerDAO.getPlayer(userInput);
	}

	private static void printPlayerNameList() {
		for(Player p : playerDAO.getPlayers()) {
			System.out.println(p.getId() + " : " + p.getName());
		}
	}

	private static void printAllPlayerInfo() {
		for(Player p : playerDAO.getPlayers()) {
			System.out.println(p);
		}
	}

}

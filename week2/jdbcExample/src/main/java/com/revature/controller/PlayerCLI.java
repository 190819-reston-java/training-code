package com.revature.controller;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.model.Player;
import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;
import com.revature.services.PlayerService;

public class PlayerCLI {
	
	private static Scanner sc = new Scanner(System.in);
	private static PlayerService playerService = new PlayerService();
	
	public static void menu() {
		Arrays.asList(
				"Welcome to the menu.",
				"Select an option:",
				"1 : show all player info",
				"2 : select a player",
				"3 : send player to bat",
				"4 : modify selected player",
				"5 : exit",
				"",
				"Current Selected Player:",
				playerService.getSelectedPlayer().toString(),
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
			askUserForPitches();
			break;
		case "4":
			askUserForNewPlayerDetails();
			break;
		case "5":
			System.out.println("Exiting. Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("Input not recognized");
		}
		menu();
	}
	
	private static void askUserForNewPlayerDetails() {
		//hacky
		Player sp = playerService.getSelectedPlayer();
		
		System.out.println("New Number? Current: " + sp.getNum());
		sp.setNum(Long.parseLong(sc.nextLine()));
		
		System.out.println("New Position? Current: " + sp.getPosition());
		sp.setPosition(sc.nextLine());
		
		System.out.println("New Batting Average? Current: " + sp.getBattingAverage());
		sp.setBattingAverage(Double.parseDouble(sc.nextLine()));

		playerService.updateSelectedPlayer();
	}
	

	private static void askUserForPitches() {
		System.out.println("How many pitches? : ");
		playerService.sendPlayerToBat(Long.parseLong(sc.nextLine()));
	}

	private static void changeSelectedPlayer() {
		System.out.println("Select a player: ");
		//can throw NumberFormatException, we'll let it die
		long userInput = Long.parseLong(sc.nextLine());
		playerService.changeSelectedPlayer(userInput);
	}

	private static void printPlayerNameList() {
		for(Player p : playerService.getPlayers()) {
			System.out.println(p.getId() + " : " + p.getName());
		}
	}

	private static void printAllPlayerInfo() {
		for(Player p : playerService.getPlayers()) {
			System.out.println(p);
		}
	}

}

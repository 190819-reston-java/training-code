package com.revature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import com.revature.controller.PlayerCli;
import com.revature.model.Player;
import com.revature.repositories.PlayerDao;
import com.revature.repositories.PlayerDaoImplPjdbc;
import com.revature.services.PlayerService;
import com.revature.utils.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		//Ideally this is all managed by something other than main:
		new PlayerCli(
				new Scanner(System.in),
				new PlayerService(new PlayerDaoImplPjdbc())
				).menu();
		
	}

}

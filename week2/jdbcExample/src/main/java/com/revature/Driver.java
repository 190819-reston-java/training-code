package com.revature;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.revature.controller.PlayerCLI;
import com.revature.model.Player;
import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;
import com.revature.utils.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		PlayerCLI.menu();
		
	}

}

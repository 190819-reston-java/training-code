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
		//ConnectionUtil.getConnection();
		
		PlayerCLI.menu();
		
//		PlayerDAO playerDAO = new PlayerDAOImplPJDBC();
//		
//		//SortedSet of Players
//		SortedSet<Player> pSet = new TreeSet<Player>(
//				(Player p1, Player p2)->{return (int) (1000*(p1.getBattingAverage() - p2.getBattingAverage()));}
//				);
//		
//		pSet.addAll(playerDAO.getPlayers());
//		System.out.println(pSet);
//		
//		playerDAO.getPlayers()
//				.forEach((Player p)->{System.out.println(p);});
//		
//		//playerDAO.createPlayer(new Player(0L, "Sammy Sosa", 21L, "RF", 0.4));
//		
//		for(Player p : playerDAO.getPlayers()) {
//			if (p.getName().equals("Test name 1")) {
//				p.setName("Mark Mcgwire");
//				playerDAO.updatePlayer(p);
//			}
//			System.out.println(p);
//		}
//		
//		System.out.println(playerDAO.getPlayer("Test name 1"));
//		System.out.println(playerDAO.getPlayer(4L));
		
		

	}

}

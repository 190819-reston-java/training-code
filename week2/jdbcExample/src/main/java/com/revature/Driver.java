package com.revature;

import com.revature.model.Player;
import java.time.Instant;
import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;
import com.revature.utils.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		//ConnectionUtil.getConnection();
		
		PlayerDAO playerDAO = new PlayerDAOImplPJDBC();
		
		playerDAO.getPlayers()
				.forEach((Player p)->{System.out.println(p);});
		
		//playerDAO.createPlayer(new Player(0L, "Sammy Sosa", 21L, "RF", 0.4));
		
		for(Player p : playerDAO.getPlayers()) {
			if (p.getName().equals("Test name 1")) {
				p.setName("Mark Mcgwire");
				playerDAO.updatePlayer(p);
			}
			System.out.println(p);
		}
		
		System.out.println(playerDAO.getPlayer("Test name 1"));
		System.out.println(playerDAO.getPlayer(4L));
		
		

	}

}

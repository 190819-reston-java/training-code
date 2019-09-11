package com.revature.repositories;

import java.util.List;

import com.revature.model.Player;

//DAOs are just Data Access Objects
// they're used to access data
/**
 * PlayerDAO retrieves and stores data about Player objects
 * 
 * @author Revature
 *
 */
public interface PlayerDAO {
	
	Player getPlayer(long id);
	
	Player getPlayer(String name);
	
	List<Player> getPlayers();
	
	boolean createPlayer(Player p);
	
	boolean updatePlayer(Player p);

}

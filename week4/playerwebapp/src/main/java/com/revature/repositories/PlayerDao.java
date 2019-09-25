package com.revature.repositories;

import java.util.List;

import com.revature.model.Player;

//DAOs are just Data Access Objects
// they're used to access data
/**
 * PlayerDao retrieves and stores data about Player objects
 * 
 * @author Revature
 *
 */
public interface PlayerDao {
	
	Player getPlayer(long id);
	
	Player getPlayer(String name);
	
	List<Player> getPlayers();
	
	boolean createPlayer(Player p);
	
	boolean updatePlayer(Player p);
	
	/**
	 * This method solely exists to demo CallableStatements and should not be used.
	 */
	void demoCallableStatement();
	
	/**
	 * This method solely exists to demo SQL Injection and should not be used.
	 * @param dangerousString
	 */
	void demoSQLInjection(String dangerousString);

}

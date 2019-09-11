package com.revature.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Player;
import com.revature.utils.ConnectionUtil;

public class PlayerDAOImplPJDBC implements PlayerDAO {

	@Override
	public Player getPlayer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		//Statement and ResultSet (and Connection) interfaces
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		//List to return
		List<Player> players = new ArrayList<Player>();
		
		try {
			//get connection from ConnectionUtil:
			conn = ConnectionUtil.getConnection();
			
			//create statement from connection
			statement = conn.createStatement();
			
			//Statements can execute sql queries:
			//ResultSet stores the results of a query
			resultSet = statement.executeQuery("SELECT * FROM players;");
			
			//loop through ResultSet
			while(resultSet.next()) {
				//At each row in the ResultSet, do the following:
				System.out.println(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//close all open resources to prevent memory leak
			try {
				resultSet.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		return players;
	}

	@Override
	public boolean createPlayer(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePlayer(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Player;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.StreamCloser;

public class PlayerDAOImplPJDBC implements PlayerDAO {

	@Override
	public Player getPlayer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String name) {
		ResultSet resultSet = null;
		//PreparedStatements are better than simple ones
		PreparedStatement statement =  null;
		
		Player player = null;
		
		//try-with-resources:
		// any resource that is AutoClosable (an interface)
		// can be used with try (resource) {} and it will close itself
		try (Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(
					"SELECT * FROM players WHERE name = ?;");
			//in our PreparedStatement, we set
			// values to be filled in later with ?
			// We'll set those values using the "index" 
			// of the ?, starting at 1.
			
			//fill in the ? with name argument
			statement.setString(1, name);
			
			//try to execute SQL query
			if(statement.execute()) {
				//get the ResultSet
				resultSet =  statement.getResultSet();
				//check for a single row and use it
				if(resultSet.next()) {
					player = new Player(
							resultSet.getLong("id"),
							resultSet.getString("name"),
							resultSet.getLong("num"), 
							resultSet.getString("position"),
							resultSet.getDouble("batting_average"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
		}
		
		return player;
	}

	@Override
	public List<Player> getPlayers() {
		// Statement and ResultSet (and Connection) interfaces
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;

		// List to return
		List<Player> players = new ArrayList<Player>();

		try {
			// get connection from ConnectionUtil:
			conn = ConnectionUtil.getConnection();

			// create statement from connection
			statement = conn.createStatement();

			// Statements can execute sql queries:
			// ResultSet stores the results of a query
			resultSet = statement.executeQuery("SELECT * FROM players;");

			// loop through ResultSet
			while (resultSet.next()) {
				// At each row in the ResultSet, do the following:
				players.add(new Player(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getLong("num"),
						resultSet.getString("position"), resultSet.getDouble("batting_average")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close all open resources to prevent memory leak
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
			StreamCloser.close(conn);
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

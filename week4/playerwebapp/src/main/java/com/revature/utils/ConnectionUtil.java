package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		//This line just makes sure JDBC can find the postgres driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			//We'll write some boilerplate to work with Properties
			Properties props = new Properties();
			//The following lines just ensure we find connection.properties
			//regardless of how our project is built:
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("connection.properties"));
			
			//All we've done is set these values to the values found in
			// connection.properties
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			//How to actually make connections with jdbc
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}

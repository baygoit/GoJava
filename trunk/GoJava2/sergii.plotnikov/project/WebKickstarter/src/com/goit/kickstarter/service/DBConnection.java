package com.goit.kickstarter.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	Connection connection;
	private String user = "postgres";
	private String password = "123";
	private String url = "jdbc:postgresql://localhost:5433/kickstarterdb";
	
	static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	public Connection getConnection() throws SQLException {
		connection=DriverManager.getConnection(url, user, password); 
		return connection;
	} 
}
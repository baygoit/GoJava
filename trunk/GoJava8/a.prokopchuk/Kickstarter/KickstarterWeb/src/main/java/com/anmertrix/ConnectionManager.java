package com.anmertrix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO I need ConnectionManager interface and implementation for mockito
public class ConnectionManager {
	
	private Connection connection;
    
	private void openConnection() {
            String url = "jdbc:mysql://s14.thehost.com.ua/kickstarter";
            try {
            	Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            try {
				connection = DriverManager.getConnection(url, "kickstarter", "kickstarter");
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
    }

	public synchronized Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			openConnection();
		}
		return connection;
    }

	public void closeConnection() throws SQLException {
		connection.close();
	}
}

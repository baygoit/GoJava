package com.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuotesDao {

	static {
		try {
			Class.forName("org.postgresql.Driver");	
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Something is wrong with driver downloads");
		}
	}
	
	public String getRandomQuote() {
		
	String quote = null;
	Connection connection = null;
	Statement statement = null;

	try {
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DataForKickstarter",
													"postgres", "Berezhnoi");
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT quote FROM quotes ORDER BY RANDOM() LIMIT 1;");
		while (resultSet.next()) {
			quote = resultSet.getString("quote");
		}
	} catch (Exception e) {
	} finally {
		if(connection != null) {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return quote;
  }
}
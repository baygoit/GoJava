package com.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuotesDAO {

	private Connection connection;

	public QuotesDAO(Connection connection) {
		this.connection = connection;
	}

	public String getRandomQuote() {

		String quote = null;
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT quote FROM quotes ORDER BY RANDOM() LIMIT 1;");
			while (resultSet.next()) {
				quote = resultSet.getString("quote");
			}
		} catch (Exception e) {
			throw new RuntimeException("Can't get random quote", e);
		}
		return quote;
	}
}
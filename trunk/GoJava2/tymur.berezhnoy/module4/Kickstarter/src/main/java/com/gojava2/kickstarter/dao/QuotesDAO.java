package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gojava2.kickstarter.model.Quote;
import com.gojava2.kickstarter.model.QuoteStorage;

public class QuotesDAO implements QuoteStorage {
	
	private Connection connection;

	public QuotesDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void add(final Quote quote) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO quotes (content, author) VALUES (?, ?)");
			statement.setString(1, quote.getContent());
			statement.setString(2, quote.getAuthor());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Can't add new quote", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT content, author FROM quotes ORDER BY RANDOM() LIMIT 1");
			while(resultSet.next()) {
				quote = new Quote(resultSet.getString("content"), resultSet.getString("author"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Can't get random quote", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return quote;
	}
	
	@Override
	public int getSize() {
		int result = 0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS COUNT FROM quotes");
			while (resultSet.next()) {
				result = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}
}
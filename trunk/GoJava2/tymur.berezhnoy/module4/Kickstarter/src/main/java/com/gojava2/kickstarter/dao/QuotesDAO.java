package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.gojava2.kickstarter.model.Quote;
import com.gojava2.kickstarter.model.QuoteStorage;

@Component
public class QuotesDAO extends AbstractDAO implements QuoteStorage {
	
	@Override
	public void add(final Quote quote) {
		try (Connection connection = getConnection(); 
			PreparedStatement statement = connection.prepareStatement("INSERT INTO quotes (content, author) VALUES (?, ?)")) {
			statement.setString(1, quote.getContent());
			statement.setString(2, quote.getAuthor());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Can't add new quote", e);
		}
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT content, author FROM quotes ORDER BY RANDOM() LIMIT 1");
			while(resultSet.next()) {
				quote = new Quote(resultSet.getString("content"), resultSet.getString("author"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Can't get random quote", e);
		}
		return quote;
	}
	
	@Override
	public int getSize() {
		int result = 0;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM quotes");
			while (resultSet.next()) {
				result = resultSet.getInt("count");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} 
		return result;
	}
}
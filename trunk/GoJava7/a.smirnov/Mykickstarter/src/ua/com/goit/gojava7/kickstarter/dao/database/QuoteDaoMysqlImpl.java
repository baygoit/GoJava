package ua.com.goit.gojava7.kickstarter.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.AbstractQuoteDao;

public class QuoteDaoMysqlImpl extends AbstractQuoteDao {
	private static final String INSERT_QUOTE = "INSERT INTO quotes (text, author) VALUES (?, ?)";
	private static final String DELETE_QUOTE = "DELETE FROM quotes WHERE author = ?";
	private static final String SELECT_RANDOM_QUOTE = "SELECT text, author FROM quotes ORDER BY RAND() LIMIT 1";
	private static final String COUNT_ALL_QUOTES = "SELECT count(*) FROM quotes";

	@Override
	public void add(Quote quote) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(INSERT_QUOTE)) {		
		
			statement.setString(1, quote.getQuoteText());
			statement.setString(2, quote.getAuthor());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void remove(Quote quote) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(DELETE_QUOTE)){		
		
			statement.setString(1, quote.getAuthor());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getSize() {
		int amountOfQuotes = 0;
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(COUNT_ALL_QUOTES)) {

			while (resultSet.next()) {
				amountOfQuotes = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return amountOfQuotes;
	}

	@Override
	public Quote getRandomQuote() {
		Quote randomQuote = null;
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_RANDOM_QUOTE)) {
		
			 while (resultSet.next()) {
				 randomQuote = new Quote();
				 randomQuote.setQuoteText(resultSet.getString("text"));
				 randomQuote.setAuthor(resultSet.getString("author"));
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return randomQuote;
	}
}

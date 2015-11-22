package ua.com.goit.gojava7.kickstarter.storage_in_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;

public class QuotesStorage implements QuoteDAO {
	private static final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	@Override
	public void add(Quote quote) {
		String insertQuote = "INSERT INTO quotes (text, author) VALUES ('" 
				+ quote.getQuoteText() + "' , '"+ quote.getAuthor() + "')";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(insertQuote);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
	}

	@Override
	public List<Quote> getAll() {
		String selectQuoteFilds = "SELECT text, author from quotes";
		List<Quote> quotes = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuoteFilds);
			
			 while (resultSet.next()) {
			        String quoteText = resultSet.getString("text");
			        String author = resultSet.getString("author");
			 
			        Quote quote = new Quote(quoteText, author);
			        quotes.add(quote);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return quotes;
	}

	@Override
	public int getSize() {
		String SelectCountCategories = "SELECT count(*) from quotes";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int amountOfQuotes = 0;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SelectCountCategories);

			while (resultSet.next()) {
				amountOfQuotes = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return amountOfQuotes;
	}

	@Override
	public Quote getRandomQuote() {
		String randomQuoteRequest = "SELECT text, author from quotes order by rand() limit 1";
		Quote randomQuote = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(randomQuoteRequest);
			
			 while (resultSet.next()) {
			        String quoteText = resultSet.getString("text");
			        String author = resultSet.getString("author");
			 
			        randomQuote = new Quote(quoteText, author);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return randomQuote;
	}
	
	@Override
	public void remove(Quote quote) {
		// TODO Auto-generated method stub
	}
}

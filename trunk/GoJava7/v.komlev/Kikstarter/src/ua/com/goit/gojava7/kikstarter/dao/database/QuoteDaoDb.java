package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class QuoteDaoDb implements QuoteDao {

	private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:PROBA";
	private static final String USER_NAME = "system";
	private static final String PASSWORD = "manager";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	@Override
	public void add(Quote quote) {
		String insertQuote = "INSERT INTO quotes (content, author) VALUES('" + quote.getContent()
				+ "', '" + quote.getAuthor() + "');";

		connection = null;
		statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:PROBA","SYSTEM","MANAGER");
			statement = connection.createStatement();
			statement.executeUpdate(insertQuote);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				} else if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("You have a problem with connection DB!");
			}
		}
	}

	@Override
	public void remove(Quote quote) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Quote> getAll() {
		String selectFieldsOfQuote = "SELECT content, author FROM quotes";
		List<Quote> quotes = new ArrayList<>();

		connection = null;
		statement = null;
		resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectFieldsOfQuote);

			while (resultSet.next()) {
				String content = resultSet.getString("content");
				String author = resultSet.getString("author");

				quotes.add(new Quote(content, author));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				} else if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("You have a problem with connection DB!");
			}
		}

		return quotes;
	}

	@Override
	public Quote getRandomQuote() {
		String selectRandomQuote = "SELECT * FROM (SELECT * FROM quotes ORDER BY DBMS_RANDOM.VALUE) WHERE = 1;";
		Quote randomQuote = null;

		connection = null;
		statement = null;
		resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectRandomQuote);

			while (resultSet.next()) {
				String content = resultSet.getString("content");
				String author = resultSet.getString("author");

				randomQuote = new Quote(content, author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				} else if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("You have a problem with connection DB!");
			}
		}

		return randomQuote;
	}

}

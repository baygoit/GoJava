package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.config.ConnectionPoolSource;
import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuoteDaoDbImpl implements QuoteDao {

	private static final String INSERT_QUOTE = "INSERT INTO quotes (content, author) VALUES(?, ?)";
	private static final String DELETE_QUOTE = "DELETE FROM quotes WHERE author = ?";
	private static final String SELECT_ALL_QUOTES = "SELECT content, author FROM quotes";
	private static final String SELECT_RANDOM_QUOTE = "SELECT * FROM (SELECT * FROM quotes ORDER BY DBMS_RANDOM.VALUE) WHERE rownum = 1";
	private static final String SELECT_COUNT_QUOTES = "SELECT COUNT(author) FROM quotes";
	
	private ConnectionPoolSource dataSource;

	public QuoteDaoDbImpl(ConnectionPoolSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Quote quote) {
		
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_QUOTE);
			statement.setString(1, quote.getContent());
			statement.setString(2, quote.getAuthor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Quote quote) {
		
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_QUOTE);
			statement.setString(1, quote.getAuthor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Quote> getAll() {
		List<Quote> quotes = new ArrayList<>();
		
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUOTES);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String content = resultSet.getString("content");
				String author = resultSet.getString("author");

				quotes.add(new Quote(content, author));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quotes;
	}

	@Override
	public Quote getRandomQuote() {
		Quote randomQuote = null;
		
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_RANDOM_QUOTE);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String content = resultSet.getString("content");
				String author = resultSet.getString("author");

				randomQuote = new Quote(content, author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return randomQuote;
	}

	public int getSize() {
		int countQuotes = 0;

		try {
			Connection connection=dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_COUNT_QUOTES);

			while (resultSet.next()) {
				countQuotes = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countQuotes;
	}
}

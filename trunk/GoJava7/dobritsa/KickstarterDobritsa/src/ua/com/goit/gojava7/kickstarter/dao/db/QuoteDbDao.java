package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteDbDao implements QuoteStorage {
	private Connection connection;

	public QuoteDbDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		
		try (PreparedStatement ps = connection.prepareStatement(query); 
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				String text = resultSet.getString("text");
				String author = resultSet.getString("author");
				quote = new Quote(text, author);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return quote;
	}

	@Override
	public Quote get(int index) {
		Quote quote = null;
		String query = "select text, author from quote where id = " + index;

		try (PreparedStatement ps = connection.prepareStatement(query); 
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				quote = new Quote(resultSet.getString("text"), resultSet.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quote;
	}

	@Override
	public List<Quote> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

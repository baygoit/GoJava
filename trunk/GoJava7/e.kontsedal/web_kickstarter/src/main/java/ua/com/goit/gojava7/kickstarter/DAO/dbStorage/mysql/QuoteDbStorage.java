package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.Quote;


public class QuoteDbStorage extends AbstractQuoteStorage {

	private final String INSERT_QUOTES = "INSERT INTO qoutes (text, author) VALUES (?, ?)";
	private final String SELECT_RAND_QUOTES = "SELECT text, author FROM quotes ORDER BY RAND() LIMIT 1";
	
	@Autowired
	private BasicDataSource basicDataSource;

	public void add(Quote quote) {
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_QUOTES);) {
			ps.setString(1, quote.getText());
			ps.setString(2, quote.getAuthor());
			ps.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			System.err.println("DB writing problem");
		}

	}

	@Override
	public Quote getRandomQuote() {
		Quote randomQuote = null;
		try (Connection connection = basicDataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_RAND_QUOTES);) {
			while (resultSet.next()) {
				randomQuote = new Quote();
				randomQuote.setText(resultSet.getString("text"));
				randomQuote.setAuthor(resultSet.getString("author"));
			}

		} catch (SQLException e) {
			// System.err.println("DB writing problem");
			e.printStackTrace();
		}
		return randomQuote;
	}

	public void setBasicDataSource(BasicDataSource basicDataSource) {
		this.basicDataSource = basicDataSource;
	}

	@Override
	public List<Quote> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

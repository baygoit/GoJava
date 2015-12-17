package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Quote;

@Component
public class QuoteDbDao extends DbDao<Quote> {

	private static final String TABLE = "quote";
	private static final String FIELDS = "text, author";

	public QuoteDbDao() {	
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public QuoteDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	public Quote getRandomQuote() {
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				return readElement(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Quote readElement(ResultSet resultSet) throws SQLException {
		Quote quote = new Quote();
		quote.setText(resultSet.getString("text"));
		quote.setAuthor(resultSet.getString("author"));
		return quote;
	}
}

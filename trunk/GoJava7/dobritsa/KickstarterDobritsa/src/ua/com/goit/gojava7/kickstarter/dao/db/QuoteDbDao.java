package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteDbDao extends DbDao<Quote> implements QuoteStorage {

	private static String TABLE = "quote";
	private static String FIELDS = "text, author";

	public QuoteDbDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	public Quote getRandomQuote() {
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				return readElement(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Quote readElement(ResultSet resultSet) throws SQLException {
		Quote quote = new Quote();
		quote.setText(resultSet.getString("text"));
		quote.setAuthor(resultSet.getString("author"));
		return quote;
	}
}

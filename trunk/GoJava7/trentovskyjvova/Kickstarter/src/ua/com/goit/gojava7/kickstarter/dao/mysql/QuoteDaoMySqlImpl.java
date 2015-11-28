package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class QuoteDaoMySqlImpl implements QuoteDao {
	private Connection connection;

	public QuoteDaoMySqlImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;

		try (PreparedStatement ps = connection
				.prepareStatement("SELECT text, author FROM quote order by rand() limit 1 ");
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String text = rs.getString("text");
				String author = rs.getString("author");
				quote = new Quote(text, author);
			}
		} catch (SQLException e) {

			throw new IODatabaseException("Problem with database", e);
		}

		return quote;
	}

}

package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;


public class QuoteDaoSqlImpl implements QuoteDao {
	private DaoProvider daoProvider;

	public QuoteDaoSqlImpl(DaoProvider daoProvider) {
		this.daoProvider = daoProvider;
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;
		
		Connection connection = daoProvider.open();
				
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT text, author FROM quote order by random() limit 1 ");
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String text = rs.getString("text");
				String author = rs.getString("author");
				quote = new Quote(text, author);
			}
		} catch (SQLException e) {
			getRandomQuote();
			//throw new IODatabaseException("Problem with database", e);
		}

		return quote;
	}

}

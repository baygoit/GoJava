package ua.nenya.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Quote;
import ua.nenya.util.ConnectionManager;

public class QuoteDaoDbImpl implements QuoteDao {
	private Quote quote;
	private ConnectionManager connectionManager;

	public QuoteDaoDbImpl(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public Quote getRandomQuote(Random random) {
		String query = "SELECT quote FROM quotes ORDER BY random()";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			statement.setMaxRows(1);
			ResultSet set = statement.executeQuery(query);
			set.next();
			quote = new Quote();
			quote.setName(set.getString("quote"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quote;
	}

	@Override
	public void initQuotes() {
		quote = new Quote();
	}

}

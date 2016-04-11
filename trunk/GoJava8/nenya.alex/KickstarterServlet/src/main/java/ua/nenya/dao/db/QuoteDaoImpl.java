package ua.nenya.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;

@Repository
public class QuoteDaoImpl implements QuoteDao {
	private Quote quote;
	private static final String GET_QUOTE = "SELECT quote FROM quotes ORDER BY random()";

	@Autowired
	private DataSource dataSource;

	@Override
	public Quote getRandomQuote(Random random) {
		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
			statement.setMaxRows(1);
			ResultSet set = statement.executeQuery(GET_QUOTE);
			set.next();
			quote = new Quote();
			quote.setName(set.getString("quote"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quote;
	}

//	@Override
//	public void initQuotes() {
//		quote = new Quote();
//	}

}

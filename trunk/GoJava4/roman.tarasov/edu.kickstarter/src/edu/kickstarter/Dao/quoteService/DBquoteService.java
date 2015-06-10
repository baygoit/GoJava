package edu.kickstarter.Dao.quoteService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import edu.kickstarter.database.DatabaseService;
import edu.kickstarter.entity.Quote;

public class DBquoteService implements QuoteService {

	@Override
	public Quote getRandomQuote() throws SQLException {

		Statement statement = DatabaseService.getInstance().getConnection()
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 0);
		ResultSet resultSet = statement
				.executeQuery("SELECT COUNT(*) AS rowcount FROM quotes");
		resultSet.next();
		int count = resultSet.getInt("rowcount");
		int randomPointer = new Random().nextInt(count);
		resultSet = statement.executeQuery("SELECT *  FROM quotes");
		resultSet.absolute(randomPointer);
		resultSet.next();
		int id = resultSet.getInt("id");
		Quote quote = new Quote();
		quote.setID(id);
		quote.setQuote(resultSet.getString("quote"));
		return quote;
	}

	@Override
	public List<Quote> getAll() {
		return null;
	}
}
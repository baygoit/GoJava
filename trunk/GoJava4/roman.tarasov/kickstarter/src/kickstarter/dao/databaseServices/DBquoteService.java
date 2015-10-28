package kickstarter.dao.databaseServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iQuoteService;
import kickstarter.entity.Quote;

public class DBquoteService implements iQuoteService {
	private iDatabaseService databaseService;

	public DBquoteService(iDatabaseService dbService) {
		this.databaseService = dbService;
	}

	@Override
	public Quote getRandomQuote() throws SQLException  {
		Statement statement = databaseService.getConnection().createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 0);
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

	@Override
	public void createQuotes(iDAO sourceDAO) throws SQLException {
		List<Quote> quotes = sourceDAO.getQuoteService().getAll();
		Statement statement = databaseService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  quotes ");
		statement
				.executeUpdate("CREATE TABLE quotes (id SERIAL not null PRIMARY KEY, quote varchar(255))");
		for (Quote quote : quotes) {
			statement.executeUpdate("INSERT INTO quotes VALUES ("
					+ quote.getID() + "," + "'" + quote.getQuote() + "')");
		}
	}
}
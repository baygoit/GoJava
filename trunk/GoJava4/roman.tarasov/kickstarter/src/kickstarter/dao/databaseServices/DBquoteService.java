package kickstarter.dao.databaseServices;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iQuoteService;
import kickstarter.entity.Quote;

public class DBquoteService implements iQuoteService {
	private List<Quote> quotes;
	private iDatabaseService databaseService;

	public DBquoteService(iDatabaseService dbService) {
		this.databaseService = dbService;
		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setID(1);
		quote.setQuote("Explore iprojects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setID(2);
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);
	}

	@Override
	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
	}

	@Override
	public List<Quote> getAll() {
		return quotes;
	}

	@Override
	public void createQuotes(iDAO sourceDAO)
			throws SQLException {
		databaseService.getConnection();
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
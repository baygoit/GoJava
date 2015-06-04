package kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Quote;

public interface iQuoteService {

	Quote getRandomQuote();

	List<Quote> getAll();
	void createQuotes(iDAO interfaceDAO, Connection connection) throws SQLException;
}

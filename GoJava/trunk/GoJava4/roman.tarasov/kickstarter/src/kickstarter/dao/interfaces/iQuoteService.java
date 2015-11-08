package kickstarter.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Quote;

public interface iQuoteService {

	Quote getRandomQuote() throws SQLException;

	List<Quote> getAll();
	void createQuotes(iDAO interfaceDAO) throws SQLException;
}

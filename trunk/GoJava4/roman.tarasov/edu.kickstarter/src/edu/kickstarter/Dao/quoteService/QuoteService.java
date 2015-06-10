package edu.kickstarter.Dao.quoteService;

import java.sql.SQLException;
import java.util.List;
import edu.kickstarter.entity.Quote;

public interface QuoteService {

	Quote getRandomQuote() throws SQLException;

	List<Quote> getAll();

}

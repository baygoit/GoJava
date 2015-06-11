package edu.kickstarter.DAO.quote;

import java.sql.SQLException;
import java.util.List;
import edu.kickstarter.entity.Quote;

public interface QuoteService {

	Quote getRandomQuote() throws SQLException;

	List<Quote> getAll();

}

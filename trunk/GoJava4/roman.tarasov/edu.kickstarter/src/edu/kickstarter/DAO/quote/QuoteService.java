package edu.kickstarter.DAO.quote;

import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Quote;

public interface QuoteService {

	Quote getRandomQuote() throws KickstarterException;

}

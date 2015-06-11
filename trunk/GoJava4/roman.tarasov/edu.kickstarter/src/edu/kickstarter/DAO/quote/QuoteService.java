package edu.kickstarter.DAO.quote;

import java.util.List;

import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Quote;

public interface QuoteService {

	Quote getRandomQuote() throws KickstarterException ;

	List<Quote> getAll();

}

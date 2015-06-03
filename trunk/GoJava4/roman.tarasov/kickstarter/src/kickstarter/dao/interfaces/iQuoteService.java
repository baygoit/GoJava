package kickstarter.dao.interfaces;

import java.util.List;

import kickstarter.entity.Quote;

public interface iQuoteService {

	Quote getRandomQuote();

	List<Quote> getAll();
}

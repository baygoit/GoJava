package ua.com.goit.gojava7.kickstarter.DAO;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public abstract class AbstractQuoteStorage implements Storage<Quote>{
	
	public abstract Quote getRandomQuote();
	
}

package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public abstract class AbstractQuoteStorage implements Storage<Quote> {

	public abstract Quote getRandomQuote();
	
}

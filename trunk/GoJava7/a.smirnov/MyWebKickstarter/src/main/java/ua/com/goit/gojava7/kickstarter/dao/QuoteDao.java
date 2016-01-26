package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public interface QuoteDao {

	public void add(Quote quote);

	public void remove(Quote quote);

	public Quote getRandomQuote();
}

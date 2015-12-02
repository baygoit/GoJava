package main.ua.com.goit.gojava7.kickstarter.dao;

import main.ua.com.goit.gojava7.kickstarter.beans.Quote;

public interface QuoteDao {
		
	public void add(Quote quote);

	public void remove(Quote quote);
	
	public int getSize();
	
	public Quote getRandomQuote();
}

package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public interface QuoteDAO {

	public void add(Quote quote);

	public void remove(Quote quote);
	
	public List<Quote> getAll();
	
	public int getSize();

	public Quote getRandomQuote();
	
}

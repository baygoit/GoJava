package ua.com.goit.gojava7.kikstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Quote;

public interface QuoteDao {
	
	void add(Quote quote);
	
	void remove(Quote quote);
	
	List<Quote> getAll();
	
	Quote getRandomQuote();
}

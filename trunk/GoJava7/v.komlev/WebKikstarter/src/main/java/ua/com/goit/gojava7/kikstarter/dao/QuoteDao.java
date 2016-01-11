package ua.com.goit.gojava7.kikstarter.dao;

import ua.com.goit.gojava7.kikstarter.domain.Quote;

public interface QuoteDao {

	void add(Quote quote);

	void remove(Quote quote);

	Quote getRandomQuote();
}

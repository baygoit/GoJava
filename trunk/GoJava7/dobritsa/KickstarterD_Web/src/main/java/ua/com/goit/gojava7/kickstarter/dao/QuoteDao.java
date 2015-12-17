package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.models.Quote;

public interface QuoteDao extends Dao<Quote> {

	Quote getRandomQuote();

}

package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public interface QuoteStorage extends Storage<Quote> {

	Quote getRandomQuote();

}

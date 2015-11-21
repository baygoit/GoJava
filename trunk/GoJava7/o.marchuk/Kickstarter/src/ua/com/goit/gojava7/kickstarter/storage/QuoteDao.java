package ua.com.goit.gojava7.kickstarter.storage;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public interface QuoteDao {

	Quote getRandomQuote();

}
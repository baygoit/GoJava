package ua.com.gojava4.kickstarter.model.repositories;

import ua.com.gojava4.kickstarter.entities.Quote;

public interface Dao extends Repository {

	Quote getRandomQuote();

}

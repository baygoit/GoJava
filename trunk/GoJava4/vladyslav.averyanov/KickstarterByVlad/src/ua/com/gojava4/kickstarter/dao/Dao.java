package ua.com.gojava4.kickstarter.dao;

import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.model.repositories.Repository;

public interface Dao extends Repository {

	Quote getRandomQuote();

}

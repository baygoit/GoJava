package kickstarter.model.dao.sub;

import java.sql.SQLException;

import kickstarter.exception.DataBaseException;
import kickstarter.model.entity.Quote;

public interface QuotesDAO {
	/**
	 * add new Quote to DB
	 */
	void addQuote(String quote) throws DataBaseException, SQLException;

	/**
	 * return random Quote from DB
	 */
	Quote getRandomQuote() throws DataBaseException, SQLException;

	/**
	 * create table Quotes in DB
	 */
	void createTableQuotes() throws DataBaseException, SQLException;
}

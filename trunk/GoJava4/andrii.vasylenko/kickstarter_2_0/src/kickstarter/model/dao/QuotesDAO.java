package kickstarter.model.dao;

import java.sql.SQLException;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.Quote;

public interface QuotesDAO {
	void addQuote(String quote) throws SQLException;

	Quote getRandomQuote() throws NoSuchDataException, SQLException;

	void createTableQuotes() throws SQLException;
}

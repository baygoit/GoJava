package kickstarter.model.dao;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Quote;

public interface QuotesDAO {
	void addQuote(String quote) throws CannotAddDataException;

	Quote getRandomQuote() throws CannotGetDataException;

	void createTableQuotes() throws CannotCreateTableException;
}

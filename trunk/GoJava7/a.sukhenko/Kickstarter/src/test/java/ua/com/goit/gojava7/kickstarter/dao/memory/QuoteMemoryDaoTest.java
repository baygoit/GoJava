package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;

@SuppressWarnings("unused")
public class QuoteMemoryDaoTest{
	DataSource dataSource = DataSource.MEMORY;
	DaoFactory daoFactory = new DaoFactory(dataSource);
	QuoteStorage quoteStorage = daoFactory.getQuoteStorage();
	@Test
	public void testQuoteMemoryDao() {
		assertNotNull(quoteStorage);
	}

	@Test
	public void testGetRandomQuote() {
		assertNotNull(quoteStorage.getRandomQuote());
	}

}

package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.dborisenko.kickstarter.dao.QuoteDao;

public class QuoteDaoTest {

	private QuoteDao quoteDao = new QuoteDao();

	@Test
	public void testGetRandomQuote() {
		quoteDao.fillAllQuotes();
		assertThat(quoteDao.getRandomQuote(), notNullValue());
	}

}

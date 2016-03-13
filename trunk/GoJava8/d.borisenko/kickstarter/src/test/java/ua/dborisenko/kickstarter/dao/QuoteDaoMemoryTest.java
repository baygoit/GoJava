package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.dborisenko.kickstarter.dao.QuoteDaoMemory;

public class QuoteDaoMemoryTest {

	private QuoteDaoMemory quoteDao = new QuoteDaoMemory();

	@Test
	public void testGetRandomQuote() {
		quoteDao.fillQuotes();
		assertThat(quoteDao.getRandomQuote(), notNullValue());
	}

}

package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class QuoteDaoMemoryTest {

	private QuoteDaoMemory quoteDao = new QuoteDaoMemory();

	@Ignore
	@Test
	public void testGetRandomQuote() {
		//quoteDao.fillQuotes();
		assertThat(quoteDao.getRandomQuote(), notNullValue());
	}

}

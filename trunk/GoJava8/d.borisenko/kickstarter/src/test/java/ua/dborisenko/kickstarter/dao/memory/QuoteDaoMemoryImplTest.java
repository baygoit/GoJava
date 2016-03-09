package ua.dborisenko.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.dborisenko.kickstarter.dao.memory.QuoteDaoMemoryImpl;

public class QuoteDaoMemoryImplTest {

	private QuoteDaoMemoryImpl quoteDao = new QuoteDaoMemoryImpl();

	@Test
	public void testGetRandomQuote() {
		quoteDao.fillAllQuotes();
		assertThat(quoteDao.getRandomQuote(), notNullValue());
	}

}

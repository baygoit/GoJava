package ua.dborisenko.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.dborisenko.kickstarter.dao.memory.QuoteDaoImpl;

public class QuoteDaoImplTest {

	private QuoteDaoImpl quoteDao = new QuoteDaoImpl();

	@Test
	public void testGetRandomQuote() {
		quoteDao.fillAllQuotes();
		assertThat(quoteDao.getRandomQuote(), notNullValue());
	}

}

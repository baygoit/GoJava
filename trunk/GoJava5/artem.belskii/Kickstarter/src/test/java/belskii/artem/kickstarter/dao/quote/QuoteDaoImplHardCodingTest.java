package belskii.artem.kickstarter.dao.quote;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteDaoImplHardCodingTest {
	QuoteDao quoteDao = new QuoteDaoImplHardCoding();


	@Test
	public void testQuoteDaoImplHardCoding() {
		assertNotNull(quoteDao);
	}

	@Test
	public void testGetRandomQuote() {
		assertNotEquals("", quoteDao.getRandomQuote());
	}

	@Test
	public void testAddQuote() {
		quoteDao.addQuote("some quote");
	}

}

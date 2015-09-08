package belskii.artem.kickstarter.dao.quote;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteDaoImplFileTest {
	QuoteDao quoteDao = new QuoteDaoImplFile();
	@Before
	public void setUp(){
		quoteDao.initDemoDB();
	}

	@Test
	public void testGetRandomQuote() {
		assertNotEquals("", quoteDao.getRandomQuote());
	}

	@Test
	public void testAddQuote() {
		quoteDao.addQuote("someQuote");
	}

}

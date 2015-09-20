package belskii.artem.kickstarter.dao.quote;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteDaoImplPsqlTest {

	QuoteDao quoteDao = new QuoteDaoImplPsql("conf/testDatabase.conf");
	
	@Before
	public void setUp(){
		quoteDao.initDemoDB();
	}
	
	@Test
	public void testQuoteDaoImplPsql() {
		assertNotNull(quoteDao);
	}

	@Test
	public void testGetRandomQuote() {
		assertNotEquals("", quoteDao.getRandomQuote());
	}

	@Test
	public void testAddQuote() {
		quoteDao.addQuote("some Quote");
	}

}

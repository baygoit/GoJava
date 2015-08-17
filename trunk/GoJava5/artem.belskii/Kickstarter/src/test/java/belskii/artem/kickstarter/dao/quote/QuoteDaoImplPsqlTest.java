package belskii.artem.kickstarter.dao.quote;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteDaoImplPsqlTest {
	QuoteDao quote = new QuoteDaoImplPsql("conf/database.conf");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQuoteDaoImplPsql() {
		assertNotNull(quote);
	}

	@Test
	public void testGetRandomQuote() {
		assertNotNull(quote.getRandomQuote());
	}

	@Test
	public void testAddQuote() {
//		quote.addQuote("Things work out best for those who make the best of how things work out.");
//		quote.addQuote("All our dreams can come true if we have the courage to pursue them.");
//		quote.addQuote("Success is walking from failure to failure with no loss of enthusiasm.");
//		quote.addQuote("Try not to become a person of success, but rather try to become a person of value.");
//		quote.addQuote("Don't be afraid to give up the good to go for the great.");		

	}

}

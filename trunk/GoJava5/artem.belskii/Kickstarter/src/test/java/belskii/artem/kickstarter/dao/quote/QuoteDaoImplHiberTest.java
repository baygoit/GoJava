package belskii.artem.kickstarter.dao.quote;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QuoteDaoImplHiberTest {
	final Logger logger = LoggerFactory.getLogger(QuoteDaoImplHiberTest.class);
	

	
	@Test
	public void testGetRandomQuote() {
		QuoteDao quote = new QuoteDaoImplHiber();
		assertTrue(!quote.getRandomQuote().equals(""));
	}

	@Test
	public void testAddQuote() {
		QuoteDao quote = new QuoteDaoImplHiber();
		Random random = new Random();
		int randomId  = random.nextInt(Integer.MAX_VALUE);
		if(randomId==0){
			randomId=1;
		}
		quote.addQuote("Hiber test quote" + randomId);
	}

	@Test @Ignore
	public void testInitDemoDB() {
//		QuoteDao quote = new QuoteDaoImplHiber();
//		quote.initDemoDB();
//		QuoteDao quoteNew = new QuoteDaoImplHiber();
//		assertEquals("Demo Quote", quoteNew.getRandomQuote());
	}

}

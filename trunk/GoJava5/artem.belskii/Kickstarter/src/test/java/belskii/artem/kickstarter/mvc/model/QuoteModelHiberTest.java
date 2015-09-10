package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class QuoteModelHiberTest {

	@Test
	public void testGetRandomQuote() {
		QuoteModelHiber quote= new QuoteModelHiber();
		assertTrue(!quote.getRandomQuote().equals(""));
	}

	@Test
	public void testAddQuote() {
		QuoteModelHiber quote= new QuoteModelHiber();
		Random random = new Random();
		int randomId  = random.nextInt(Integer.MAX_VALUE);
		if(randomId==0){
			randomId=1;
		}
		quote.addQuote("Hiber test quote" + randomId);
	}

	@Test @Ignore
	public void testInitDemoDB() {
		fail("Not yet implemented");
	}

}

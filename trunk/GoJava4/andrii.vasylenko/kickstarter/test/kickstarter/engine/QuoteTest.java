package kickstarter.engine;

import static org.junit.Assert.*;
import kickstarter.engine.Quote;

import org.junit.Test;

public class QuoteTest {

	@Test
	public void shouldNextId_whenCreateNew() {
		int firstId = new Quote("Quote").getId();
		
		for (int i = ++firstId; i < 10 + firstId; i++) {
			Quote quote = new Quote("Name"+i);
			assertEquals(i, quote.getId());
			Data data = quote;
			assertEquals(i, data.getId());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullQuote() throws IllegalArgumentException {
		new Quote(null);
	}

	@Test
	public void shouldStringQuote_whenStringQuote() {
		Quote quote = new Quote("quote");
		assertEquals("quote", quote.getQuote());
	}

}

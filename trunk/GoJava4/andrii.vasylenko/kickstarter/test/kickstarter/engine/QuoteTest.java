package kickstarter.engine;

import static org.junit.Assert.*;
import kickstarter.engine.Quote;

import org.junit.Test;

public class QuoteTest {

	@Test
	public void shouldStringQuote_whenQuoteName() {
		Quote quote = new Quote("quote");
		assertEquals("quote", quote.getQuote());
	}

}

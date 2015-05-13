package kickstarter.data_types;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteTest {

	@Test
	public void shouldStringQuote_whenQuoteName() {
		Quote quote = new Quote("quote");
		assertEquals("quote", quote.getQuote());
	}

}

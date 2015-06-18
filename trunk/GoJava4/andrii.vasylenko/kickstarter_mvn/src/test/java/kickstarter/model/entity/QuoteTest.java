package kickstarter.model.entity;

import static org.junit.Assert.assertEquals;
import kickstarter.model.entity.Quote;

import org.junit.Test;

public class QuoteTest {
	@Test
	public void shouldGetTheSameQuote_whenNewQuote() {
		Quote quote = new Quote(3, "test quote");
		assertEquals(3, quote.getId());
		assertEquals("test quote", quote.getQuote());
	}
}

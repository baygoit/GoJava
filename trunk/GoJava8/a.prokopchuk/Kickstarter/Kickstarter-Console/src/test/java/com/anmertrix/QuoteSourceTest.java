package com.anmertrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuoteSourceTest {
	
	@Test
	public void setQuote() {
		QuoteSource quoteSource = new QuoteSource();
		Quote quote = new Quote("test");
		quoteSource.setQuote(quote);
		assertEquals("test", quoteSource.getRandomQuote());
	}
}

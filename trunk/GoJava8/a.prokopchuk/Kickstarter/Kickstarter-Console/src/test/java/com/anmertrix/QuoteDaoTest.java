package com.anmertrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuoteDaoTest {
	
	@Test
	public void setQuote() {
		QuoteDao quoteSource = new QuoteDaoFile();
		Quote quote = new Quote("author", "test");
		quoteSource.setQuote(quote);
		assertEquals("test", quoteSource.getRandomQuote());
	}
}

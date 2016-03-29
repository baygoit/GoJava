package com.anmertrix.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.anmertrix.domain.Quote;

public class QuoteTest {

	@Test
	public void getQuoteTest() {
		Quote quote = new Quote("author", "test");
		assertTrue("test" == quote.getQuoteText());
	}
}
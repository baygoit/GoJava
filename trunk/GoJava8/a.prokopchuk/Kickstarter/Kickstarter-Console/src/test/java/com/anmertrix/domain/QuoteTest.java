package com.anmertrix.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.anmertrix.domain.Quote;

public class QuoteTest {

	@Test
	public void getQuoteTest() {
		Quote quote = new Quote();
		quote.setAuthor("author");
		quote.setQuoteText("test");
		assertTrue("test" == quote.getQuoteText());
		assertTrue("author" == quote.getAuthor());
	}
}
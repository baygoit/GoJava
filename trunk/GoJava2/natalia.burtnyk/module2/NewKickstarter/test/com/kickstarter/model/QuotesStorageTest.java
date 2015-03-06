package com.kickstarter.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class QuotesStorageTest {
	
	private QuotesStorage quoteStorage;
	
	@Before
	public void setUp() {
		quoteStorage = new QuotesStorage();
	}
	
	@Test
	public void shouldListContainsQuote_whenAddQuote() {
		String quote = "Lost time is never found again.";
		quoteStorage.addQuote(quote);
		assertSame(quote,quoteStorage.getRundomQuote());
	}
	
}

package org.goJava2.kickstarter.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.goJava2.kickstarter.content.Quote;
import org.junit.Test;

public class QuoteStorageTest {
	
	private QuoteStorage quoteStorage;
	
	@Test
	public void shouldQuoteNotNull_WhenRandomQuote() {
		quoteStorage = new QuoteStorage();
		assertNotNull("Proof of return! RandomQuote should return any quote(not null).",
					  quoteStorage.getRandomQuote());
	}
	
	@Test
	public void shouldListSizeNot0_whenNewQuoteStorage() {
		quoteStorage = new QuoteStorage();
		assertFalse("Expected that constructor for Hard-coded quotes init at least 1 quote.",
					quoteStorage.getContent().size() == 0);
	}
	
	@Test
	public void shouldListNotBeNull_whenNewQuoteStorage() {
		quoteStorage = new QuoteStorage();
		assertFalse("Expected that list is not null.",
					quoteStorage.getContent() == null);
	}
	
	@Test
	public void shouldListContainsNewQuote_whenAddNewQuote() {
		quoteStorage = new QuoteStorage();
		
		Quote quote = new Quote("New quote", "author");
		quoteStorage.addContent(quote);
		
		assertTrue("Expected that new created quote is at storage.",
					quoteStorage.getContent().contains(quote));
	}
	
	@Test
	public void listShouldNotBeNull_whenNewCustomQuoteStorage() {
		quoteStorage = new QuoteStorage(new ArrayList<Quote>());
		assertFalse("Expected that list is not null.",
					quoteStorage.getContent() == null);
	}
}
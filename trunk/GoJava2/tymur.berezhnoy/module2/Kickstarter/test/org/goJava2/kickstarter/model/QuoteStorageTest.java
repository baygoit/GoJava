package org.goJava2.kickstarter.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.media.jai.remote.JAIRMIDescriptor;

import org.goJava2.kickstarter.content.Quote;
import org.goJava2.kickstarter.view.InOut;
import org.junit.Test;

public class QuoteStorageTest {
	
	private QuoteStorage quoteStorage;
	
	@Test
	public void shouldRandomQuote() {
		// TODO
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
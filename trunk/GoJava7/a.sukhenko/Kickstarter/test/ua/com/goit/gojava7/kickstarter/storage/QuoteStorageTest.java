package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteStorageTest {
	private QuoteStorage quoteStorage = new QuoteStorage();
	
	@Before
	public void addQuote(){
		quoteStorage.addQuote(new Quote("Quote","Author"));
	}
	@Test
	public void testQuoteStorageAddQuote() {
		assertThat(quoteStorage.getQuotes().get(0).getQuoteName(), is("Quote"));
	}
	@Test
	// Testing our getRandomQuote to be sure that every quote appears at least 1 time after calling getRandomQuote() 100 times.
	public void testRandomQuote(){
		HashSet<Quote> quotesRandomHolder = new HashSet<>();
		quoteStorage.addQuote(new Quote("Q1", "A1"));
		quoteStorage.addQuote(new Quote("Q2", "A2"));
		quoteStorage.addQuote(new Quote("Q3", "A3"));
		quoteStorage.addQuote(new Quote("Q4", "A4"));
		for (int i = 0; i < 100; i++) {
			quotesRandomHolder.add(quoteStorage.getRandomQuote());
		}
		assertTrue(quotesRandomHolder.size() == 5);
		
		
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testUnmodifiableList(){
		// Exception should appear after we try to add new Quote.
		quoteStorage.getQuotes().add(new Quote("Some Quote", "Some Author"));
		assertThat(quoteStorage.getQuotes().size(), is(0));
	}
}

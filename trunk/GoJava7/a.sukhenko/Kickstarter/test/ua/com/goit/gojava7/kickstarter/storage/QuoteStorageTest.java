package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteStorageTest {
	QuoteStorage quoteStorage = new QuoteStorage();
	
	@Before
	public void addQuote(){
		quoteStorage.addQuote(new Quote("Quote","Author"));
	}
	@Test
	public void testQuoteName() {
		assertThat(quoteStorage.getQuotes().get(0).getQuoteName(), is(new Quote("Quote","Author").getQuoteName()));
	}
	@Test
	public void testRandomQuote(){
		HashSet<Quote> quotesRandomHolder = new HashSet<>();
		quoteStorage.addQuote(new Quote("Q1", "A1"));
		quoteStorage.addQuote(new Quote("Q2", "A2"));
		quoteStorage.addQuote(new Quote("Q3", "A3"));
		quoteStorage.addQuote(new Quote("Q4", "A4"));
		for (int i = 0; i < 100; i++) {
			quotesRandomHolder.add(quoteStorage.getRandomQuote());
		}
		//System.out.println(quotesRandomHolder.size());
		assertTrue(quotesRandomHolder.size() > 4);
		
		
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testUnmodifiableList(){
		quoteStorage.getQuotes().add(new Quote("Some Quote", "Some Author"));
		assertThat(quoteStorage.getQuotes().size(), is(1));
	}
}

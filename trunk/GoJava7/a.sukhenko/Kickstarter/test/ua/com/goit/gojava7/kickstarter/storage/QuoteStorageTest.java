package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteStorageTest {
	// OLEG it better to use a private access here
	QuoteStorage quoteStorage = new QuoteStorage();
	
	@Before
	public void addQuote(){
		quoteStorage.addQuote(new Quote("Quote","Author"));
	}
	@Test
	// OLEG what we are testing here? quoteStorage or Quote.getName? If 1st - use correct name for test. If 2 - move it to QuoteTest
	public void testQuoteName() {
		// OLEG it is better use just is("Quote") in "is" parameter
		assertThat(quoteStorage.getQuotes().get(0).getQuoteName(), is(new Quote("Quote","Author").getQuoteName()));
	}
	@Test
	// OLEG what we are testing here? I am sure I understand.
	// OLEG will we use the simiplar code in the real application?
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
		// OLEG I am not sure I see the meaning for this
		assertTrue(quotesRandomHolder.size() > 4);
		
		
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testUnmodifiableList(){
		quoteStorage.getQuotes().add(new Quote("Some Quote", "Some Author"));
		// OLEG unmodifieable list doesnot suuport size()? Hm
		assertThat(quoteStorage.getQuotes().size(), is(1));
	}
}

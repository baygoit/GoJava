package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorageTest extends Assert{
	QuoteStorage quoteStorage = new QuoteStorage();
	List<Quote> quotes = new ArrayList<Quote>();

	@Before
	public void test() {
		quotes.add(new Quote("QuoteName1", "QuoteAuthor1"));
		quotes.add(new Quote("QuoteName2", "QuoteAuthor2"));
		quotes.add(new Quote("QuoteName3", "QuoteAuthor3"));
		quotes.add(new Quote("QuoteName4", "QuoteAuthor4"));
		quoteStorage.setAll(quotes);
	}

	@Test
	public void testSetAll() {
		assertThat(quoteStorage.size(), is(4));
		assertThat(quoteStorage.get(0).getText(), is("QuoteName1"));
	}

	@Test
	public void testGetAll() {
		assertThat(quoteStorage.getAll().size(), is(4));
	}

	@Test
	public void testGet() {
		assertThat(quoteStorage.get(0).getAuthor(), is("QuoteAuthor1"));		
	}
	
	@Test
	public void testGetIfEmpty() {
		QuoteStorage quoteStorage1 = new QuoteStorage();
		quoteStorage1.getRandomQuote();
		assertThat(quoteStorage1.size(), is(1));		
	}
	
	@Test
	@Ignore
	public void testGetRandomQuote() {
		assertNotSame(quoteStorage.getRandomQuote(), quoteStorage.getRandomQuote());		
	}
	
}

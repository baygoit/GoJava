package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorageTest {

	private QuoteStorage quoteStorage = new QuoteStorage();
	private Quote quote1 = new Quote("TestText1", "TestAuthor1");
	private Quote quote2 = new Quote("TestText2", "TestAuthor2");
	private Quote quote3 = new Quote("TestText3", "TestAuthor3");
	
	@Before
	public void setUp() {
		quoteStorage.add(quote1);
		quoteStorage.add(quote2);
		quoteStorage.add(quote3);
	}
	
	@Test
	public void testEmpty() {
		quoteStorage = new QuoteStorage();
		assertThat(quoteStorage.size(), is(0));
	}
	
	@Test
	public void testAdd() {
		assertThat(quoteStorage.size(), is(3));
	}
	
	@Test
	public void testGet() {
		assertThat(quoteStorage.get().size(), is(3));
	}	
	
	@Test
	public void testGetRandomQuote() {		
		assertFalse(quoteStorage.getRandomQuote().getText() != quoteStorage.getRandomQuote().getText());
	}	
	
}

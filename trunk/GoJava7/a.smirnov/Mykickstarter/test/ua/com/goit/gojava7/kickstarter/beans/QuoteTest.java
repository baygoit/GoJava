package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteTest {

	private Quote quote;
	String quoteText = "Hello world";
	String author = "Smirnov Anton";
	
//	@Before
//	public void setUp() throws Exception {
//		quote = new Quote(quoteText, author);
//	}

	@Test
	public void testQuote() {
		assertThat(quote.getQuoteText(), is(quoteText));
		assertThat(quote.getAuthor(), is(author));
	}

	@Test
	public void testSetQuoteText() {
		String newQuoteText = "Some text....";
		quote.setQuoteText(newQuoteText);
		assertThat(quote.getQuoteText(), is(newQuoteText));
	}

	@Test
	public void testGetQuoteText() {
		assertThat(quote.getQuoteText(), is(quoteText));
	}

	@Test
	public void testSetAuthor() {
		String name = "Alex";
		quote.setAuthor(name);
		assertThat(quote.getAuthor(), is(name));
	}

	@Test
	public void testGetAuthor() {
		assertThat(quote.getAuthor(), is(author));
	}
}

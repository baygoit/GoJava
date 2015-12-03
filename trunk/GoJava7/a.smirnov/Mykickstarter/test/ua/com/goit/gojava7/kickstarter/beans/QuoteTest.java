package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteTest {

private Quote quote = new Quote();
	String quoteText = "Hello world";
	String author = "Smirnov Anton";
	
	@Before
	public void setUp() throws Exception {
		quote.setQuoteText(quoteText);
		quote.setAuthor(author);
	}

	@Test
	public void testQuote() {
		Quote muQuote = new Quote();
		assertThat(muQuote.getQuoteText().length(), is(0));
		assertThat(muQuote.getAuthor().length(), is(0));
	}

	@Test
	public void testGetQuoteText() {
		assertThat(quote.getQuoteText(), is(quoteText));
	}
	
	@Test
	public void testSetQuoteText() {
		String newQuoteText = "Some text....";
		quote.setQuoteText(newQuoteText);
		assertThat(quote.getQuoteText(), is(newQuoteText));
	}

	@Test
	public void testGetAuthor() {
		assertThat(quote.getAuthor(), is(author));
	}
	
	@Test
	public void testSetAuthor() {
		String name = "Alex";
		quote.setAuthor(name);
		assertThat(quote.getAuthor(), is(name));
	}
}

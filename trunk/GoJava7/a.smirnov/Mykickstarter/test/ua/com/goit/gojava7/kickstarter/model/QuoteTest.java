package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QuoteTest {

	private Quote quote1;
	private Quote quote2;
	
	@Before
	public void setUp() throws Exception {
		quote1 = new Quote("Anton", "Ukraine");
		quote2 = new Quote("Oleg", "Cyprus");
	}

	@Test
	public void testQuote() {
		StringBuilder result = new StringBuilder();
		result.
			append(quote1.getAuthor()).
			append(quote1.getQuoteText());
		assertThat(result.toString(), is("AntonUkraine"));
	}

	@Test
	public void testGetQuoteText() {
		assertThat(quote1.getQuoteText(), is("Ukraine"));
	}
	
	@Test
	public void testSetQuoteText() {
		quote1.setQuoteText("England");
		assertThat(quote1.getQuoteText(), is("England"));
	}

	@Test
	public void testGetAuthor() {
		assertThat(quote1.getAuthor(), is("Anton"));
	}
	
	@Test
	public void testSetAuthor() {
		quote1.setAuthor("Toni");
		assertThat(quote1.getAuthor(), is("Toni"));
	}
	
	@Test
	public void testCompareTo() {
		int result = quote1.getAuthor().compareTo(quote2.getAuthor());
		assertTrue(result < 0);
	}
}

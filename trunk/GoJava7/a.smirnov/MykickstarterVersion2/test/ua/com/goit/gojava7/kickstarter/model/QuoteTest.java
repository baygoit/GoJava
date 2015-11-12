package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QuoteTest {
	Quote quote = new Quote("Anton", "111");
	
	@Test
	public void testQuote() {
		StringBuilder result = new StringBuilder();
		result.
			append(quote.getAuthor()).
			append(quote.getQuoteText());
		assertThat(result.toString(), is("Anton111"));
	}

	@Test
	public void testGetQuoteText() {
		assertThat(quote.getQuoteText(), is("111"));
	}
	
	@Test
	public void testSetQuoteText() {
		quote.setQuoteText("222");
		assertThat(quote.getQuoteText(), is("222"));
	}

	@Test
	public void testGetAuthor() {
		assertThat(quote.getAuthor(), is("Anton"));
	}
	
	@Test
	public void testSetAuthor() {
		quote.setAuthor("Toni");
		assertThat(quote.getAuthor(), is("Toni"));
	}
}

package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorageTest {

	private QuoteStorage quoteStorage = new QuoteStorage(new FakeRandom());

	private class FakeRandom extends Random {

		private boolean one = true;

		@Override
		public int nextInt(int i) {
			int ret = one ? 0 : 1;
			one = !one;
			return ret;
		}
	}

	@Test
	public void testEmpty() {
		assertThat(quoteStorage.size(), is(0));
	}

	@Test
	public void testGet() {
		Quote quote = new Quote("aaa", "sdsd");
		quoteStorage.add(quote);
		assertThat(quoteStorage.get(0).getText(), is(quote.getText()));
	}

	@Ignore
	@Test
	public void testGetRandomQuoteWithEmpty() {
		System.out.println(quoteStorage.getRandomQuote());
	}

	@Test
	public void testSetQuotes() {
		Quote quote = new Quote("text", "author");
		List<Quote> quotes = new ArrayList<>();
		quotes.add(quote);

		quoteStorage.setQuotes(quotes);
		assertThat(quoteStorage.getRandomQuote(), notNullValue());
	}
	
	@Test
	public void TestGetRandomQuote() {
		List<Quote> quotes = new ArrayList<>(); 
		quotes.add(new Quote("text 1", "author 1"));
		quotes.add(new Quote("text 2", "author 2"));
		
		quoteStorage.setQuotes(quotes);
		assertThat(quoteStorage.getRandomQuote().getText(), is("text 1"));
		assertThat(quoteStorage.getRandomQuote().getText(), is("text 2"));
	}
}

package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteDaoMemoryImplTest {

	private QuoteDaoMemoryImpl quoteStorage = new QuoteDaoMemoryImpl(new FakeRandom());

	private class FakeRandom extends Random {

		private boolean one = true;

		@Override
		public int nextInt(int i) {
			int ret = one ? 0 : 1;
			one = !one;
			return ret;
		}

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
	public void testGetRandomQuote() {
		List<Quote> quotes = new ArrayList<>();
		quotes.add(new Quote("text 1", "author 1"));
		quotes.add(new Quote("text 2", "author 2"));

		quoteStorage.setQuotes(quotes);
		assertThat(quoteStorage.getRandomQuote().getText(), is("text 1"));
		assertThat(quoteStorage.getRandomQuote().getText(), is("text 2"));
	}

}

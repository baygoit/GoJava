package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public void testSetQuotes() {
		Quote quote = new Quote("Quote", "Author");
		quoteStorage.add(quote);
		
		assertThat(quoteStorage.getRandomQuote(), notNullValue());
	}
}

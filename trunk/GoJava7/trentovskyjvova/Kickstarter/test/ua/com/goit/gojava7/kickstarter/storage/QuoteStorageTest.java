package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorageTest {
	private static final Random RANDOM = new Random(42);
	private QuoteStorage quoteStorage = new QuoteStorage();
	private Quote quote = new Quote("aaa", "sdsd");
	
	@Test
	public void testEmpty() {
		assertThat(quoteStorage.size(), is(0));
	}
	
	@Test
	public void testAdd() {
		quoteStorage.add(quote);
		assertThat(quoteStorage.size(), is(1));
	}
	
	@Test
	public void testGet() {
		quoteStorage.add(quote);
		assertThat(quoteStorage.get(0).getText(), is(quote.getText()));
	}
	
	@Test
	public void TestGetRandomQuote() {
		quoteStorage.add(quote);
		Quote quote2 = new Quote("aaa2", "sdsd2");
		quoteStorage.add(quote2);
		int randomNumber = RANDOM.nextInt(quoteStorage.size());

		assertThat(quoteStorage.getRandomQuote(), is(quoteStorage.get(randomNumber)));
	}
}

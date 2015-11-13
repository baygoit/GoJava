package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorageTest {
	private Random random;
	private QuoteStorage quoteStorage;
	
    @Before
    public void setUp() {
    	random = new FakeRandom();
    	quoteStorage = new QuoteStorage(random);
    }
	
	@Test
	public void testEmpty() {
		assertThat(quoteStorage.size(), is(0));
	}
	
	@Test
	public void shouldContainQuote_wheAddQuote() {
		quoteStorage.add(new Quote("aaaaa", "sssss"));
		int expected = 1;
		assertEquals(expected, quoteStorage.size());
	}
	
	@Test
	public void testGet() {
		Quote quote = new Quote("aaa", "sdsd");
		quoteStorage.add(quote);
		assertThat(quoteStorage.get(0).getText(), is(quote.getText()));
	}
	
	@Test
	public void TestGetRandomQuote() {
		quoteStorage.add(new Quote("aaa", "sdsd"));
		quoteStorage.add(new Quote("aaa2", "sdsd2"));
		int randomNumber = random.nextInt(quoteStorage.size());

		assertThat(quoteStorage.getRandomQuote(), is(quoteStorage.get(randomNumber)));
	}
	
	class FakeRandom extends Random{
		public int nextInt(int size) {
			return 1;
		}
	}
}

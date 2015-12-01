package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoMemoryImplTest {

	@Mock
	private Random random;

	@InjectMocks
	private QuoteDaoMemoryImpl quoteStorage = new QuoteDaoMemoryImpl(random);

	@Before
	public void setUp() {
		when(random.nextInt(anyInt())).thenReturn(0, 1);
	}

	@Ignore
	@Test
	public void testGetRandomQuoteWithEmpty() {
		System.out.println(quoteStorage.getRandomQuote());
	}

	@Test
	public void testSetQuotes() {
		Quote quote = new Quote("text", "author");
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(quote);

		quoteStorage.setQuotes(quotes);
		assertThat(quoteStorage.getRandomQuote(), notNullValue());
	}

	@Test
	public void testGetRandomQuote() {
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(new Quote("text 1", "author 1"));
		quotes.add(new Quote("text 2", "author 2"));

		quoteStorage.setQuotes(quotes);
		assertThat(quoteStorage.getRandomQuote().getText(), is("text 1"));
		assertThat(quoteStorage.getRandomQuote().getText(), is("text 2"));
	}

}

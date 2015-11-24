package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoMemoryImplTest extends Assert{
	
	@Mock
	private Random random;
	
	@InjectMocks
	QuoteDaoMemoryImpl quoteStorage = new QuoteDaoMemoryImpl(random);
	
	List<Quote> quotes = new ArrayList<Quote>();

	@Before
	public void setUp() {
		when(random.nextInt(anyInt())).thenReturn(0, 1);
	}
	
	@Before
	public void test() {
		quotes.add(new Quote("QuoteName1", "QuoteAuthor1"));
		quotes.add(new Quote("QuoteName2", "QuoteAuthor2"));		
		quoteStorage.setQuotes(quotes);
	}
		
	@Test	
	public void testGetRandomQuote() {
		quoteStorage.setQuotes(quotes);
		assertThat(quoteStorage.getRandomQuote().getText(), is("QuoteName1"));
		assertThat(quoteStorage.getRandomQuote().getText(), is("QuoteName2"));		
	}	
}

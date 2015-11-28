package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteMemoryDaoTest extends Assert{
	
	@Mock
	private Random random;
	
	private Quote quote1;
	private Quote quote2;
	private List<Quote> quotes = new ArrayList<>();	
	
	@InjectMocks
	QuoteMemoryDao quoteStorage;
	


	@Before
	public void setUp() {		
		quote1 = new Quote();
		quote1.setText("TestQuote1");
		quote1.setAuthor("TestAuthor1");
		quotes.add(quote1);		
		
		quote2 = new Quote();
		quote2.setText("TestQuote2");
		quote2.setAuthor("TestAuthor2");
		quotes.add(quote2);		
		quoteStorage = new QuoteMemoryDao(quotes);
		
		when(random.nextInt(anyInt())).thenReturn(0, 1);		
	}

	@Test	
	public void testGetRandomQuote() {	
		System.out.println(quoteStorage.getRandomQuote().getText());
		assertThat(quoteStorage.getRandomQuote().getText(), is("TestQuote1"));
		assertThat(quoteStorage.getRandomQuote().getText(), is("TestQuote2"));		
	}	
}

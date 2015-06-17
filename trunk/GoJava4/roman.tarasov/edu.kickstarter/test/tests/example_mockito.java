package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.pool.KickstarterException;
import dao.quote.DefaultQuoteServiceImpl;
import dao.quote.Quote;

import org.mockito.*;

public class example_mockito extends Mockito {
	DefaultQuoteServiceImpl serv;

	public example_mockito() {
		super();
		serv = new DefaultQuoteServiceImpl();

	}

	@Test
	public void test() throws KickstarterException {

		Quote quote = new Quote();
		quote.setID(5);
		System.out.println(quote.getQuote());
		DefaultQuoteServiceImpl stubQuoteService = mock(DefaultQuoteServiceImpl.class);
		
		when(stubQuoteService.getRandomQuote()).thenReturn(quote);
		assertEquals(5, quote.getID());

	}
}

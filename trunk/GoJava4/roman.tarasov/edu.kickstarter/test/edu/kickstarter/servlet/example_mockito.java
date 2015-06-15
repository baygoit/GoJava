package edu.kickstarter.servlet;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.kickstarter.DAO.quote.DefaultQuoteServiceImpl;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Quote;
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

package belskii.artem.kickstarter.mvc.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.mvc.model.QuoteModel;

public class QuoteControllerTest {
	private QuoteController quote;

	@Before
	public void setUp() throws Exception {
		quote = new QuoteController(new QuoteModel());
	}

	@Test
	public void testQuoteController() {
		assertNotNull(quote.getRandomQuote());
	}

	@Test
	public void testGetRandomQuote() {
		assertNotNull(quote.getRandomQuote());
	}

	@Test
	public void testAddquote() {
		quote.addquote("some quote");
	}

}

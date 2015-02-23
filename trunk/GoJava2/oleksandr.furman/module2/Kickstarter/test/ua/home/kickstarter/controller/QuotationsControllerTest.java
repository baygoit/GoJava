package ua.home.kickstarter.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.content.Quote;

public class QuotationsControllerTest {
	QuotationsController quotationsController;
	private Quote quote;
	@Before
	public void setUp() {
		quotationsController = new QuotationsController();
		quote = new Quote();
		quote.setQuote("TestQuote1");
    }
	@Test 
    public void shouldReturnQuoteInString_whenCallGetQuoteContent() {
		String expected = "TestQuote1";
        assertEquals(expected, quotationsController.getQuoteContent(quote));
        
    }
}

package ua.home.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuotationsTest {

	@Test
	public void testRandomQuote() {
		
		boolean actual = true;
		boolean expected = true;
		String randomQuote = new Quotations().randomQuote();
		String randomQuote1 = new Quotations().randomQuote();
		String randomQuote2 = new Quotations().randomQuote();
		if(randomQuote.equals(randomQuote1) && randomQuote.equals(randomQuote2)){
			actual = false;
		}
		assertEquals(actual, expected);
	}
}

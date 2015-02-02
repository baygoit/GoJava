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
		String randomQuote3 = new Quotations().randomQuote();
		if (randomQuote.equals(randomQuote1) && randomQuote.equals(randomQuote2) && randomQuote2.equals(randomQuote3)) {
			actual = false;
		}
		if (randomQuote.length() < 1) {
			actual = false;
		}
		assertEquals(actual, expected);
	}
}

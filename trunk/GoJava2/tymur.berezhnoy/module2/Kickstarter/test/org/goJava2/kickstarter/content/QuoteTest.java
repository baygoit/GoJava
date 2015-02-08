package org.goJava2.kickstarter.content;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteTest {

	private Quote quote;
	
	@Test
	public void shouldBeCorrectAddCopyrightSymbol() {
		quote = new Quote("New quote", "Donald Trump");
		char copyrightSymbol = 169;
		assertEquals("\"New quote\"" + copyrightSymbol + " Donald Trump", quote.getQuoteContent());
	}
}
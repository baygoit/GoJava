package org.goJava2.kickstarter.content;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteTest {

	private Quote quote;
	
	@Test
	public void shouldBeCorrectAddCopyrightSymbol() {
		String quoteContent = "New quote";
		String author = "Donald Trump";
		char copyrightSymbol = 169;
		quote = new Quote(quoteContent, author);
		assertEquals("\"" + quoteContent + "\"" + copyrightSymbol + " " + author,
					quote.getQuoteContent());
	}
}
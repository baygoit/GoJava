package com.gojava2.kickstarter.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConsoleViewTest {

	private Quote quote;
	
	@Test
	public void shouldBeCorrectAddCopyrightSymbol() {
		String quoteContent = "New quote";
		String author = "Donald Trump";
		char copyrightSymbol = 169;
		quote = new Quote(quoteContent, author);
		StringBuilder builder = new StringBuilder();
        builder.append("\"").append(quote.getContent()).append("\"")
                .append(quote.getCopyrightSymbol()).append(" ").append(quote.getAuthor());
		assertEquals("\"" + quoteContent + "\"" + copyrightSymbol + " " + author,
					builder.toString());
	}
}
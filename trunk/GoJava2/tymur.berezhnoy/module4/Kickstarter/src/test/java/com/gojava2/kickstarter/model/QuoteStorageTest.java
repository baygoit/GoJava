package com.gojava2.kickstarter.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public abstract class QuoteStorageTest {

	private QuoteStorage storage;
	
	@Before
	public void setUp() {
		storage = getStorage();
	}
	
	abstract QuoteStorage getStorage();
	
	@Test
	public void shouldEmptyTable_WhenNoQuote() {
		// given
		// when 
		int actual = storage.getSize();
		int expected = 0;
		
		//then
		assertEquals(expected, actual);
	}
	
	@Ignore
	@Test
	public void shouldGenerateRandomQuote() {
		// given
		Quote quote1 = new Quote("quote1", "author1");
		Quote quote2 = new Quote("quote2", "author2");
		storage.add(quote1);
		storage.add(quote2);
		
		// when
		Quote resultQuote1 = storage.getRandomQuote();
		StringBuilder quoteBuilder1 = new StringBuilder();
		quoteBuilder1.append(resultQuote1.getContent()).append(resultQuote1.getCopyrightSymbol()).append(resultQuote1.getAuthor());
		
		// then
		assertEquals("quote1©author1", quoteBuilder1.toString());

		// when 
		Quote resultQuote2 = storage.getRandomQuote();
		StringBuilder quoteBuilder2 = new StringBuilder();
		quoteBuilder2.append(resultQuote2.getContent()).append(resultQuote2.getCopyrightSymbol()).append(resultQuote2.getAuthor());
		
		// then
		assertEquals("quote2©author2", quoteBuilder2.toString());
	}
}
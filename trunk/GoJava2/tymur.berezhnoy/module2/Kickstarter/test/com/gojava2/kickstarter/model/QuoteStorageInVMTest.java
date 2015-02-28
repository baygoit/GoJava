package com.gojava2.kickstarter.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteStorageInVMTest {

	private QuoteStorageInVM storageInVM;
	
	@Before
	public void setUp() {
		storageInVM = new QuoteStorageInVM();
	}
	
	@Test
	public void test() {
		// given
		
		// when
		Quote quote1 = new Quote("quote1", "author1");
		Quote quote2 = new Quote("quote2", "author2");
		Quote quote3 = new Quote("quote3", "author3");
		Quote quote4 = new Quote("quote4", "author4");
		
		storageInVM.addQuote(quote1);
		storageInVM.addQuote(quote2);
		storageInVM.addQuote(quote3);
		storageInVM.addQuote(quote4);
		
		Quote result = storageInVM.getRandomQuote();
		StringBuilder builder = new StringBuilder();
		builder.append(result.getContent()).append(result.getCopyrightSymbol()).append(result.getAuthor());
		
		// then
		assertEquals("", builder);
	}
}
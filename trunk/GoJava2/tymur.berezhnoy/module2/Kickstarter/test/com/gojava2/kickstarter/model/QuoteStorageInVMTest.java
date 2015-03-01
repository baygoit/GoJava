package com.gojava2.kickstarter.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuoteStorageInVMTest {

	class FakeRandom extends Random {
		private List<Integer> numbers;

		public FakeRandom(Integer... numbers) {
			this.numbers = new LinkedList(Arrays.asList(numbers));  
		}
		
		@Override
		public int nextInt(int i) { 
			return numbers.remove(0);
		}
	}
	
	@Test
	public void shouldGenerateNewQUote() {
		// given
		QuoteStorageInVM storageInVM = new QuoteStorageInVM(new FakeRandom(0, 1)); 
		
		// when
		Quote quote1 = new Quote("quote1", "author1");
		storageInVM.addQuote(quote1);
		Quote resultQuote1 = storageInVM.getRandomQuote();
		StringBuilder quoteBuilder1 = new StringBuilder();
		quoteBuilder1.append(resultQuote1.getContent()).append(resultQuote1.getCopyrightSymbol()).append(resultQuote1.getAuthor());
		
		// then
		assertEquals("quote1©author1", quoteBuilder1.toString());
		
		// when 
		Quote quote2 = new Quote("quote2", "author2");
		storageInVM.addQuote(quote2);
		Quote resultQuote2 = storageInVM.getRandomQuote();
		StringBuilder quoteBuilder2 = new StringBuilder();
		quoteBuilder2.append(resultQuote2.getContent()).append(resultQuote2.getCopyrightSymbol()).append(resultQuote2.getAuthor());
		
		// then
		assertEquals("quote2©author2", quoteBuilder2.toString());
	} 
}
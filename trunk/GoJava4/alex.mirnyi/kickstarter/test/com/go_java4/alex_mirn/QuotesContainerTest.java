package com.go_java4.alex_mirn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.EntityContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;

public class QuotesContainerTest extends EntityContainer<Quote>{
	
//	public class FakeRandom extends Random {
//		private List<Integer> numbers;
//
//		public FakeRandom(Integer... numbers) {
//			this.numbers = new LinkedList(Arrays.asList(numbers));
//		}
//		
//		@Override
//		public int nextInt() {
//			return numbers.remove(0);
//		}
//	}
//	
//	@Test
//	public void shouldGenerateNewQuote() {
//		QuotesContainer list = new QuotesContainer(new FakeRandom(0, 1));
//		Quote quote1 = new Quote(1, "Name1");
//		Quote quote2 = new Quote(2, "Name2");
//		
//		list.add(quote1); 
//		list.add(quote2); 
//		
//		Quote quote = list.getRandom();
//		assertEquals("Name1", quote.toString());
//		quote = list.getRandom();
//		assertEquals("Name2", quote.toString());
//	}
	
	@Test
	public void shouldQuoteToStering_whenCallToString() {
		Quote quote = new Quote(1, "Name1");
			
		assertEquals("Name1", quote.toString());
	}
	
	@Test
	public void shouldEmptyQuotesList_whenCreate() {
		QuotesContainer list = new QuotesContainer();
			
		assertEquals("[]", list.getData().toString());
	}
	
	@Test
	public void shouldReturnSizeOfContainer_whenAskForIt() {
		QuotesContainer list = new QuotesContainer();
		
		assertEquals(0, list.size());
		
		Quote quote1 = new Quote(1, "Name1");
		Quote quote2 = new Quote(2, "Name2");
		Quote quote3 = new Quote(3, "Name3");
		
		list.add(quote1); 
		list.add(quote2); 
		list.add(quote3); 
		
		assertEquals(3, list.size());
	}
	
	@Test
	public void shouldGetQuoteByIndex_whenAddQuoteToList() {
		QuotesContainer list = new QuotesContainer();
		
		Quote category1 = new Quote(1, "Name1");
		Quote category2 = new Quote(2, "Name2");
		
		
		
		list.add(category1); 
		list.add(category2); 
		
		assertSame(category1, list.get(0));
		assertEquals(category2, list.get(1));
	}
	
//	public Quote getRandom() {
//		int randomIndex = getRandomIndex();
//		return (Quote)data.get(randomIndex);
//	}
//
//	private int getRandomIndex() {
//		return new Random().nextInt(size());
//	}
}

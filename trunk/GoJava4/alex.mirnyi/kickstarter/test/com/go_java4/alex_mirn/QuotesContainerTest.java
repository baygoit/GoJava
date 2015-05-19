package com.go_java4.alex_mirn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.go_java4.alex_mirn.data.Quote;
//import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;

public class QuotesContainerTest {
	
//	@Test
//	public void shouldEmptyCategoriesList_whenCreate() {
//		QuotesContainer list = new QuotesContainer();
//			
//		
//		assertEquals("[]", list.getQuotes().toString());
//	}
//	
	@Test
	public void shouldAddQuote_whenAddQuoteToList() {
		QuotesContainer list = new QuotesContainer();
		
		Quote quote1 = new Quote("first");
		Quote quote2 = new Quote("second");
		
		list.add(quote1); 
		list.add(quote2); 
		
		assertEquals("first", list.get(0).toString());
		assertEquals("second", list.get(1).toString());
	}
//	
//	@Test
//	public void shouldGetQuoteByIndex_whenAddQuoteToList() {
//		CategoriesContainer list = new CategoriesContainer();
//		
//		Quote Quote1 = new Quote("Name1");
//		Quote Quote2 = new Quote("Name1");
//		
//		list.add(Quote1); 
//		list.add(Quote2); 
//		
//		assertSame(Quote1, list.get(0));
//		assertEquals(Quote2, list.get(1));
//	}
//	
	@Test
	public void shouldReturnSizeOfContainer_whenAskForIt() {
		QuotesContainer list = new QuotesContainer();
		
		assertEquals(0, list.size());
		
		Quote quote1 = new Quote("Name1");
		Quote quote2 = new Quote("Name2");
		Quote quote3 = new Quote("Name3");
		
		list.add(quote1); 
		list.add(quote2); 
		list.add(quote3); 
		
		assertEquals(3, list.size());
	}
}

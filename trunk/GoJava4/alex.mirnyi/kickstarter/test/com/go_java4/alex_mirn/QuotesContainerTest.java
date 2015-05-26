package com.go_java4.alex_mirn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.Random;

import org.junit.Test;

import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;

public class QuotesContainerTest {
	
	
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

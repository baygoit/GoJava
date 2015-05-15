package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuotesTest {

	private Quotes quotes;
	
	@Before
	public void setup(){
		quotes = new QuotesContainer("Let force be with you", "An apple a day keeps doctors away");
	}
	
	@Test
	public void testQuotesCreated() {
		assertNotNull(quotes);
	}
	
	@Test
	public void testQuotesSize(){
		assertEquals(2, quotes.getSize());
	}
	
	@Test
	public void testAddQuotes(){
		quotes.add("Quote number three");
		quotes.add("Quote number four");
		quotes.add("Quote number five");
		quotes.add("Quote number six");
		quotes.add("Quote number seven");
		assertEquals(7, quotes.getSize());
	}
	
	@Test(expected = Quotes.IllegalArgumentException.class)
	public void testNullCannotBeAddedToQuotes(){
		quotes.add(null);
	}
	
	@Test(expected = Quotes.IllegalArgumentException.class)
	public void testNegativeNumbersCannotBeIndexesToGetQuotes(){
		quotes.get(-2);
	}
	
	@Test
	public void testGetRandomQuote(){
		quotes.add("Quote number three");
		String randomQuote = quotes.getRandomQuote();
		assertNotNull(randomQuote);
		System.out.println(randomQuote);
	}
	
	@Test
	public void testDaleteQuotes(){
		quotes.add("Quote number three");
		int index = 2;
		quotes.delete(index);
		assertEquals(quotes.getSize(), 2);						
	}
	
	@Test(expected = Quotes.IllegalArgumentException.class)
	public void testNegativeArgumentsCannotBeIndexesToDeleteQuotes(){
		quotes.delete(-1);
	}
	
	@Test
	public void testWhatIsSecondQuote(){
		quotes.add("Quote number three");
		assertEquals(quotes.get(1), "An apple a day keeps doctors away");
		
	}

}

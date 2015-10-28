package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

import com.sergiisavin.kickstarter.quote.container.Quotes;
import com.sergiisavin.kickstarter.quote.container.memory.QuotesContainer;

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
		try {
			quotes.add("Quote number three");
			quotes.add("Quote number four");
			quotes.add("Quote number five");
			quotes.add("Quote number six");
			quotes.add("Quote number seven");
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(7, quotes.getSize());
	}
	
	@Test(expected = Quotes.IllegalArgumentException.class)
	public void testNullCannotBeAddedToQuotes(){
		try {
			quotes.add(null);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected = Quotes.IllegalArgumentException.class)
	public void testNegativeNumbersCannotBeIndexesToGetQuotes(){
		quotes.get(-2);
	}
	
	@Test
	public void testGetRandomQuote(){
		try {
			quotes.add("Quote number three");
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String randomQuote = quotes.getRandomQuote();
		assertNotNull(randomQuote);
		System.out.println(randomQuote);
	}
	
	@Test
	public void testDaleteQuotes(){
		try {
			quotes.add("Quote number three");
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 2;
		try {
			quotes.delete(index);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(quotes.getSize(), 2);						
	}
	
	@Test(expected = Quotes.IllegalArgumentException.class)
	public void testNegativeArgumentsCannotBeIndexesToDeleteQuotes(){
		try {
			quotes.delete(-1);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testWhatIsSecondQuote(){
		try {
			quotes.add("Quote number three");
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(quotes.get(1), "An apple a day keeps doctors away");
		
	}

}

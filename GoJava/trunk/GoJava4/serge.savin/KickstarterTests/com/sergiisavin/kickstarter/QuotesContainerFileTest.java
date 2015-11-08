package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sergiisavin.kickstarter.quote.container.file.QuotesContainerFile;

public class QuotesContainerFileTest {

	QuotesContainerFile quotes;
	
	@Before
	public void test() {
		quotes = new QuotesContainerFile();
	}
	
	@Test
	public void getSize(){
		int size = quotes.getSize();
		assertEquals(3, size);		
	}

	@Test(expected = OperationNotSupportedException.class)
	public void addThrowsException() throws OperationNotSupportedException{
				quotes.add("Quote");
	}
	
	@Test
	public void getQuote(){
		String quote = quotes.get(2);
		System.out.println(quote);
	}
	
	@Ignore
	@Test
	public void creatingAndFillingTheQuotesFile(){
		quotes = new QuotesContainerFile("My Quote 1", "My Quote 2", "MyQuote 3");
		String quote = quotes.get(2);
		System.out.println(quote);
	}
	
	@Test
	public void getRandomQuote(){
		String quote = quotes.getRandomQuote();
		System.out.println(quote);
	}
}

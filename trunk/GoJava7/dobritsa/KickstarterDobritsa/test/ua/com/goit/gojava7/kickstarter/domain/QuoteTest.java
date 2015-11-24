package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class QuoteTest extends Assert{
	
	private Quote quote = new Quote("TestText", "TestAuthor");	

	@Test
	public void testGetText() {		
		assertThat(quote.getText(), is("TestText"));
	}
	
	@Test
	public void testGetAuthor() {		
		assertThat(quote.getAuthor(), is("TestAuthor"));
	}	
}

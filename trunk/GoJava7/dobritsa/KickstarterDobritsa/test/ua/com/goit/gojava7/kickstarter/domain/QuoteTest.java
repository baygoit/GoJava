package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class QuoteTest extends Assert{
	
	private Quote quote = new Quote("TestText", "TestAuthor");
	private Quote quote1 = new Quote();

	@Test
	public void testGetText() {		
		assertThat(quote.getText(), is("TestText"));
	}
	
	@Test
	public void testGetAuthor() {		
		assertThat(quote.getAuthor(), is("TestAuthor"));
	}	
	
	@Test
	public void testSetAuthor() {		
		quote1.setAuthor("Author1");
		assertThat(quote1.getAuthor(), is("Author1"));
	}	
	
	@Test
	public void testSetText() {		
		quote1.setText("Text1");
		assertThat(quote1.getText(), is("Text1"));
	}	
	
	
}

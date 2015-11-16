package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteTest {
	private Quote quote;
	
	@Before 
	public void setUp(){
		quote = new Quote("sdsds", "aut");
	}
	
	@Test
	public void testCategoryAndGetName() {
		assertThat(quote.getText(), is("sdsds"));
	}

	@Test
	public void testCategoryAndgetAuthor() {
		assertThat(quote.getAuthor(), is("aut"));
	}

}

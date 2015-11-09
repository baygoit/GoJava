package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteTest {

	@Test
	public void testCategoryAndGetName() {
		Quote quote = new Quote("sdsds", "aut");
		assertThat(quote.getText(), is("sdsds"));
	}
	
	@Test
	public void testCategoryAndgetAuthor() {
		Quote quote = new Quote("sdsds", "aut");
		assertThat(quote.getAuthor(), is("aut"));
	}
	
}

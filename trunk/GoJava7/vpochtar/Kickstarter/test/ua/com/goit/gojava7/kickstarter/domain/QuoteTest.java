package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class QuoteTest {

	Quote quote = new Quote("Quote", "Author");
	
	@Test
	public void testConstructor() {
		assertThat(quote.getText(), is("Quote"));
		assertThat(quote.getAuthor(), is("Author"));
	}
}

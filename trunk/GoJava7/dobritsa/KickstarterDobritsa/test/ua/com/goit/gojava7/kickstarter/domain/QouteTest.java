package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QouteTest {
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

package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteTest {
	private Quote quote = new Quote();
	@Before
	public void init() {
		quote.setName("Q");
	}
	@Test
	public void testGetName() {
		assertThat(quote.getName(), is("Q"));
	}
}

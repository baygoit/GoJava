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
		quote.setId(1);
	}
	@Test
	public void testGetName() {
		assertThat(quote.getName(), is("Q"));
	}
	@Test
	public void testGetId() {
		assertThat(quote.getId(), is(1));
	}
}

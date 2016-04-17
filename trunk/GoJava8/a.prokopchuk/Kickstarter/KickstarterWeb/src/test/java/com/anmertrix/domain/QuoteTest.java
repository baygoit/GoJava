package com.anmertrix.domain;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import com.anmertrix.domain.Quote;

public class QuoteTest {
	
	private Quote quote = new Quote();
	
	@Test
    public void quoteTest() {
        assertThat((quote != null), is(true));
    }

	@Test
	public void getSetQuoteTest() {
		quote.setId(3);
		quote.setAuthor("author");
		quote.setText("test");
		assertThat(quote.getId(), is(3));
		assertThat(quote.getText(), is("test"));
		assertThat(quote.getAuthor(), is("author"));
	}
	
}
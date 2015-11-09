package com.kickstarter.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


import com.kickstarter.Printer;
import com.kickstarter.storages.QuteHolder;

public class QuoteHolderTest {

	
	Printer p = new Printer();
	QuteHolder qh = new QuteHolder();
	
	@Test
	public void getQuoteTest() {
       assertThat(qh.getQuote(), is(qh.getQuotes().get((int) (Math.random() * qh.getQuotes().size()))));
		

	}
}

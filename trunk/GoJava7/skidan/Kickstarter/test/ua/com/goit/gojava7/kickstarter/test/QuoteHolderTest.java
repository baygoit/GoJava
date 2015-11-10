package ua.com.goit.gojava7.kickstarter.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.Printer;
import ua.com.goit.gojava7.kickstarter.storage.QuteHolder;



public class QuoteHolderTest {

	
	Printer p = new Printer();
	QuteHolder qh = new QuteHolder();
	
	@Test
	public void getQuoteTest() {
       assertThat(qh.getQuote(), is(qh.getQuotes().get((int) (Math.random() * qh.getQuotes().size()))));
		

	}
}

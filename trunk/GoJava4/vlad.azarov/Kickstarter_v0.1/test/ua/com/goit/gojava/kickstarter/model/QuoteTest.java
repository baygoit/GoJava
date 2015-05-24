package ua.com.goit.gojava.kickstarter.model;

import org.junit.Test;

public class QuoteTest {

    Quote quote = new Quote("Some inspiring text", "Batman");

    @Test
    public void Test() {
	quote.getQuote();
    }

}

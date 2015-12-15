package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class QuoteTest{
    private final String text = "test";
    private final String author = "author";
    Quote quote;
    @Test
    public void testQuote() {
        quote = new Quote();
        assertThat((quote != null),is(true));
    }

    @Test
    public void testQuoteStringString() {
   
    quote = new Quote(text, author);
    assertThat(quote.getAuthor(), is(author));
    assertThat(quote.getText(),is(text));
    }

    @Test
    public void testSetText() {
       quote = new Quote();
       quote.setText(text);
       assertThat(quote.getText(), is(text));
    }

    @Test
    public void testSetAuthor() {
        quote = new Quote();
        quote.setAuthor(author);
        assertThat(quote.getAuthor(), is(author));
    }

}

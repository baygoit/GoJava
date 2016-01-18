package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuoteTest {
    @Test
    public void test() {
        String author = "author1";
        String text = "text1";
        Quote quote = new Quote(text, author);
        assertThat(quote.getAuthor(), is(author));
        assertThat(quote.getText(), is(text));
    }
}
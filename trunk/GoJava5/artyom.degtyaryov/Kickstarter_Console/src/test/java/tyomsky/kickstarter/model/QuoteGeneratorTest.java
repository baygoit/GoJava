package tyomsky.kickstarter.model;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class QuoteGeneratorTest {

    @Test
    public void shouldReturnNotNull() {
        QuoteGenerator quoteGenerator = new QuoteGenerator(new Random());
        String quote = quoteGenerator.getQuote();
        assertNotNull(quote);
    }

    @Test
    public void shouldReturnNotEmptyString() {
        QuoteGenerator quoteGenerator = new QuoteGenerator(new Random());
        String quote = quoteGenerator.getQuote();
        assertTrue(!quote.isEmpty());
    }

}
package ua.com.goit.gojava.kickstarter.model;

import org.junit.Test;

public class QuotesRepositoryTest {

    QuotesRepository quotesRepository = new QuotesRepository();
    Quote quote = new Quote("Some inspiration quote", "(c) SpiderMan");

    @Test
    public void addQuoteToRepositoryTest() {
	quotesRepository.add(quote);
    }

    @Test
    public void getRandomQuoteTest() {
	quotesRepository.getRandomQuote();
    }
}

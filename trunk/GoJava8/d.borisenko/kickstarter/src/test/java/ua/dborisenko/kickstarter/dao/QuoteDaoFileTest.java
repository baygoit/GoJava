package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoFileTest {
    private static QuoteDaoFile quoteDao = new QuoteDaoFile();
    private String quotesFileName = "./src/test/resources/quotes.txt";
    private String quotesWrongFileName = "./src/test/resources/quotes_wrongformat.txt";
    
    @Test
    public void fillQuotesTest() {
        quoteDao.setQuotesFileName(quotesFileName);
        quoteDao.fillQuotes();
        Quote quote = quoteDao.getRandomQuote();
        assertThat(quote.getText(), is("Quote"));
        assertThat(quote.getAuthor(), is("Author"));
    }
    
    @Test(expected = IllegalStateException.class)
    public void fillQuotesWrongFileTest() {
        quoteDao.setQuotesFileName(quotesWrongFileName);
        quoteDao.fillQuotes();
    }
}

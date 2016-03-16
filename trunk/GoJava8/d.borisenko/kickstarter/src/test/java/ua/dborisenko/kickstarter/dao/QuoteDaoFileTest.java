package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoFileTest {

    private String quotesFileName = "./src/test/resources/quotes.txt";
    private QuoteDaoFile quoteDao = new QuoteDaoFile();
    
    @Ignore
    @Test
    public void testFillAllQuotes() {
        quoteDao.setQuotesFileName(quotesFileName);
        //quoteDao.fillQuotes();
        Quote quote = quoteDao.getRandomQuote();

        assertThat(quote.getText(), is("Quote"));
        assertThat(quote.getAuthor(), is("Author"));
    }

}

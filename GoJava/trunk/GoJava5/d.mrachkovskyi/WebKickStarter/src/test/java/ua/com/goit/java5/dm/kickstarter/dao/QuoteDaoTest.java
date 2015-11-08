package ua.com.goit.java5.dm.kickstarter.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import ua.com.goit.java5.dm.kickstarter.model.Quote;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuoteDaoTest {

    @Test
    public void whenGetQuoteThenReturnNotNull() {
        QuoteDao quoteDao = new QuoteDao();
        List<Quote> quotes = createQuotes();
        quoteDao.setQuotes(quotes);

        Quote quote = quoteDao.getQuote();

        assertNotNull("Quote must not be null", quote);
        assertNotNull("Quote text must not be null", quote.getQuote());
        assertNotNull("Quote author must not be null", quote.getQuote());
    }

    @Test
    public void whenGetQuoteThenReturnNotEmptyQuote() {
        QuoteDao quoteDao = new QuoteDao();
        List<Quote> quotes = createQuotes();
        quoteDao.setQuotes(quotes);

        Quote quote = quoteDao.getQuote();

        assertTrue("Quote text must not be empty", StringUtils.isNotBlank(quote.getQuote()));
        assertTrue("Quote author must not be empty", StringUtils.isNotBlank(quote.getAuthor()));
    }

    @Test
    public void whenGetQuoteThenReturnQuote() {
        QuoteDao quoteDao = new QuoteDao();
        List<Quote> quotes = createQuotes();
        quoteDao.setQuotes(quotes);
        Set<Quote> expectedSet = new HashSet<>(quotes);

        Quote quote = quoteDao.getQuote();

        assertTrue("Quote must be one from the quotes list", expectedSet.contains(quote));
    }

    @Test(expected = IllegalStateException.class)
    public void whenNoQuotesThenThrowException() {
        QuoteDao quoteDao = new QuoteDao();
        quoteDao.getQuote();

    }

    private List<Quote> createQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("If you want to achieve greatness stop asking for permission.", "Anonymous"));
        quotes.add(new Quote("Things work out best for those who make the best of how things work out.", "John Wooden"));
        quotes.add(new Quote("To live a creative life, we must lose our fear of being wrong.", "Anonymous"));
        quotes.add(new Quote("If you are not willing to risk the usual you will have to settle for the ordinary.", "Jim Rohn"));
        quotes.add(new Quote("ITrust because you are willing to accept the risk, not because it's safe or certain.", "Anonymous"));
        return quotes;
    }

}


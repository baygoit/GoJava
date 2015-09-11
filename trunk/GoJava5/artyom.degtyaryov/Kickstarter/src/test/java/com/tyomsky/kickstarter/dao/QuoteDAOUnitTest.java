package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.domain.Quote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:spring-test-config/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteDAOUnitTest {

    @Autowired
    QuoteDAO quoteDAO;

    @Test
    @Transactional
    @Rollback
    public void testSave() {
        Quote quote = new Quote("some quote");
        quoteDAO.save(quote);
        List<Quote> quotes = quoteDAO.getAll();
        assertEquals(quote.getPresentation(), quotes.get(0).getPresentation());
    }

    @Test
    @Transactional
    @Rollback
    public void testGet() {
        Quote quote = new Quote("some quote");
        quoteDAO.save(quote);
        Quote actualQuote = quoteDAO.get(quote.getId());
        assertEquals(quote.getPresentation(), actualQuote.getPresentation());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetAll() {
        Quote quote1 = new Quote("quote1");
        Quote quote2 = new Quote("quote2");

        quoteDAO.save(quote1);
        quoteDAO.save(quote2);

        List<Quote> actualQuotes = quoteDAO.getAll();

        assertTrue(actualQuotes.contains(quote1));
        assertTrue(actualQuotes.contains(quote2));

    }

    @Test
    @Transactional
    @Rollback
    public void testCount() {

        long count = quoteDAO.getCount();
        assertEquals(0, count);

        Quote quote = new Quote("quote");
        quoteDAO.save(quote);

        count = quoteDAO.getCount();
        assertEquals(1, count);

        Quote quote1 = new Quote("quote1");
        quoteDAO.save(quote1);

        count = quoteDAO.getCount();
        assertEquals(2, count);
    }

}
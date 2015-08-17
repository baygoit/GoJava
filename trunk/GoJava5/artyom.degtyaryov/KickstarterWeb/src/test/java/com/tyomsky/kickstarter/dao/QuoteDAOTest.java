package com.tyomsky.kickstarter.dao;

import org.junit.Before;
import org.junit.Test;

public abstract class QuoteDAOTest {

    private QuoteDAO quoteDAO;

    @Before
    public void setUp() throws Exception {
        quoteDAO = getQuoteDAOImplementation();
    }

    protected abstract QuoteDAO getQuoteDAOImplementation();

    @Test
    public void testGetQuote() throws Exception {
        String quote = quoteDAO.get(0);
    }
}
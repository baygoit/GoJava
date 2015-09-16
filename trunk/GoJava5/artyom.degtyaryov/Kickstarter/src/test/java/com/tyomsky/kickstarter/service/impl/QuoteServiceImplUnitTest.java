package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.QuoteDAO;
import com.tyomsky.kickstarter.domain.Quote;
import com.tyomsky.kickstarter.service.impl.QuoteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuoteServiceImplUnitTest {

    @Mock
    QuoteDAO quoteDAO;

    @InjectMocks
    QuoteServiceImpl quoteService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getSomeQuote() {
        Quote randomQuote = new Quote("some random quote");
        when(quoteDAO.getRandom()).thenReturn(randomQuote);
        Quote actualQuote = quoteService.getRandomQuote();
        verify(quoteDAO, times(1)).getRandom();
        assertEquals(randomQuote, actualQuote);
    }

}
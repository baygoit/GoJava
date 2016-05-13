package ua.dborisenko.kickstarter.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.dborisenko.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoTest {
    @Mock
    private EntityManager em;
    @Mock
    private TypedQuery<Quote> query;
    @InjectMocks
    private QuoteDao quoteDao;

    @Test
    public void getRandomTest() {
        when(em.createNamedQuery("Quote.getRandom", Quote.class)).thenReturn(query);
        quoteDao.getRandom();
        verify(em).createNamedQuery("Quote.getRandom", Quote.class);
        verify(query).getSingleResult();
    }
}

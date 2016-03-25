package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.KickStarter;
import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.domain.Quote;
import com.sandarovich.kickstarter.io.ConsoleIO;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class QuoteDaoMemoryTest {

    @Test
    public void testGetQuotaInListByIndex() {
        QuoteDaoMemoryImpl qr = new QuoteDaoMemoryImpl();
        qr.fillQuotas();
        Quote quote = new Quote("Mr SS", "No pain, no gain");
        assertThat("Quote test", qr.getQuotaById(1).toString(), is(quote.toString()));
    }

    @Test
    public void testWrongQuotaIndex() {
        QuoteDaoMemoryImpl qr = new QuoteDaoMemoryImpl();
        qr.fillQuotas();
        Quote quote = new Quote("Mr SS", "Every big journey begins with a small step");
        assertThat("Wrong Quote index test", qr.getQuotaById(7).toString(), is(quote.toString()));
    }

    @Test
    @Ignore
    public void testRandomQuota() {
        //given
        QuoteDaoMemoryImpl qr = mock(QuoteDaoMemoryImpl.class);
        qr.fillQuotas();
        when(qr.getRandomQuota()).thenReturn(new Quote("z", "z"));
        //when
        new KickStarter(new ConsoleIO(), DaoMode.MEMORY).run();

        //then
        assertThat("Quote test", qr.getRandomQuota(), is(new Quote("z", "z")));
    }

}

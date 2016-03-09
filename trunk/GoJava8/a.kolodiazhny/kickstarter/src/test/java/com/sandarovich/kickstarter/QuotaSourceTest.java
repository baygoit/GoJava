package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.ConsoleIO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class QuotaSourceTest {

    @Test
    public void testGetQuotaInListByIndex() {
        QuotaSource qr = new QuotaSource();
        qr.init();
        Quota quota = new Quota("Mr Y", "No pain, no gain");
        assertThat("Quota test", qr.getQuota(1), is(quota.toString()));
    }

    @Test
    public void testWrongQuotaIndex() {
        QuotaSource qr = new QuotaSource();
        qr.init();
        Quota quota = new Quota("Mr X", "Every big journey begins with a small step");
        assertThat("Wrong Quota index test", qr.getQuota(7), is(quota.toString()));
    }

    @Test
    public void testRandomQuota() {
        //given
        QuotaSource qr = mock(QuotaSource.class);
        qr.init();
        when(qr.getRandomQuota()).thenReturn(("\"No pain, no gain\""));
        //when
        new KickStarter(new ConsoleIO()).showQuote();
        //then
        assertThat("Quota test", qr.getRandomQuota(), is("\"No pain, no gain\""));
    }

}

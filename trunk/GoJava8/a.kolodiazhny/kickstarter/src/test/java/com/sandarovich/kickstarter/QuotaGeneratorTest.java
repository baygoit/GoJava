package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.ConsoleIO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class QuotaGeneratorTest {

    @Test
    public void testGetQuotaInListByIndex() {
        QuotaGenerator qr = new QuotaGenerator();
        Quota quota = new Quota("Mr X", "No pain, no gain");
        assertThat("Quota test", qr.getQuota(1), is(quota.toString()));
    }

    @Test
    public void testWrongQuotaIndex() {
        QuotaGenerator qr = new QuotaGenerator();
        Quota quota = new Quota("Mr X", "Every big journey begins with a small step");
        assertThat("Wrong Quota index test", qr.getQuota(7), is(quota.toString()));
    }

    @Test
    public void testRandomQuota() {
        //given
        QuotaGenerator qr = mock(QuotaGenerator.class);
        when(qr.getQuota()).thenReturn(("\"No pain, no gain\""));
        //when
        new Intro(new ConsoleIO()).showQuote();
        //then
        assertThat("Quota test", qr.getQuota(), is("\"No pain, no gain\""));
    }

}

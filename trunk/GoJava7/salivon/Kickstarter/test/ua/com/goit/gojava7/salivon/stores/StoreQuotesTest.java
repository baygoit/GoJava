package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.context.Console;

public class StoreQuotesTest {

    StoreQuotes instance;

    @Before
    public void setUp() {
        instance = new StoreQuotes();
    }

    @Test
    public void testGetQuotes() {
        List<Quote> result = instance.getQuotes();
        assertNotNull(result);

    }

    @Test
    public void testSetQuotes() {
        List<Quote> quotes = new ArrayList<>();
        instance.setQuotes(quotes);
        assertEquals(quotes, instance.getQuotes());
    }

}

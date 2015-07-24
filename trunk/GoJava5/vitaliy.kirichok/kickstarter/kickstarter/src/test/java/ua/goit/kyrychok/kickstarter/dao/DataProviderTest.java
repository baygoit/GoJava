package ua.goit.kyrychok.kickstarter.dao;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DataProviderTest {

    @Test
    public void whenGetMsgThenReturnNotEmpty() throws Exception {
        DataProvider dataProvider = MemoryDataProvider.getInstance();

        String result = dataProvider.getWelcomeMessage();

        assertNotNull("Hello message must be not null", result);
        assertTrue("Hello message must be not empty", result.trim().length() > 0);
    }

}
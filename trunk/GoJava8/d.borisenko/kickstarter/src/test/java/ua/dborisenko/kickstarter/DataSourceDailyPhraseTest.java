package ua.dborisenko.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataSourceDailyPhraseTest {

    @Before
    public void preparePhraseDataSource() {
        DataSource.fillAllDailyPhrases();
    }
    
    @Test
    public void getRandomOneTestIsSomething() {
        assertFalse(DataSourceDailyPhrase.getRandomOne().equals(""));
    }
    
    @Test
    public void getRandomOneTestIsRandom() {
        String firstPhrase = DataSourceDailyPhrase.getRandomOne();
        boolean isRandom = false;
        for (int i = 0; i < 1000; i++) {
            String anotherPhrase = DataSourceDailyPhrase.getRandomOne();
            if (!firstPhrase.equals(anotherPhrase)) {
                isRandom = true;
                break;
            }
        }
        assertTrue(isRandom);
    }

}

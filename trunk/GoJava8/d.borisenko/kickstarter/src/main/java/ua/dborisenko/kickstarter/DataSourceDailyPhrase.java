package ua.dborisenko.kickstarter;

import java.util.Random;

public class DataSourceDailyPhrase {

    public static String getRandomOne() {
        Random random = new Random();
        int phraseId = random.nextInt(DataSource.allDailyPhrases.size());
        String phrase = DataSource.allDailyPhrases.get(phraseId);
        return phrase;
    }

}

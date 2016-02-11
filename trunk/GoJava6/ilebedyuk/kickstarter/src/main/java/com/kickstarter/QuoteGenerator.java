package com.kickstarter;

import java.util.Random;

/**
 * Created by Игорь on 05.02.2016.
 */
public class QuoteGenerator {
    public String nextQuote() {
        String[] strings = new String[] {
                "Каждый человек - творческая личность",
                "У тебя получится - стоит только начать",
                "Иногла чтобы закончить требуется помощь",
        };
        int index = new Random().nextInt(strings.length);

        return strings[index];
    }
}

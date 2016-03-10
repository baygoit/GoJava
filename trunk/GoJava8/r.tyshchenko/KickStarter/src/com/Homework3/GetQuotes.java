package com.Homework3;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by roman on 06.03.16.
 */
public class GetQuotes {

    public  void getRandomQuotes() {
        ArrayList<String> quotes = new ArrayList<String>();
        quotes.add("“The best winners are the worst losers.”  ");
        quotes.add("“Everyone is a loser. Winners are just losers with more patience.”  ");
        quotes.add("“Doing the tough things sets winners apart from losers.”");
        quotes.add("“There are no winners in real games.”");
        quotes.add("“As long as we dare dream, we can occupy new land.” ");
        Random randomQuotes = new Random();
        String qot = quotes.get(randomQuotes.nextInt(quotes.size()));
        System.out.println(qot);
    }
}

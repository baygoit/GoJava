package com.Homework3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by roman on 06.03.16.
 */
public class GetQuotes {

    public void getRandomQuotes() {
        ArrayList<String> quotes = new ArrayList<String>();
        quotes.add("“1The best winners are the worst losers.”  ");
        quotes.add("“1Everyone is a loser. Winners are just losers with more patience.”  ");
        quotes.add("“1Doing the tough things sets winners apart from losers.”");
        quotes.add("“1There are no winners in real games.”");
        quotes.add("“1As long as we dare dream, we can occupy new land.” ");
        Random randomQuotes = new Random();
        String qot = quotes.get(randomQuotes.nextInt(quotes.size()));
        System.out.println(qot);
    }

    /*public void quotesWhisFile() {
        BufferedReader reader = null;
        String thisLine = null;
        ArrayList<String> quotesWhisFile = new ArrayList<String>();
        try {

            reader = new BufferedReader(new FileReader("/home/roman/git/GoJava/trunk/GoJava8/r.tyshchenko/KickStarter/src/com/sourses.txt"));
            while ((thisLine = reader.readLine()) != null) {
                quotesWhisFile.add(thisLine);
            }
            Random randomQuotes = new Random();
            String qot = quotesWhisFile.get(randomQuotes.nextInt(quotesWhisFile.size()));
            System.out.println(qot);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }*/
}

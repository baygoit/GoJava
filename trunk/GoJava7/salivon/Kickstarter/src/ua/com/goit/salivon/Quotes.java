/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Оля
 */
public class Quotes {

    private List<String> quotes = new ArrayList<>();
    private List< String> authorQuotes = new ArrayList<>();
    private Random random = new Random();

    {
        quotes.add("Two things are infinite: the universe and human"
                + "stupidity; and I'm not sure about the universe.");
        quotes.add("Be the change that you wish to see in the world.");
        quotes.add("If you tell the truth, you don't have to remember anything.");

        authorQuotes.add("Albert Einstein");
        authorQuotes.add("Mahatma Gandhi");
        authorQuotes.add("Mark Twain");
    }

    public String getQuote() {
        String quote;
        int number = (int) (random.nextDouble() * quotes.size());
        quote = quotes.get(number) + "\n Autor:" + authorQuotes.get(number);
        return quote;
    }

}

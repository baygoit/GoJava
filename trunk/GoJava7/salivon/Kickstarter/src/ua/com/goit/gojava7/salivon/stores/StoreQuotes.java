/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Оля
 */
public class StoreQuotes {

    private static List<String> quotes = new ArrayList<>();
    private static List< String> authorQuotes = new ArrayList<>();
    private static final Random random = new Random();

    static {
        StoreQuotes.quotes.add("Two things are infinite: the universe and human"
                + "stupidity; and I'm not sure about the universe.");
        StoreQuotes.quotes.add("Be the change that you wish to see in the world.");
        StoreQuotes.quotes.add("If you tell the truth, you don't have to remember anything.");

        StoreQuotes.authorQuotes.add("Albert Einstein");
        StoreQuotes.authorQuotes.add("Mahatma Gandhi");
        StoreQuotes.authorQuotes.add("Mark Twain");
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    public List<String> getAuthorQuotes() {
        return authorQuotes;
    }

    public void setAuthorQuotes(List<String> authorQuotes) {
        this.authorQuotes = authorQuotes;
    }

    public static String getQuote() {
        String quote;
        int number = (int) (random.nextDouble() * quotes.size());
        quote = quotes.get(number) + "\n Autor:" + authorQuotes.get(number);
        return quote;
    }

}

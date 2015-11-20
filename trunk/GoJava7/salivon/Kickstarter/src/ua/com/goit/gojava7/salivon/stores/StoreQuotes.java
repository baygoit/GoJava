package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ua.com.goit.gojava7.salivon.beans.Quote;

public class StoreQuotes {

    private static List<Quote> quotes = new ArrayList<>();

    static {
        StoreQuotes.quotes.add(new Quote("Two things are infinite: the universe and human"
                + "stupidity; and I'm not sure about the universe.", "Albert Einstein"));
        StoreQuotes.quotes.add(new Quote("Be the change that you wish to see in the world.",
                "Mahatma Gandhi"));
        StoreQuotes.quotes.add(new Quote("If you tell the truth, you don't have to remember anything.",
                "Mark Twain"));

    }

    public static List<Quote> getQuotes() {
        return quotes;
    }

    public static void setQuotes(List<Quote> quotes) {
        StoreQuotes.quotes = quotes;
    }

}

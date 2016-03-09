package ua.dborisenko.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteDao {

    public static List<Quote> allQuotes = new ArrayList<Quote>();

    public Quote getRandomQuote() {
        Random random = new Random();
        int quoteId = random.nextInt(allQuotes.size());
        return allQuotes.get(quoteId);
    }

    private void addQuote(Quote quote) {
        allQuotes.add(quote);
    }

    public void fillAllQuotes() {
        addQuote(new Quote("The best preparation for tomorrow is doing your best today.", "H. Jackson Brown"));
        addQuote(new Quote("Nothing is impossible, the word itself says 'I'm possible'!", "Audrey Hepburn"));
        addQuote(new Quote("If opportunity doesn't knock, build a door.", "Milton Berle"));
        addQuote(
                new Quote("Put your heart, mind, and soul into even your smallest acts. This is the secret of success.",
                        "Swami Sivananda"));
        addQuote(new Quote("We do what we must because we can. For the good of all of us.", "GLadOS"));
        addQuote(
                new Quote("Success is simple. Do what's right, the right way, at the right time.", "Arnold H. Glasow"));
        addQuote(new Quote("Victory has a thousand fathers, but defeat is an orphan.", "Galeazzo Ciano"));
        addQuote(new Quote("In order to attain the impossible, one must attempt the absurd.", "Miguel de Cervantes"));
    }
}

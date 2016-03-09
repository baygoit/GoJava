package ua.dborisenko.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.dborisenko.kickstarter.Quote;

public class QuoteDaoImpl {

	private List<Quote> quotes = new ArrayList<Quote>();

    public Quote getRandomQuote() {
        Random random = new Random();
		int quoteId = random.nextInt(quotes.size());
		return quotes.get(quoteId);
    }

    public void fillAllQuotes() {
		quotes.add(new Quote("The best preparation for tomorrow is doing your best today.", "H. Jackson Brown"));
		quotes.add(new Quote("Nothing is impossible, the word itself says 'I'm possible'!", "Audrey Hepburn"));
		quotes.add(new Quote("If opportunity doesn't knock, build a door.", "Milton Berle"));
		quotes.add(
                new Quote("Put your heart, mind, and soul into even your smallest acts. This is the secret of success.",
                        "Swami Sivananda"));
		quotes.add(new Quote("We do what we must because we can. For the good of all of us.", "GLadOS"));
		quotes.add(
                new Quote("Success is simple. Do what's right, the right way, at the right time.", "Arnold H. Glasow"));
		quotes.add(new Quote("Victory has a thousand fathers, but defeat is an orphan.", "Galeazzo Ciano"));
		quotes.add(new Quote("In order to attain the impossible, one must attempt the absurd.", "Miguel de Cervantes"));
    }
}

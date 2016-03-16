package ua.dborisenko.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoMemory implements QuoteDao {
    private List<Quote> quotes = new ArrayList<Quote>();
    private static int quoteIdGenerator = 1;

    private int getQuoteId() {
        return (quoteIdGenerator++);
    }

    @Override
    public Quote getRandomQuote() {
        Random random = new Random();
        int quoteNumber = random.nextInt(quotes.size());
        return quotes.get(quoteNumber);
    }

    public void fillQuotes() {
        quotes.add(new Quote(getQuoteId(), "H. Jackson Brown",
                "The best preparation for tomorrow is doing your best today."));
        quotes.add(new Quote(getQuoteId(), "Audrey Hepburn",
                "Nothing is impossible, the word itself says 'I'm possible'!"));
        quotes.add(new Quote(getQuoteId(), "Milton Berle", "If opportunity doesn't knock, build a door."));
        quotes.add(new Quote(getQuoteId(), "Swami Sivananda",
                "Put your heart, mind, and soul into even your smallest acts. This is the secret of success."));
        quotes.add(new Quote(getQuoteId(), "GLadOS", "We do what we must because we can. For the good of all of us."));
        quotes.add(new Quote(getQuoteId(), "Arnold H. Glasow",
                "Success is simple. Do what's right, the right way, at the right time."));
        quotes.add(
                new Quote(getQuoteId(), "Galeazzo Ciano", "Victory has a thousand fathers, but defeat is an orphan."));
        quotes.add(new Quote(getQuoteId(), "Miguel de Cervantes",
                "In order to attain the impossible, one must attempt the absurd."));
    }
}

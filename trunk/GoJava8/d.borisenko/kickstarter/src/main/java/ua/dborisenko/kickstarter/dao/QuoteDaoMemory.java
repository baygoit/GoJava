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

    protected Quote makeQuote(int id, String author, String text) {
        Quote quote = new Quote();
        quote.setId(id);
        quote.setId(getQuoteId());
        quote.setText(text);
        quote.setAuthor(author);
        return quote;
    }

    public void fillQuotes() {
        quotes.add(makeQuote(getQuoteId(), "H. Jackson Brown",
                "The best preparation for tomorrow is doing your best today."));
        quotes.add(makeQuote(getQuoteId(), "Audrey Hepburn",
                "Nothing is impossible, the word itself says 'I'm possible'!"));
        quotes.add(makeQuote(getQuoteId(), "Milton Berle", "If opportunity doesn't knock, build a door."));
        quotes.add(makeQuote(getQuoteId(), "Swami Sivananda",
                "Put your heart, mind, and soul into even your smallest acts. This is the secret of success."));
        quotes.add(makeQuote(getQuoteId(), "GLadOS", "We do what we must because we can. For the good of all of us."));
        quotes.add(makeQuote(getQuoteId(), "Arnold H. Glasow",
                "Success is simple. Do what's right, the right way, at the right time."));
        quotes.add(
                makeQuote(getQuoteId(), "Galeazzo Ciano", "Victory has a thousand fathers, but defeat is an orphan."));
        quotes.add(makeQuote(getQuoteId(), "Miguel de Cervantes",
                "In order to attain the impossible, one must attempt the absurd."));
    }
}

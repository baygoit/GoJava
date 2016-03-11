package ua.dborisenko.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.dborisenko.kickstarter.domain.Quote;

public abstract class QuoteDao {

    protected List<Quote> quotes = new ArrayList<Quote>();

    public Quote getRandomQuote() {
        Random random = new Random();
        int quoteId = random.nextInt(quotes.size());
        return quotes.get(quoteId);
    }

    public abstract void fillQuotes();
}
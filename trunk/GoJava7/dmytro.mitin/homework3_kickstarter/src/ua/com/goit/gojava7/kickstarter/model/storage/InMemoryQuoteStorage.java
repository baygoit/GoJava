package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryQuoteStorage implements QuoteStorage {
    private final List<Quote> quotes;

    public InMemoryQuoteStorage() {
        quotes = new ArrayList<>();

        add(new Quote("Life is 10% what happens to you and 90% how you react to it.",
                "Charles R. Swindoll"));

        add(new Quote("Failure will never overtake me if my determination to succeed is strong enough.",
                "Og Mandino"));

        add(new Quote("What you do today can improve all your tomorrows.",
                "Ralph Marston"));
    }

    @Override
    public List<Quote> getQuotes() {
        return Collections.unmodifiableList(quotes);
    }

    @Override
    public void add(Quote quote) {
        quotes.add(quote);
    }

}

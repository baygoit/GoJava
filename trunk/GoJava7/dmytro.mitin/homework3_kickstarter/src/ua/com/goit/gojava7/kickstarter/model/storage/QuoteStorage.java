package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmytro on 06.11.2015.
 */
public class QuoteStorage {
    private List<Quote> quotes;

    public List<Quote> getQuotes() {
        return Collections.unmodifiableList(quotes);
    }

    public QuoteStorage() {
        quotes = new ArrayList<>();

        Quote quote1 = new Quote("Life is 10% what happens to you and 90% how you react to it.",
                "Charles R. Swindoll");
        add(quote1);

        Quote quote2 = new Quote("Failure will never overtake me if my determination to succeed is strong enough.",
                "Og Mandino");
        add(quote2);

        Quote quote3 = new Quote("What you do today can improve all your tomorrows.",
                "Ralph Marston");
        add(quote3);
    }

    private void add(Quote quote) {
        quotes.add(quote);
    }
}

package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.util.List;

public interface QuoteStorage {
    List<Quote> getQuotes();

    void add(Quote quote);
}

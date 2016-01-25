package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

import java.util.List;

public interface QuoteDao {
    List<Quote> getQuotes();

    void add(Quote quote);
}

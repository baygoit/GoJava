package ua.dborisenko.kickstarter.dao;

import ua.dborisenko.kickstarter.domain.Quote;

public interface QuoteDao {

    public Quote getRandomQuote();

}
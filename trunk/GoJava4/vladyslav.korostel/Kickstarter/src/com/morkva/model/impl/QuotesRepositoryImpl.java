package com.morkva.model.impl;

import com.morkva.entities.Quote;
import com.morkva.model.QuotesRepository;

/**
 * Created by vladyslav on 30.04.15.
 */
public class QuotesRepositoryImpl implements QuotesRepository {

    private Quote[] quotes;

    public QuotesRepositoryImpl(Quote[] quotes) {
        this.quotes = quotes;
    }

    public Quote[] getQuotes() {

        assert quotes.length > 0;
        return quotes;
    }
}

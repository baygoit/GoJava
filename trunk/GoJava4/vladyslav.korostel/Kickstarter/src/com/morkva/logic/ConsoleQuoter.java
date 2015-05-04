package com.morkva.logic;

import com.morkva.entities.Quote;
import com.morkva.model.QuotesRepository;

import java.util.Random;

/**
 * Created by vladyslav on 30.04.15.
 */
public class ConsoleQuoter implements Quoter<String> {

    private QuotesRepository quotesRepository;

    public ConsoleQuoter(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public String quote() {
        Quote[] quotes = quotesRepository.getQuotes();
        return quotes[new Random().nextInt(quotes.length)].toString();
    }
}

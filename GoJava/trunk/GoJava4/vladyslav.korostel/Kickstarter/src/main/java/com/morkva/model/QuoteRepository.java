package com.morkva.model;

import com.morkva.entities.Quote;

/**
 * Created by koros on 15.06.2015.
 */
public interface QuoteRepository {

    Quote getRandomQuote();

}

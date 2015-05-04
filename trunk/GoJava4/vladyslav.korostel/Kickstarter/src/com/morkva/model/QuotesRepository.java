package com.morkva.model;

import com.morkva.entities.Quote;

/**
 * Created by vladyslav on 02.05.15.
 */
public interface QuotesRepository {
    Quote[] getQuotes();
}

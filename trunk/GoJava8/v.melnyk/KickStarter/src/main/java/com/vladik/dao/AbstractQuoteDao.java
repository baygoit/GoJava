package com.vladik.dao;

import com.vladik.model.Quote;

public abstract class AbstractQuoteDao {

    public final String SEMICOLON_DELIMITER = ";";
    public final String NEW_LINE_SEPARATOR = "\n";

    public abstract void add(Quote element);

    public abstract void remove(Quote element);

    public abstract int getSize();

    public abstract Quote getRandomQuote();

}

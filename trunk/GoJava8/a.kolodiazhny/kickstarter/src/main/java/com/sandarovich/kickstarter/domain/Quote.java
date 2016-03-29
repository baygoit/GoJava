package com.sandarovich.kickstarter.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Quote
 */
@JsonAutoDetect
public class Quote {

    private String author;
    private String quote;

    public Quote() {

    }

    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return author + ": " + "\"" + quote + "\"";
    }
    public String getQuote() {
        return quote;
    }
    public String getAuthor() {
        return author;
    }
}

package com.sandarovich.kickstarter.model;

/**
 * Quote
 */
public class Quote {

    private String author;
    private String quote;

    public Quote() {

    }

    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }
    public String getAuthor() {
        return author;
    }
}

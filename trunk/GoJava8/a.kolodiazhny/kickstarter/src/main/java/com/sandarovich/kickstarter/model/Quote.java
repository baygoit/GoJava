package com.sandarovich.kickstarter.model;

/**
 * Quote
 */
public class Quote {

    private String author;
    private String text;

    public Quote() {

    }

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public String getAuthor() {
        return author;
    }
}

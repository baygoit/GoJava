package com.vladik.model;

public class Quote {
    private String quoteText;
    private String author;
//    public static final String TABLE_NAME = "Quotes";

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String title) {
        this.quoteText = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

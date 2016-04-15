package com.vladik.model;

public class Quote {
    private String author;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String title) {
        this.text = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

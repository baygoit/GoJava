package ua.dborisenko.kickstarter.domain;

public class Quote {
    private int id;
    private String text;
    private String author;

    public Quote(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}

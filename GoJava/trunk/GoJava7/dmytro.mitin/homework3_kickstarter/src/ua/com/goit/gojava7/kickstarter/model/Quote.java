package ua.com.goit.gojava7.kickstarter.model;

/**
 * Created by Dmytro on 06.11.2015.
 */
public class Quote {
    private final String text;

    private final String author;

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }
}

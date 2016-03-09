package ua.dborisenko.kickstarter;

public class Quote {

    private String text;
    private String author;

    public Quote(String quoteText, String quoteAuthor) {
        text = quoteText;
        author = quoteAuthor;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

}

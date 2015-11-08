package ua.com.goit.java5.dm.kickstarter.model;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Quote {

    private String quote;
    private String author;

    public Quote() {
    }

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote1 = (Quote) o;

        if (author != null ? !author.equals(quote1.author) : quote1.author != null) return false;
        if (quote != null ? !quote.equals(quote1.quote) : quote1.quote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quote != null ? quote.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}

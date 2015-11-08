package ua.com.goit.java5.dm.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ua.com.goit.java5.dm.kickstarter.model.Quote;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuoteDao {

    private List<Quote> quotes = new ArrayList<>();
    private Random random = new Random();


    public Quote getQuote() {
        if (quotes.isEmpty()) {
            throw new IllegalStateException("Quotes list must not be empty");
        }
        return quotes.get(random.nextInt(quotes.size() -1));
    }


    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}

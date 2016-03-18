package ua.dborisenko.kickstarter.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoFile implements QuoteDao {
    private List<Quote> quotes = new ArrayList<Quote>();
    private String quotesFileName = "./src/main/resources/quotes.txt";

    public void setQuotesFileName(String quotesFileName) {
        this.quotesFileName = quotesFileName;
    }

    @Override
    public Quote getRandomQuote() {
        Random random = new Random();
        int quoteNumber = random.nextInt(quotes.size());
        return quotes.get(quoteNumber);
    }

    public void fillQuotes() {
        try (BufferedReader is = new BufferedReader(new FileReader(quotesFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] quoteParts = line.split("#");
                Quote quote = new Quote(Integer.valueOf(quoteParts[0]), quoteParts[1], quoteParts[2]);
                quotes.add(quote);
            }
        } catch (Exception e) {
            quotes.clear();
            throw new IllegalStateException("Couldn`t read quotes from the file");
        }
    }
}

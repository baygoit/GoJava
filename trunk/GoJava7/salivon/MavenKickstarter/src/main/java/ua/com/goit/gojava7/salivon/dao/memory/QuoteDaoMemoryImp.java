package ua.com.goit.gojava7.salivon.dao.memory;

import java.util.List;
import java.util.Random;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.dao.QuoteDao;
import ua.com.goit.gojava7.salivon.stores.StoreQuotes;

public class QuoteDaoMemoryImp implements QuoteDao {

    private StoreQuotes storeQuotes = new StoreQuotes();

    @Override
    public String getRandomQuote() {
        Random random = new Random();
        List<Quote> quotes = storeQuotes.getQuotes();
        String quote;
        int number = (int) (random.nextDouble() * quotes.size());
        quote = quotes.get(number).getText() + "\n Autor:" + quotes.get(number).getAutor();
        return quote;
    }

}

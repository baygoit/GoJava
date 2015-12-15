package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteStorage extends AbstractQuoteStorage{
	private static int idGenerator;
	private final Random random;
	private final List<Quote> quotes;
	
	public QuoteStorage(List<Quote> quotes) {
		idGenerator = 0;
		this.quotes = quotes;
		this.random = new Random();
	}

	public Quote getRandomQuote() {
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}

	public void add(Quote quote) {
		quote.setIdQuote(++idGenerator);
		this.quotes.add(quote);
	}
}
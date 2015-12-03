package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteStorage extends AbstractQuoteStorage{
	private static int idGenerator = 0;
	private final Random random;
	private final List<Quote> quotes;
	
	public QuoteStorage(Random random) {
		this.quotes = new ArrayList<>();
		this.random = random;
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
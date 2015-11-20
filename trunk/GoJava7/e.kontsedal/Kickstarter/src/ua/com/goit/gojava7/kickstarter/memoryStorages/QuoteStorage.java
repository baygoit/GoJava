package ua.com.goit.gojava7.kickstarter.memoryStorages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteStorage {

	private final Random random;
	private final List<Quote> quotes;
	
	public QuoteStorage(Random random) {
		this.quotes = new ArrayList<>();
		this.random = random;
	}

	public void addQuote(Quote quote) {
		this.quotes.add(quote);
	}
	
	public Quote takeRandomQuote() {
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}

	public List<Quote> getQuotes() {
		return quotes;
	}
}
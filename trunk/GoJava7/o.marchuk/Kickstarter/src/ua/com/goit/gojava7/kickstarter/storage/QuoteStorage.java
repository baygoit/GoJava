package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorage {

	private Random random;

	private List<Quote> quotes = new ArrayList<>();

	public QuoteStorage(Random random) {
		this.random = random;
	}

	public Quote getRandomQuote() {
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
}

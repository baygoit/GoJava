package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorage implements Storage {

	private static final Random RANDOM = new Random();
	private List<Quote> quotes = new ArrayList<>();

	public void add(Quote quote) {
		quotes.add(quote);
	}

	public Quote getRandomQuote() {
		int randomNumber = RANDOM.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}

	@Override
	public int size() {
		return quotes.size();
	}

	public List<Quote> get() {
		return quotes;
	}

}
package ua.com.goit.gojava7.kickstarter.storage;

import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorage extends Storage<Quote> {
	private static final Random RANDOM = new Random();

	public QuoteStorage() {

	}

	public Quote getRandomQuote() {
		if (size() == 0) {
			add(new Quote("I work to stay alive.", "Bette Davis"));
		}
		int randomNumber = RANDOM.nextInt(size());
		return get(randomNumber);
	}

}
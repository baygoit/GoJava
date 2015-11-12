package ua.com.goit.gojava7.kickstarter.storage;

import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorage extends Storage<Quote> {

	private static final Random RANDOM = new Random();

	public Quote getRandomQuote() {
		int randomNumber = RANDOM.nextInt(dataSource.size());
		return dataSource.get(randomNumber);
	}

}
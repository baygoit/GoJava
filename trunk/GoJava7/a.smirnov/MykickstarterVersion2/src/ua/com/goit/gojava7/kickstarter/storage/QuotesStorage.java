package ua.com.goit.gojava7.kickstarter.storage;

import java.util.Random;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuotesStorage extends AbstractTemplate<Quote>{
	private static final Random RANDOM = new Random();
	
	public Quote getRandomQuote() {
		int randomNumber = RANDOM.nextInt(sourceStorage.size());
		return sourceStorage.get(randomNumber);
	}

}

package ua.com.goit.gojava7.kickstarter.storage;

import java.io.FileNotFoundException;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.file.FileWorker;

public class QuoteStorage extends Storage<Quote> {
	private static final Random RANDOM = new Random();
	
	public QuoteStorage() {
		
	}

	public QuoteStorage(String fileName) throws FileNotFoundException {
		initQuotes(fileName);
	}

	public Quote getRandomQuote() {
		if (size() == 0) {
			add(new Quote("I work to stay alive.", "Bette Davis"));
		}
		int randomNumber = RANDOM.nextInt(size());
		return get(randomNumber);
	}

	public void initQuotes(String fileName) throws FileNotFoundException {
		setAll(FileWorker.readQuotes(fileName));
	}

}
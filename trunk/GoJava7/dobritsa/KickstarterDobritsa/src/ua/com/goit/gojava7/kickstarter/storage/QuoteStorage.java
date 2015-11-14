package ua.com.goit.gojava7.kickstarter.storage;

import java.io.FileNotFoundException;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.file.FileWorker;

public class QuoteStorage extends Storage<Quote> {
	private static final Random RANDOM = new Random();

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
		/*
		 * add(new Quote(
		 * "There is only one boss. The customer. And he can fire everybody" +
		 * "\n     in the company from the chairman on down, simply by " +
		 * "\n     spending his money somewhere else.", "Sam Walton")); add(new
		 * Quote("Ideas pull the trigger, but instinct loads the gun. ",
		 * "Don Marquis")); add(new Quote(
		 * "There are no secrets to success. It is the result of preparation, "
		 * + "\n     hard work, and learning from failure. ", "Colin Powell"));
		 * add(new Quote(
		 * "Happiness does not come from doing easy work but from the " +
		 * "\n     afterglow of satisfaction that comes after the achievement "
		 * + "\n     of a difficult task that demanded our best. ",
		 * "Theodore Isaac Rubin"));
		 */

	}

}
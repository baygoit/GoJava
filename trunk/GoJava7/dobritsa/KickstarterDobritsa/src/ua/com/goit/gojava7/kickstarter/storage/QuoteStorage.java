package ua.com.goit.gojava7.kickstarter.storage;

import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteStorage extends Storage<Quote> {
	private static final Random RANDOM = new Random();

	public QuoteStorage() {
		initQuotes();
	}

	public Quote getRandomQuote() {
		int randomNumber = RANDOM.nextInt(size());
		return get(randomNumber);
	}

	private void initQuotes() {
		add(new Quote("I work to stay alive.", "Bette Davis"));
		add(new Quote("There is only one boss. The customer. And he can fire everybody"
				+ "\n     in the company from the chairman on down, simply by "
				+ "\n     spending his money somewhere else.", "Sam Walton"));
		add(new Quote("Ideas pull the trigger, but instinct loads the gun. ", "Don Marquis"));
		add(new Quote("There are no secrets to success. It is the result of preparation, "
				+ "\n     hard work, and learning from failure. ", "Colin Powell"));
		add(new Quote("Happiness does not come from doing easy work but from the "
				+ "\n     afterglow of satisfaction that comes after the achievement "
				+ "\n     of a difficult task that demanded our best. ", "Theodore Isaac Rubin"));

	}

}
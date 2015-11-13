package ua.com.goit.gojava7.kickstarter.manager;

import java.util.Random;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class QuoteManager {

	private QuoteStorage quoteStorage;
	private static final Random RANDOM = new Random();

	public QuoteManager() {
		quoteStorage = initQuotes();
	}

	public Quote getRandomQuote() {
		int randomNumber = RANDOM.nextInt(quoteStorage.size());
		return quoteStorage.get(randomNumber);
	}

	public void printRandomQuote() {
		Quote quote = getRandomQuote();
		System.out.println(quote.getText() + "\n     " + quote.getAuthor());
	}

	public void print(int index) {
		System.out.println(quoteStorage.get(index).getText() + 
				"\n " +	 quoteStorage.get(index).getAuthor());
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.add(new Quote("I work to stay alive.", "Bette Davis"));
		quoteStorage.add(new Quote("There is only one boss. The customer. And he can fire everybody"
				+ "\n     in the company from the chairman on down, simply by "
				+ "\n     spending his money somewhere else.", "Sam Walton"));
		quoteStorage.add(new Quote("Ideas pull the trigger, but instinct loads the gun. ", "Don Marquis"));
		quoteStorage.add(new Quote("There are no secrets to success. It is the result of preparation, "
				+ "\n     hard work, and learning from failure. ", "Colin Powell"));
		quoteStorage.add(new Quote("Happiness does not come from doing easy work but from the "
				+ "\n     afterglow of satisfaction that comes after the achievement "
				+ "\n     of a difficult task that demanded our best. ", "Theodore Isaac Rubin"));
		return quoteStorage;
	}

}

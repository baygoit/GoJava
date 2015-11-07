package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage.QuotesStorage;

public class PrinterQuotes {
	private static final Random RANDOM = new Random();

	public void printQuotes() {
		QuotesStorage storageOfQuotes = new QuotesStorage();

		List<Quote> listOfQuotes = storageOfQuotes.getDataSource();
		int amountOfQuotes = listOfQuotes.size();
		StringBuilder result = new StringBuilder();

		Quote quote = listOfQuotes.get(RANDOM.nextInt(amountOfQuotes));
		result.append(quote.getTitle()).append("\n").append(quote.getAuthor());
		System.out.println(result.toString());
	}
}

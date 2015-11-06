package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class PrinterQuotes {
	private static final Random RANDOM = new Random();

	public void printQuotes(QuoteDAO storageOfQuotes) {

		List<Quote> listOfQuotes = storageOfQuotes.getDataSource();
		int amountOfQuotes = listOfQuotes.size();
		StringBuilder result = new StringBuilder();

		Quote quote = listOfQuotes.get(RANDOM.nextInt(amountOfQuotes));
		result.append(quote.getTitle()).append("\n").append(quote.getAuthor());
		System.out.println(result.toString());
	}
}

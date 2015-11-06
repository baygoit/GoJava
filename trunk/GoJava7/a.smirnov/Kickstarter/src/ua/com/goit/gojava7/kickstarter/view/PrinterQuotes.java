package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Random;

// OLEG unused import
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class PrinterQuotes {
	private static final Random RANDOM = new Random();

	// OLEG why we pass DAO? why not list of quotes to print?
	public void printQuotes(QuoteDAO storageOfQuotes) {

		List<Quote> listOfQuotes = storageOfQuotes.getDataSource();
		int amountOfQuotes = listOfQuotes.size();
		StringBuilder result = new StringBuilder();

		Quote quote = listOfQuotes.get(RANDOM.nextInt(amountOfQuotes));
		// OLEG append on append with append. It becomes unreadable 
		result.append(quote.getTitle()).append("\n").append(quote.getAuthor());
		// OLEG toString is not needed
		System.out.println(result.toString());
	}
}

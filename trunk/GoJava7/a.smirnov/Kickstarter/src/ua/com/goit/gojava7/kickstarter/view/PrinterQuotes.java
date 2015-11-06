package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Random;

<<<<<<< HEAD
=======
// OLEG unused import
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
>>>>>>> ab663b305363e409959091aee5fef442b1a5cbf8
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class PrinterQuotes {
	private static final Random RANDOM = new Random();

<<<<<<< HEAD
	public void printRandomQuote(QuoteDAO allQuotes) {
		List<Quote> listOfQuotes = allQuotes.getDataSource();
=======
	// OLEG why we pass DAO? why not list of quotes to print?
	public void printQuotes(QuoteDAO storageOfQuotes) {

		List<Quote> listOfQuotes = storageOfQuotes.getDataSource();
>>>>>>> ab663b305363e409959091aee5fef442b1a5cbf8
		int amountOfQuotes = listOfQuotes.size();
		StringBuilder result = new StringBuilder();

		Quote quote = listOfQuotes.get(RANDOM.nextInt(amountOfQuotes));
<<<<<<< HEAD
		result.append(quote.getQuoteText()).
			append("\n").
			append(quote.getAuthor());
		
=======
		// OLEG append on append with append. It becomes unreadable 
		result.append(quote.getTitle()).append("\n").append(quote.getAuthor());
		// OLEG toString is not needed
>>>>>>> ab663b305363e409959091aee5fef442b1a5cbf8
		System.out.println(result.toString());
	}
}

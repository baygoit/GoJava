package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.templates.AbstractTemplateFiles;

public class QuotesStorage extends AbstractTemplateFiles<Quote>{
	
	private static final Random RANDOM = new Random();
	
	public QuotesStorage() {
		
		Quote quote1 = new Quote("B. Franklin", 
				"Liberty will not descend to a people, a people must "
				+ "raise themselves to liberty; it is a blessing that must " 
				+ "be earned before it can be enjoyed.");

		Quote quote2 = new Quote("Ronald Reagan", 
				"Government's first duty is to protect the people, not " 
				+ "run their lives.");

		Quote quote3 = new Quote("Ronald Reagan", 
				"The most terrifying words in the English language are: "
				+ "I'm from the government and I'm here to help.");

		add(quote1);
		add(quote2);
		add(quote3);
	}
	
	
	public Quote getRandomQuote() {
		List<Quote> listQuotes = convertSetInList(getAll());
		
		int randomNumber = RANDOM.nextInt(listQuotes.size());
		
		return listQuotes.get(randomNumber);
	}
}

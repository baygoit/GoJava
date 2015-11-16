package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class QuotePrinter {
	
	public void printRandomQuote(QuoteStorage quoteStorage) {
		Quote quote = quoteStorage.getRandomQuote();
		print(quote);		
	}
	
	public void print(Quote quote) {
		System.out.println(quote.getText() + 
				"\n " +	 quote.getAuthor());
	}

}

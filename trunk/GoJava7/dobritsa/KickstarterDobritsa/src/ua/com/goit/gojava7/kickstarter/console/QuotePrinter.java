package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class QuotePrinter {
	
	public void printRandomQuote(QuoteStorage quoteStorage) {
		Quote quote = quoteStorage.getRandomQuote();
		System.out.println(quote.getText() + "\n          " + quote.getAuthor());
	}

	public void print(QuoteStorage quoteStorage, int index) {
		System.out.println(quoteStorage.get(index).getText() + 
				"\n " +	 quoteStorage.get(index).getAuthor());
	}

}

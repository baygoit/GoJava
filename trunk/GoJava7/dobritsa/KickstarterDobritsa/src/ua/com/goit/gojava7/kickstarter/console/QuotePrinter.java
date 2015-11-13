package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class QuotePrinter {
	//QuoteManager quoteManager;
	QuoteStorage quoteStorage;
	
	public QuotePrinter(QuoteStorage quoteStorage){
		this.quoteStorage = quoteStorage;
	}
	
	public void printRandomQuote() {
		Quote quote = quoteStorage.getRandomQuote();
		System.out.println(quote.getText() + "\n     " + quote.getAuthor());
	}

	public void print(int index) {
		System.out.println(quoteStorage.get(index).getText() + 
				"\n " +	 quoteStorage.get(index).getAuthor());
	}

}

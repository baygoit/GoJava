package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuotePrinter {
	
	public void print(Quote quote) {
		if(quote.equals(null)) {
			System.err.println("There are no quotes");
			return;
		}
		System.out.println(quote.getText() + 
				"\n " +	 quote.getAuthor());
	}

}

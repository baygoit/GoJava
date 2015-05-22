package ua.com.goit.gojava.kickstarter.view;

import ua.com.goit.gojava.kickstarter.model.Quote;

public class QuotesViewer {

    public void showQuoteMenu(Quote quote) {

	System.out
		.println("====================================================================");
	System.out.println("Everyday inspiring quote:");
	System.out.println(quote.getQuote());
	System.out
		.println("--------------------------------------------------------------------");
    }
}

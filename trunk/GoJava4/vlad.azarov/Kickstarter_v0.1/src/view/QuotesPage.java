package view;

import model.Quote;

public class QuotesPage {

    public void showQuoteMenu(Quote quote) {

	System.out
		.println("====================================================================");
	System.out.println("Everyday inspiring quote:");
	System.out.println(quote.getQuote());
	System.out
		.println("--------------------------------------------------------------------");
    }
}

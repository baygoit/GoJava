package ua.com.goit.gojava.kickstarter.view;

import ua.com.goit.gojava.kickstarter.model.Quote;

public class QuotesViewer {
	
	Printer printer;
	
	public QuotesViewer(Printer printer) {
		this.printer = printer;
	}

    public void showQuoteMenu(Quote quote) {
    	StringBuilder quoteMenu = new StringBuilder();
		quoteMenu.append("====================================================================\n");
		quoteMenu.append("Inspiring quote:\n");
		quoteMenu.append(quote.getQuote()+"\n");
		quoteMenu.append("--------------------------------------------------------------------\n");
		printer.println(quoteMenu.toString());
    }
}

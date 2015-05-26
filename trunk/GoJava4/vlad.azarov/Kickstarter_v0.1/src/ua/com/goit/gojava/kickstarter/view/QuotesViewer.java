package ua.com.goit.gojava.kickstarter.view;

import ua.com.goit.gojava.kickstarter.model.Quote;

public class QuotesViewer {

    Printer printer;

    public QuotesViewer(Printer printer) {
	this.printer = printer;
    }

    public void showQuoteMenu(Quote quote) {
	StringBuilder quoteMenu = new StringBuilder();
	quoteMenu.append("			  INSPIRING QUOTE:\n");
	quoteMenu.append(quote.getQuote() + "\n");
	quoteMenu
		.append("--------------------------------------------------------------------\n");
	printer.print(quoteMenu.toString());
    }

//    public void showQuoteMenu(Quote randomQuote) {
//	StringBuilder result = new StringBuilder();
//	
//
//    }
}

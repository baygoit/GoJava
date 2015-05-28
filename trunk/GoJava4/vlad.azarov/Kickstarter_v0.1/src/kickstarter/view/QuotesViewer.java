package kickstarter.view;

import kickstarter.printer.Printer;
import kickstarter.repos.QuotesRepo;

public class QuotesViewer {

    Printer printer;
    private QuotesRepo quotesRepo;

    public QuotesViewer(Printer printer) {
	this.printer = printer;
	quotesRepo = new QuotesRepo();
    }

    public void showQuoteMenu() {
	printer.println("\t\t\t INSPIRING QUOTE:");
	printer.println(quotesRepo.showRandomQuote());
    }
}

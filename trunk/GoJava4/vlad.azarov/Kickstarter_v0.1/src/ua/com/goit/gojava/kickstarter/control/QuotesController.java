package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.model.QuotesRepository;
import ua.com.goit.gojava.kickstarter.view.QuotesViewer;

public class QuotesController {

	QuotesRepository quotesRepository;
	QuotesViewer quotesViewer;

	public QuotesController() {
		this.quotesRepository = new QuotesRepository();
		this.quotesViewer = new QuotesViewer();
	}

	public void callsShowQuoteMenu() {
		quotesViewer.showQuoteMenu(quotesRepository.getRandomQuote());

	}

}

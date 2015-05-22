package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.model.QuotesRepository;
import ua.com.goit.gojava.kickstarter.view.QuotesPage;

public class QuotesController {

	QuotesRepository quotesRepository;
	QuotesPage quotesPage;

	public QuotesController() {
		this.quotesRepository = new QuotesRepository();
		this.quotesPage = new QuotesPage();
	}

	public void callsShowQuoteMenu() {
		quotesPage.showQuoteMenu(quotesRepository.getRandomQuote());

	}

}

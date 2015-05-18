package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.model.QuotesRepository;
import ua.com.goit.gojava.kickstarter.view.QuotesPage;

public class QuotesControl {
    
    QuotesRepository quotesRepository;
    QuotesPage quotesPage;
    
    public QuotesControl() {
	this.quotesRepository = new QuotesRepository();
	this.quotesPage = new QuotesPage();
    }

    public void callToShowQuoteMenu() {
	quotesPage.showQuoteMenu(quotesRepository.getRandomQuote());
	
    }
    
}

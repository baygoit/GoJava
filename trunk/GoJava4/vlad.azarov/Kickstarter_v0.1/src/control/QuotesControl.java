package control;

import model.QuotesRepository;
import view.QuotesPage;

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

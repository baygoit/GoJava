package control;

import model.QuotesRepository;
import view.QuotesPage;

public class QuoteService {
    
    QuotesRepository quotesRepository;
    QuotesPage quotesPage;
    
    public QuoteService() {
	this.quotesRepository = new QuotesRepository();
	this.quotesPage = new QuotesPage();
    }

    public void callToShowQuoteMenu() {
	quotesPage.showQuoteMenu(quotesRepository.getRandomQuote());
	
    }
    
}

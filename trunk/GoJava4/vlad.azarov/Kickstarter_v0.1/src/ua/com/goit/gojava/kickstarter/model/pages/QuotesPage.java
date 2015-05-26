package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.QuotesRepository;
import ua.com.goit.gojava.kickstarter.view.QuotesViewer;

public class QuotesPage implements Page {

    private QuotesViewer quotesViewer;
    private QuotesRepository quotesRepository;
    private PageId id;

    
    public QuotesPage(QuotesViewer quotesViewer,
	    QuotesRepository quotesRepository) {
	id = PageId.QUOTES;
	this.quotesViewer = quotesViewer;
	this.quotesRepository = quotesRepository;
    }

    @Override
    public void showPage() {
	quotesViewer.showQuoteMenu(quotesRepository.getRandomQuote());
    }

    @Override
    public PageId getPageId() {
	// TODO Auto-generated method stub
	return null;
    }

}

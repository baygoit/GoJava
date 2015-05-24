package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.QuotesRepository;
import ua.com.goit.gojava.kickstarter.view.CategoriesViewer;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.QuotesViewer;

public class HomePage implements Page {
	
	private PageId id;
	private QuotesRepository quotesRepository;
    private QuotesViewer quotesViewer;
    private CategoriesViewer categoriesViewer;
    
	public HomePage(Printer printer) {
		id = PageId.HOME;
		quotesRepository = new QuotesRepository();
		quotesViewer = new QuotesViewer(printer);
		categoriesViewer = new CategoriesViewer(printer);
	}

	@Override
	public void showPage() {
		quotesViewer.showQuoteMenu(quotesRepository.getRandomQuote());
		categoriesViewer.showCategoryMenu();	
	}

	@Override
	public PageId getPageId() {
		return id;
	}
}

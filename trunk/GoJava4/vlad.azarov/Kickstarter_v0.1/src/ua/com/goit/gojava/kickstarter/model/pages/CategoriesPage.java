package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.view.CategoriesViewer;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class CategoriesPage implements Page {

    private PageId id;
    private CategoriesViewer categoriesViewer;

    public CategoriesPage(Printer printer) {
	id = PageId.CATEGORIES;
	categoriesViewer = new CategoriesViewer(printer);
    }

    @Override
    public void showPage() {
	categoriesViewer.showCategoriesMenu();
    }
    
    @Override
    public PageId getPageId() {
	return id;
    }
}

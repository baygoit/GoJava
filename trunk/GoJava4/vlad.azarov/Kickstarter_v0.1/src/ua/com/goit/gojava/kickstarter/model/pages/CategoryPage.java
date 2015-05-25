package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.CategoriesViewer;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class CategoryPage implements Page {

	private PageId id;
    private CategoriesViewer categoriesViewer;
    private Category category;
    
	public CategoryPage(Printer printer, Category category) {
		id = PageId.CATEGORY;
		categoriesViewer = new CategoriesViewer(printer);
		this.category = category;
	}
	
	@Override
	public void showPage() {
		categoriesViewer.showCategoryWithProjects(category);
	}

	@Override
	public PageId getPageId() {
		return id;
	}
	
	public Category getCategory() {
		return category;
	}
}

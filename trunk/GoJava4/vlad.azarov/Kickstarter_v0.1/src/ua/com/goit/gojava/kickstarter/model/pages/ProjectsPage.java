package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.CategoriesViewer;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class ProjectsPage implements Page {

    private PageId id;
    private CategoriesViewer categoriesViewer;
    private Category category;

    public ProjectsPage(Printer printer, Category category) {
	id = PageId.PROJECTS;
	categoriesViewer = new CategoriesViewer(printer);
	this.category = category;
    }

    @Override
    public void showPage() {
	categoriesViewer.showProjectsOf(category);
    }

    @Override
    public PageId getPageId() {
	return id;
    }

    public Category getCategory() {
	return category;
    }
}

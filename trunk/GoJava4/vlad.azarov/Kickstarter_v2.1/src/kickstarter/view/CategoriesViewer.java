package kickstarter.view;

import kickstarter.model.Category;
import kickstarter.printer.Printer;
import kickstarter.repos.CategoriesRepo;

public class CategoriesViewer {

    ProjectsViewer projectsViewer;
    CategoriesRepo categoriesRepo;
    Printer printer;

    public CategoriesViewer(Printer printer) {
	projectsViewer = new ProjectsViewer(printer);
	categoriesRepo = new CategoriesRepo();
	this.printer = printer;
    }

    public void showCategoriesMenu() {
	StringBuilder menu = new StringBuilder();
	menu.append("--------------------------------------------------------------------\n");
	menu.append("CATEGORIES\n");
	menu.append("--------------------------------------------------------------------\n");
	menu.append(getAllCategories());
	menu.append("\t [0] EXIT");
	printer.println(menu.toString());
    }

    private String getAllCategories() {
	StringBuilder categories = new StringBuilder();
	int index = 1;
	for (Category category : categoriesRepo.getAll()) {
	    categories.append("\t [" + index + "] ");
	    categories.append(category.getName());
	    categories.append("\n");
	    index++;
	}
	return categories.toString();
    }
}

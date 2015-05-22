package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.CategoriesRepository;
import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.CategoriesPage;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class CategoriesController {

    private CategoriesRepository categoriesRepository;
    private CategoriesPage categoriesPage;
    private ProjectsController projectsControl;
    private InputController inputControl;

    public CategoriesController(Printer printer) {
	categoriesRepository = new CategoriesRepository();
	categoriesPage = new CategoriesPage(printer);
	projectsControl = new ProjectsController(printer);
	inputControl = new InputController();
    }

    public ArrayList<Category> getCategories() {
	return categoriesRepository.getCategories();
    }

    public void showCategories() {
	categoriesPage.showCategories(getCategories());
    }

    public void showCategoryMenu1(Category category) {
	categoriesPage.showCategoryMenu2(category,
		projectsControl.getProjectsFromCategory(category),
		inputControl.readUserInput());
    }

}

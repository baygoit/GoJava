package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.CategoriesRepository;
import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.CategoriesViewer;
import ua.com.goit.gojava.kickstarter.view.ConsoleInputReader;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class CategoriesController {

    private CategoriesRepository categoriesRepository;
    private CategoriesViewer categoriesViewer;
    private ProjectsController projectsController;
    private ConsoleInputReader inputReader;

    public CategoriesController(Printer printer) {
	categoriesRepository = new CategoriesRepository();
	categoriesViewer = new CategoriesViewer(printer);
	projectsController = new ProjectsController(printer);
	inputReader = new ConsoleInputReader();
    }

    public ArrayList<Category> getCategories() {
	return categoriesRepository.getCategories();
    }

    public void showExistingCategories() {
	categoriesViewer.showCategories(getCategories());
    }

    public void showCategoryMenu1(Category category) {
	categoriesViewer.showCategoryMenu2(category,
		projectsController.getProjectsFromCategory(category),
		inputReader.readUserInput());
    }

    public void showChoosenCategory(int userInput) {
	categoriesViewer.getCategoryProjects(userInput);
	
    }

}

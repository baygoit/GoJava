package ua.com.goit.gojava.kickstarter.view;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;

public class CategoriesPage {

    ProjectsPage projectsPage;
    Printer printer;

    public CategoriesPage(Printer printer) {
	projectsPage = new ProjectsPage(printer);
	this.printer = printer;
    }

    public void showCategories(ArrayList<Category> categories) {
	printer.println("Select category: ");
	for (int index = 0; index < categories.size(); index++) {
	    printer.println(categories.get(index).getId() + ": "
		    + categories.get(index).getName());
	}
    }

    public void showCategoryMenu2(Category category,
	    ArrayList<Project> projectsOfCurrentCategory, int userInput) {
	while (true) {
	    projectsPage.showProjectsOfCategory(category,
		    projectsOfCurrentCategory);

	    printer.println("");
	    printer.println("Enter \"0\" to select another category: ");
	    printer.println("====================================================================");

	    int key = userInput;
	    if (key == 0) {
		break;
	    } else {
		if (key > 0 && key <= projectsOfCurrentCategory.size()) {
		    Project selectedProject = projectsOfCurrentCategory
			    .get(key - 1);
		    projectsPage.showProjectMenu(selectedProject, userInput);
		} else {
		    printer.println("Project with #" + userInput
			    + " does not exist");
		}
	    }
	}
    }

}

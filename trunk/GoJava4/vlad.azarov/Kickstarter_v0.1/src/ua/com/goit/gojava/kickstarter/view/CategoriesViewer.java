package ua.com.goit.gojava.kickstarter.view;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;

public class CategoriesViewer {

    ProjectsViewer projectsViewer;
    Printer printer;
    ConsoleInputReader reader = new ConsoleInputReader();

    public CategoriesViewer(Printer printer) {
	projectsViewer = new ProjectsViewer(printer);
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
	    projectsViewer.showProjectsOfCategory(category,
		    projectsOfCurrentCategory);

	    printer.println("");
	    printer.println("Enter \"0\" to select another category: ");
	    printer.println("====================================================================");

	    int key = reader.readUserInput();
	    if (key == 0) {
		break;
	    } else {
		if (key > 0 && key <= projectsOfCurrentCategory.size()) {
		    Project selectedProject = projectsOfCurrentCategory
			    .get(key - 1);
		    projectsViewer.showProjectMenu(selectedProject);
		} else {
		    printer.println("Project with #" + userInput
			    + " does not exist");
		}
	    }
	}
    }

    public void getCategoryProjects(int userInput) {
	projectsViewer.showProjectsFromParticularCategory(userInput);
    }

}

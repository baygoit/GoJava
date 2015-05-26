package ua.com.goit.gojava.kickstarter.view;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.model.Repository;

public class CategoriesViewer {

    ProjectsViewer projectsViewer;
    Printer printer;
    Repository repository;

    public CategoriesViewer(Printer printer) {
	projectsViewer = new ProjectsViewer(printer);
	this.printer = printer;
	repository = new ProjectsRepository();
    }

    public void showCategoriesMenu() {
	StringBuilder categoryMenu = new StringBuilder();
	categoryMenu.append("--------------------------------------------------------------------\n");
	categoryMenu.append("CATEGORIES:\n");
	categoryMenu.append(getAllCategories());
	categoryMenu.append("\t [QUIT]");
	categoryMenu.append("\n\n\t Enter the number of the category to explore it ");
	categoryMenu.append("\n\t or \"quit\" to exit: ");
	printer.print(categoryMenu.toString());
    }

    private String getAllCategories() {
	StringBuilder result = new StringBuilder();
	int index = 1;
	for (Category category : Category.values()) {
	    result.append("\t [" + index + "] ");
	    result.append(category);
	    result.append("\n");
	    index++;
	}
	return result.toString();
    }

    public void showProjectsMenu(Category category) {
	StringBuilder categoryWithProjects = new StringBuilder();
	categoryWithProjects.append("CATEGORIES > " + category + " \n");
	categoryWithProjects.append("PROJECTS:\n");
	categoryWithProjects.append(getProjectsOfCategory(category));

	printer.println(categoryWithProjects.toString());
	printer.println("\t Enter the project number for detail information ");
	printer.print("\t or \"0\" to return back to categories: ");
    }

    public String getProjectsOfCategory(Category category) {
	StringBuilder result = new StringBuilder();
	for (Project project : repository.getProjectsOfCategoryArray(category)) {
	    result.append("\t [" + project.getId() + "] " + project.getName());
	    result.append(" - " + project.getShortDescription());
	    result.append("\n");
	}
	result.append("\t [0] PREVIOUS MENU \n");
	return result.toString();
    }

}

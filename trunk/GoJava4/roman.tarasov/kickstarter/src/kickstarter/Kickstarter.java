package kickstarter;

import java.util.ArrayList;
import java.util.Scanner;

public class Kickstarter {

	Category category;
	Project project;
	CategoryList categories;
	PageDispatcher dispatcher;
	AdminCategoriesControl adminPage;
	UserInterface ui;

	int projectId;
	int categoryId;


	public void start() {
	
		ui=new ConsoleUI();
	
        dispatcher=new PageDispatcher(ui,categories);

        dispatcher.startDispatcher();
	
	}


	void printInfoAboutProject(Project project) {
		System.out.println("description: " + project.description);
		System.out.println("history    : " + project.history);
	}

	Project parseStringToProject(ArrayList<Project> projects,
			String stringToParse) {
		try {
			int parsed = Integer.parseInt(stringToParse);
			project = projects.get(parsed);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		return project;

	}

	Category parseStringToCategory(ArrayList<Category> categories,
			String stringToParse) throws IllegalArgumentException {

		try {
			int parsed = Integer.parseInt(stringToParse);
			category = categories.get(parsed);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		return category;
	}

	void printInfoAboutProjectsInCategory(ArrayList<Project> projectsInCategory) {
		Project currentProject;
		for (int index = 0; index < projectsInCategory.size(); index++) {
			currentProject = projectsInCategory.get(index);
			System.out.println(index + "- " + currentProject.name + " , goal:"
					+ currentProject.goal + "  pledged:"
					+ currentProject.pledged + " , expire date:"
					+ currentProject.expireDate);
		}
	}

	void add(CategoryList listCategories){
		this.categories=listCategories;
	}

}

package kickstarter;

import kickstarter.Repository.CategoryList;
import kickstarter.Repository.ProjectList;

public class Kickstarter {

	CategoryList categories;
	ProjectList projects;
	UserInterface ui;

	public void start() {
		ui = new ConsoleUI();
		PageDispatcher dispatcher = new PageDispatcher(ui, categories, projects);
		dispatcher.startDispatcher();
	}

	public void add(CategoryList listCategories) {
		this.categories = listCategories;
	}

 public void add(ProjectList listProjects) {
		this.projects = listProjects;
	}

}

package kickstarter;

public class Kickstarter {

	CategoryList categories;
	ProjectList projects;
	UserInterface ui;

	public void start() {
		ui = new ConsoleUI();
		PageDispatcher dispatcher = new PageDispatcher(ui, categories, projects);
		dispatcher.startDispatcher();
	}

	void add(CategoryList listCategories) {
		this.categories = listCategories;
	}

	void add(ProjectList listProjects) {
		this.projects = listProjects;
	}

}

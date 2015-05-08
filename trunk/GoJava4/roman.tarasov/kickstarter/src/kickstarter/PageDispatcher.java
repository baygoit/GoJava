package kickstarter;

public class PageDispatcher {
	UserInterface ui;
	CategoryList categories;
	ProjectList projects;
	PageUserCategoriesView userCategoriesView;
	PageUserProjectsView userProjectsView;
	DetailedProjectInfo detailedProjectInfo;


	PageDispatcher(UserInterface ui, CategoryList categories,
			ProjectList projects) {

		this.ui = ui;
		this.categories = categories;
		this.projects = projects;
	}

	void cycleDispatcher() {
		while (true) {
			selectCategory();

		}
	}

	void selectCategory() {
		Category category = userCategoriesView.selectCategory();
		selectProject(category);
	}

	void selectProject(Category category) {
		projects.targetCategory = category;
		Project project = userProjectsView.selectProject();
		getDetailedProject(project);
	}

	void getDetailedProject(Project project) {
		detailedProjectInfo.getDetailedInfo(project);
	}

	public void startDispatcher() {
		userCategoriesView = new PageUserCategoriesView(categories, ui);
		userProjectsView = new PageUserProjectsView(projects, ui);
		detailedProjectInfo = new DetailedProjectInfo(ui);
		cycleDispatcher();
	}

}

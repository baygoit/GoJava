package kickstarter;

import kickstarter.Entities.Category;
import kickstarter.Entities.Project;
import kickstarter.Repository.CategoryList;
import kickstarter.Repository.ProjectList;
import kickstarter.UserPages.DetailedProject;
import kickstarter.UserPages.Categories;
import kickstarter.UserPages.Projects;

public class PageDispatcher {
	UserInterface ui;
	CategoryList categories;
	ProjectList projects;
	Categories userCategoriesView;
	Projects userProjectsView;
	DetailedProject detailedProjectInfo;

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
		if (category == null) {
			System.exit(0);
		}
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
		userCategoriesView = new Categories(categories, ui);
		userProjectsView = new Projects(projects, ui);
		detailedProjectInfo = new DetailedProject(ui);
		cycleDispatcher();
	}
}

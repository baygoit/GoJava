package kickstarter;

import kickstarter.Entities.Category;
import kickstarter.Entities.Comments;
import kickstarter.Entities.Project;
import kickstarter.Entities.Quote;
import kickstarter.Repository.Storage;
import kickstarter.UserPages.DetailedProject;
import kickstarter.UserPages.Categories;
import kickstarter.UserPages.Projects;

public class PageDispatcher {
	UserInterface ui;
	Storage<Category> categories;
	Storage<Project> projects;
	Storage<Quote> quotes;
	Storage<Comments> allComments;
	Categories userCategoriesView;
	Projects userProjectsView;
	DetailedProject detailedProjectInfo;
	

	PageDispatcher(UserInterface ui, Storage<Category> categories,
			Storage<Project> projects, Storage<Quote> quotes, Storage<Comments> allComments) {

		this.ui = ui;
		this.categories = categories;
		this.projects = projects;
		this.quotes = quotes;
		this.allComments=allComments;
	}

	void cycleDispatcher() {
		while (true) {
			showRandomQuote();
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
		userProjectsView.targetCategory = category;
		Project project = userProjectsView.selectProject();
		if (project == null) {
			return;
		}
		getDetailedProject(project);
	}

	void getDetailedProject(Project project) {
		detailedProjectInfo.getDetailedInfo(project,allComments);
	}

	public void startDispatcher() {
		userCategoriesView = new Categories(categories, ui);
		userProjectsView = new Projects(projects, ui);
		detailedProjectInfo = new DetailedProject(ui,allComments);
		cycleDispatcher();
	}

	private void showRandomQuote() {
		Quote randomQuote = quotes.getRandom();
		ui.display("-----Quote------");
		ui.display(randomQuote.getQuote());
		ui.display("----------------");
	}
}

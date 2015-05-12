package kickstarter;

import kickstarter.Entities.Category;
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

	Categories userCategoriesView;
	Projects userProjectsView;
	DetailedProject detailedProjectInfo;
	Storage<Quote> quotes;

	PageDispatcher(UserInterface ui, Storage<Category> categories,
			Storage<Project> projects, Storage<Quote> quotes) {

		this.ui = ui;
		this.categories = categories;
		this.projects = projects;
		this.quotes = quotes;
	}

	void cycleDispatcher() {
		
		while (true) {
			showRandomQuote();
			selectCategory();
		}
	}

	private void showRandomQuote() {
		Quote randomQuote = quotes.getRandom();
		ui.display("-----Quote------");
		ui.display(randomQuote.getQuote());
		ui.display("----------------");
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
		if(project==null){
			return;
		}
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

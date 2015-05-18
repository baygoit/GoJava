package kickstarter;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.interfaces.display.UserInterface;
import kickstarter.interfaces.pages.ChoicePage;
import kickstarter.interfaces.pages.Page;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.QuotesStorage;

public class Kickstarter {

	private UserInterface userInterface;
	private QuotesStorage quotes;
	private CategoriesStorage categories;
	private ProjectsStorage projects;

	public Kickstarter(UserInterface userInterface, QuotesStorage quotes, CategoriesStorage categories,
			ProjectsStorage projects) {
		this.userInterface = userInterface;
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}

	public void run() {
		showQuote();
		choiceCategory();
		showTheEnd();
	}

	private void showQuote() {
		Page page = UserInterface.PAGES.getShowRandomQuotePage(quotes);
		userInterface.showPage(page);
	}

	private void choiceCategory() {
		while (true) {
			ChoicePage page = UserInterface.PAGES.getChoiceCategoryPage(categories);
			userInterface.choiceItem(page);
			Category category = (Category) page.getChosenItem();
			if (category == Category.EXIT) {
				return;
			}
			choiceProject(category);
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			ChoicePage page = UserInterface.PAGES.getChoiceProjectPage(projects, category);
			userInterface.choiceItem(page);
			Project project = (Project) page.getChosenItem();
			if (project == Project.EXIT) {
				return;
			}
			showProject(project);
		}
	}

	private void showProject(Project project) {
		while (true) {
			ChoicePage page = UserInterface.PAGES.getShowProjectPage(project);
			userInterface.choiceItem(page);
			Project currentProject = (Project) page.getChosenItem();
			if (currentProject == Project.EXIT) {
				return;
			}
		}
	}

	private void showTheEnd() {
		Page page = UserInterface.PAGES.getTheEndPage();
		userInterface.showPage(page);
	}
}

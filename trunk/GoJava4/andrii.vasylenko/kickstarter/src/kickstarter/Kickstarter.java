package kickstarter;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.interfaces.display.UserInterface;
import kickstarter.interfaces.pages.ChoiceCategoryPage;
import kickstarter.interfaces.pages.ChoiceProjectPage;
import kickstarter.interfaces.pages.ShowProjectPage;
import kickstarter.interfaces.pages.ShowRandomQuotePage;
import kickstarter.interfaces.pages.TheEndPage;
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
		userInterface.showPage(new ShowRandomQuotePage(quotes));
	}

	private void choiceCategory() {
		while (true) {
			ChoiceCategoryPage page = new ChoiceCategoryPage(categories);
			userInterface.choiceItem(page);
			Category category = page.getChosenItem();
			if (category == Category.EXIT) {
				return;
			}
			choiceProject(category);
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			ChoiceProjectPage page = new ChoiceProjectPage(projects, category);
			userInterface.choiceItem(page);
			Project project = page.getChosenItem();
			if (project == Project.EXIT) {
				return;
			}
			showProject(project);
		}
	}

	private void showProject(Project project) {
		while (true) {
			ShowProjectPage page = new ShowProjectPage(project);
			userInterface.choiceItem(page);
			Project currentProject = page.getChosenItem();
			if (currentProject == Project.EXIT) {
				return;
			}
		}
	}

	private void showTheEnd() {
		userInterface.showPage(new TheEndPage());
	}
}

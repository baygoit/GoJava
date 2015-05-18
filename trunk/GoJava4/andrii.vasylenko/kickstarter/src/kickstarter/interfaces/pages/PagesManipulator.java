package kickstarter.interfaces.pages;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.QuotesStorage;

public class PagesManipulator {
	public Page getShowRandomQuotePage(QuotesStorage quotes) {
		return new ShowRandomQuotePage(quotes);
	}

	public Page getTheEndPage() {
		return new TheEndPage();
	}

	public ChoicePage getChoiceCategoryPage(CategoriesStorage categories) {
		return new ChoiceCategoryPage(categories);
	}

	public ChoicePage getChoiceProjectPage(ProjectsStorage projects, Category category) {
		return new ChoiceProjectPage(projects, category);
	}

	public ChoicePage getShowProjectPage(Project project) {
		return new ShowProjectPage(project);
	}
}

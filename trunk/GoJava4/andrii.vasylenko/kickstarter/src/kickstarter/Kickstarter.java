package kickstarter;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;

public class Kickstarter {

	private Model model;
	private View viewer;

	public Kickstarter(Model model, View viewer) {
		this.model = model;
		this.viewer = viewer;
	}

	public void run() {
		showQuote();
		choiceCategory();
		showTheEnd();
	}

	private void showQuote() {
		String quoteView = Quote.DISPLAY.getView(model.getRandomQuote());
		viewer.showQuoteDialog(quoteView);
	}

	private void choiceCategory() {
		while (true) {
			try {
				String categoriesView = Category.DISPLAY.getView(model.getCategoriesIterator());
				viewer.viewCategories(categoriesView);

				Category chosenCategory = model.getCategory(viewer.choiceItem());
				if (chosenCategory == Category.EXIT) {
					return;
				}
				choiceProject(chosenCategory);

			} catch (Exception ignore) {
				viewer.viewErrorMessage();
			}
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			try {
				String projectsView = Project.DISPLAY.getView(model.getProjectsIterator(category));
				viewer.viewProjects(projectsView);

				Project chosenProject = model.getProject(viewer.choiceItem(), category);
				if (chosenProject == Project.EXIT) {
					return;
				}
				showProject(chosenProject);

			} catch (Exception ignore) {
				viewer.viewErrorMessage();
			}
		}
	}

	private void showProject(Project project) {
		while (true) {
			try {
				String projectView = Project.DETAIL_DISPLAY.getView(project);
				viewer.viewProject(projectView);

				Project chosenItem = model.getProjectItem(viewer.choiceItem());
				if (chosenItem == Project.EXIT) {
					return;
				}

			} catch (Exception ignore) {
				viewer.viewErrorMessage();
			}
		}
	}

	private void showTheEnd() {
		viewer.viewTheEndMessage();
	}
}

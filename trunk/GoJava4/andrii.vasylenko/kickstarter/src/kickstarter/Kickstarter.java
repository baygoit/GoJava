package kickstarter;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.interfaces.Preparer;
import kickstarter.interfaces.menu.CategoriesMenu;
import kickstarter.interfaces.menu.ProjectsMenu;

public class Kickstarter {

	private Model model;
	private View viewer;
	private Preparer preparer;

	public Kickstarter(Model model, View viewer, Preparer preparer) {
		this.model = model;
		this.viewer = viewer;
		this.preparer = preparer;
	}

	public void run() {
		showQuote();
		choiceCategory();
		showTheEnd();
	}

	private void showQuote() {
		String quoteView = preparer.getQuoteView(model.getRandomQuote());
		viewer.showQuoteDialog(quoteView);
	}

	private void choiceCategory() {
		while (true) {
			try {
				String categoriesView = preparer.getCategoriesView(model.getCategoriesIterator());
				viewer.viewCategories(categoriesView);

				int chosenItem = viewer.choiceItem();
				if (chosenItem == CategoriesMenu.EXIT.getId()) {
					return;
				}

				Category chosenCategory = model.getCategory(chosenItem);
				choiceProject(chosenCategory);

			} catch (Exception ignore) {
				viewer.viewErrorMessage();
			}
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			try {
				String projectsView = preparer.getProjectsView(model.getProjectsIterator(category));
				viewer.viewProjects(projectsView);

				int chosenItem = viewer.choiceItem();
				if (chosenItem == ProjectsMenu.EXIT.getId()) {
					return;
				}

				Project chosenProject = model.getProject(chosenItem, category);
				showProject(chosenProject);

			} catch (Exception ignore) {
				viewer.viewErrorMessage();
			}
		}
	}

	private void showProject(Project project) {
		while (true) {
			try {
				String projectView = preparer.getProjectView(project);
				viewer.viewProject(projectView);

				int chosenItem = viewer.choiceItem();
				if (chosenItem == ProjectsMenu.EXIT.getId()) {
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

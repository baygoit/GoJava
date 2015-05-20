package kickstarter;

import kickstarter.engine.Category;
import kickstarter.engine.Project;

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
		viewer.viewQuote(model.getRandomQuote());
	}

	private void choiceCategory() {
		while (true) {
			try {
				viewer.viewCategories(model.getCategoriesIterator());

				Category chosenCategory = model.getCategory(viewer.choiceItem());
				if (chosenCategory == Category.EXIT) {
					return;
				}
				choiceProject(chosenCategory);

			} catch (Exception ignore) {
			}
			viewer.viewErrorMessage();
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			try {
				viewer.viewProjects(model.getProjectsIterator(category));

				Project chosenProject = model.getProject(viewer.choiceItem(), category);
				if (chosenProject == Project.EXIT) {
					return;
				}
				showProject(chosenProject);

			} catch (Exception ignore) {
			}
			viewer.viewErrorMessage();
		}
	}

	private void showProject(Project project) {
		while (true) {
			try {
				viewer.viewProject(project);

				Project chosenItem = model.getProjectItem(viewer.choiceItem());
				if (chosenItem == Project.EXIT) {
					return;
				}

			} catch (Exception ignore) {
			}
			viewer.viewErrorMessage();
		}
	}

	private void showTheEnd() {
		viewer.viewTheEndMessage();
	}
}

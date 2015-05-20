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
		viewer.view(model.getRandomQuote());
	}

	private void choiceCategory() {
		while (true) {
			try {
				viewer.view("--------------------");
				viewer.view("Choice Category:");
				viewer.view(model.getCategoryIterator());
				viewer.viewCategoryMenu();

				int itemId = viewer.choiceItem();
				Category category = model.getCategoryById(itemId);
				if (category == Category.EXIT) {
					return;
				}

				choiceProject(category);
			} catch (Exception ignore) {
			}
			viewer.view("--------------------");
			viewer.view("try again please");
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			try {
				viewer.view("--------------------");
				viewer.view("Choice Project:");
				viewer.viewP(model.getProjectIterator(category));
				viewer.viewProjectsMenu();

				int itemId = viewer.choiceItem();
				Project project = model.getProjectById(itemId);
				if (project == Project.EXIT) {
					return;
				}

				showProject(project);
			} catch (Exception ignore) {
			}
			viewer.view("--------------------");
			viewer.view("try again please");
		}
	}

	private void showProject(Project project) {
		while (true) {
			try {
				viewer.view("--------------------");
				viewer.view("Project:");
				viewer.view(project);
				viewer.viewProjectMenu();
				
				int itemId = viewer.choiceItem();
				Project currentProject = model.getProjectById(itemId);
				
				if (currentProject == Project.EXIT) {
					return;
				}
			} catch (Exception ignore) {
			}
			viewer.view("--------------------");
			viewer.view("try again please");
		}
	}

	private void showTheEnd() {
		viewer.view("---------");
		viewer.view("Good Luck!");
	}
}

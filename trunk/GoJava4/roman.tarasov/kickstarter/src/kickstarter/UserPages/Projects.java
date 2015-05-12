package kickstarter.UserPages;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Entities.Project;
import kickstarter.Repository.EntityStorage;
import kickstarter.Repository.Storage;

public class Projects {
	UserInterface ui;
	Storage<Project> projects;
	public Category targetCategory;

	public Projects(Storage<Project> projects, UserInterface ui) {
		this.projects = projects;
		this.ui = ui;
	}

	public Storage<Project> printProjects() {
		Storage<Project> projectsByCategory = new EntityStorage<Project>();
		int pointer = projects.length();
		for (int index = 0; index < pointer; index++) {
			if (projects.getEntity(index).category.id == targetCategory.id) {
				ui.display(projects.getEntity(index).id + "- "
						+ projects.getEntity(index).name);
				projectsByCategory.add(projects.getEntity(index));
			}
		}
		return projectsByCategory;
	}

	public Project selectProject() {
		ui.display("________________________");
		ui.display("|     Projects         |");
		ui.display("|______________________|");
		Storage<Project> options = printProjects();
		ui.display("------------------------");
		ui.display("Select Project:");
		while (true) {
			ui.display(" e- exit to Categories ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return null;
			}
			try {
				int parsed = Integer.parseInt(stringFromUI);
				for (int index = 0; index < options.length(); index++) {
					if (parsed == options.getEntity(index).id) {
						Project projectToDetailedView = options
								.getEntity(index);
						return projectToDetailedView;
					}
				}
				throw new IndexOutOfBoundsException();
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				ui.display("input correct command, please");
			}
		}
	}
}

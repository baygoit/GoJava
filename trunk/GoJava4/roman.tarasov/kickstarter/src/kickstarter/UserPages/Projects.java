package kickstarter.UserPages;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Entities.Project;
import kickstarter.Repository.EntityStorage;
import kickstarter.Repository.Storage;

public class Projects {
	private UserInterface ui;
	private Storage<Project> projects;
	public Category targetCategory;

	public Projects(Storage<Project> projects, UserInterface ui) {
		this.projects = projects;
		this.ui = ui;
	}

	public Storage<Project> sortProjectsByCategory() {
		Storage<Project> sortedProjects = new EntityStorage<Project>();
		int pointer = projects.length();
		for (int index = 0; index < pointer; index++) {
			if (projects.getEntity(index).categoryID == targetCategory.id) {
				sortedProjects.add(projects.getEntity(index));
			}
		}
		return sortedProjects;
	}

	void printProjectsInfo(Storage<Project> sortedToSelect) {
		for (int index = 0; index < sortedToSelect.length(); index++) {
			Project project = sortedToSelect.getEntity(index);
			ui.display("ID:<" + project.id + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription
					+ "> goal:<" + project.goal + "> pledged:<"+project.pledged+"> days to go:<"+project.daysToGo+">");
		}
	}

	public Project selectProject() {
		ui.display("________________________");
		ui.display("|     Projects         |");
		ui.display("|______________________|");
		Storage<Project> sortedToSelect = sortProjectsByCategory();
		printProjectsInfo(sortedToSelect);

		ui.display("------------------------");
		ui.display("Select Project by ID:");
		while (true) {
			ui.display(" e- exit to Categories ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return null;
			}
			try {
				int parsed = Integer.parseInt(stringFromUI);
				for (int index = 0; index < sortedToSelect.length(); index++) {
					if (parsed == sortedToSelect.getEntity(index).id) {
						Project projectToDetailedView = sortedToSelect
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

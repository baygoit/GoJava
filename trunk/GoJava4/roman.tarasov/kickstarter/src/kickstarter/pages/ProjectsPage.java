package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;
import kickstarter.ui.UserInterface;

public class ProjectsPage extends Page {
	private UserInterface ui;
	private Storage<Project> projects;
	int targetCategoryID;
	int[] parameterForPrint;

	public ProjectsPage(Storage<Project> projects, UserInterface ui) {
		this.projects = projects;
		this.ui = ui;
	}

	public void print(int[] parameterForPrint) {
		this.parameterForPrint = parameterForPrint;
		targetCategoryID = parameterForPrint[0];

		ui.display("________________________");
		ui.display("|     Projects         |");
		ui.display("|______________________|");

		selectProject();

		ui.display("------------------------");
	}

	public Storage<Project> sortProjectsByCategory() {
		Storage<Project> sortedProjects = new EntityStorage<Project>();
		int pointer = projects.length();
		for (int index = 0; index < pointer; index++) {
			if (projects.getEntity(index).categoryID == targetCategoryID) {
				sortedProjects.add(projects.getEntity(index));
			}
		}
		return sortedProjects;
	}

	void printProjectsInfo(Storage<Project> sortedToSelect) {
		options = new int[sortedToSelect.length()];
		for (int index = 0; index < sortedToSelect.length(); index++) {
			Project project = sortedToSelect.getEntity(index);
			options[index] = project.ID;
			ui.display("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");
		}
	}

	public int[] getOptions() {
		return options;
	}

	public void selectProject() {
		Storage<Project> sortedToSelect = sortProjectsByCategory();
		printProjectsInfo(sortedToSelect);
	}
}

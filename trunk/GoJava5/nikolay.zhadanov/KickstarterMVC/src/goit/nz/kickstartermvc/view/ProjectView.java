package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.output.Output;

public class ProjectView {

	private Output output;

	public ProjectView(Output output) {
		this.output = output;
	}

	public void printProject(ProjectModel model) {
		Project chosenProject = model.getProject();
		if (chosenProject == null) {
			printProjectNotFound();
		} else {
			printTitle(chosenProject.getName());
			printProjectDetails(chosenProject);
			printOptions();
		}
	}

	private void printProjectNotFound() {
		showMsg("NPE case - model haven't returned the project");
		showMsg("[0 - Back]");
	}

	public void showMsg(String msg) {
		output.println("");
		output.println(msg);
	}

	private void printProjectDetails(Project project) {
		output.println(String.format("     Description: %s",
				project.getDescription()));
		output.println(String.format("     Goal: %s", project.getGoalAmount()));
		output.println(String.format("     Pledged: %s",
				project.getPledgedAmount()));
		output.println(String.format("     Days to go: %s",
				project.getDaysToGo()));
		output.println("     Project Events:");
		output.println(project.getEvents());
		output.println(String.format("     Link to video: %s",
				project.getLink()));
		output.println("     Project FAQ:");
		output.println(project.getFAQ());
	}

	private void printTitle(String projectName) {
		output.println("");
		output.println(String.format("Overview of project: \"%s\"",
				projectName.toUpperCase()));
		output.println("-------------------");
	}

	private void printOptions() {
		output.println("");
		output.println("Choose your option:");
		output.println("[1 - Invest]");
		output.println("[0 - Back]");
	}
}

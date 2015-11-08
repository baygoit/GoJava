package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.dao.FAQ;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.ProjectEvent;
import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.output.Output;

import java.util.List;

public class ProjectView {

	private Output output;

	public ProjectView(Output output) {
		this.output = output;
	}

	public void printProject(ProjectModel model) {
		Project chosenProject = model.getProject();
		printTitle(chosenProject.getName());
		printProjectDetails(chosenProject);
		printOptions();
	}

	public void showMsg(String message) {
		output.write("");
		output.write(message);
	}

	private void printProjectDetails(Project project) {
		output.write(String.format("     Description: %s",
				project.getDescription()));
		output.write(String.format("     Goal: %s", project.getGoalAmount()));
		output.write(String.format("     Pledged: %s",
				project.getPledgedAmount()));
		output.write(String.format("     Days to go: %s", project.getDaysToGo()));
		output.write("     Project Events:");
		List<ProjectEvent> events = project.getEvents();
		if (events.size() > 0) {
			for (ProjectEvent event : events) {
				output.write(event.getDescription());
			}
		}
		output.write(String.format("     Link to video: %s", project.getLink()));
		output.write("     Project FAQ:");
		List<FAQ> projectFAQ = project.getFAQ();
		if (projectFAQ.size() > 0) {
			for (FAQ faq : project.getFAQ()) {
				output.write(String.format("Q: %s", faq.getQuestion()));
				output.write(String.format("A: %s", faq.getAnswer()));
			}
		}
	}

	private void printTitle(String projectName) {
		output.write("");
		output.write(String.format("Overview of project: \"%s\"",
				projectName.toUpperCase()));
		output.write("-------------------");
	}

	private void printOptions() {
		output.write("");
		output.write("Choose your option:");
		output.write("[1 - Invest]");
		output.write("[2 - Ask question]");
		output.write("[0 - Back]");
	}
}

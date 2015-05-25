package ua.com.goit.gojava.kickstarter.view;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;

public class ProjectsViewer {

	Printer printer;
	Reader reader;
	ProjectsRepository projectsRepository;

	public ProjectsViewer(Printer printer) {
		this.printer = printer;
		this.reader = new ConsoleInputReader();
	}

	public void showProjectInfo(Project project) {
		printer.println(project.getName());
		printer.println("  Short Description: " + project.getShortDescription());
		printer.println("  Pledged: " + project.getPledged());
		printer.println("  Days to go: " + project.getDaysToGo());
		printer.println("  History: " + project.getFullDescription());
		printer.println("  Video link: " + project.getLink());
		printer.println("  Questions/Answers " + project.getFAQ());
	}

	public void showProjectsOfCategory(Category category,
			ArrayList<Project> projectsOfCurrentCategory) {

		//printer.println("Category: " + category.getName());
		printer.println(" Projects: ");
		for (int i = 0; i < projectsOfCurrentCategory.size(); i++) {
			printer.print("  " + (i + 1) + ": ");
			Project currentProject = projectsOfCurrentCategory.get(i);
			printer.println(currentProject.getName());
			printer.println("  Short Description: " + currentProject.getShortDescription());
			printer.println("  Pledged: " + currentProject.getPledged());
			printer.println("  Days to go: " + currentProject.getDaysToGo());
		}
	}
}

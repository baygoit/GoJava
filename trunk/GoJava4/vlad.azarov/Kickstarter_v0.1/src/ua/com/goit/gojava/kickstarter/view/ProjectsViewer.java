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

	public void showProjectInfo(Project project, Category category) {
	    	printer.println("CATEGORIES > " + category.name() + " > " + project.getName());
		printer.println(project.getName() + ": ");
		printer.println("\t Short Description: " + project.getShortDescription());
		printer.println("\t Pledged: " + project.getPledged());
		printer.println("\t Days to go: " + project.getDaysToGo());
		printer.println("\t History: " + project.getFullDescription());
		printer.println("\t Video link: " + project.getLink());
		printer.println("\t Questions/Answers: " + project.getFAQ());
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

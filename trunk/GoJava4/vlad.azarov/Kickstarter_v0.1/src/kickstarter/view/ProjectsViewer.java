package kickstarter.view;

import java.util.ArrayList;

import kickstarter.model.Category;
import kickstarter.model.Project;
import kickstarter.printer.Printer;
import kickstarter.reader.ConsoleReader;
import kickstarter.reader.Reader;
import kickstarter.repos.ProjectsRepo;

public class ProjectsViewer {

    Printer printer;
    Reader reader;
    ProjectsRepo projectsRepo;

    public ProjectsViewer(Printer printer) {
	this.printer = printer;
	this.reader = new ConsoleReader();
	this.projectsRepo = new ProjectsRepo();
    }

    public void showAllProjectsOfCategory(Category category) {
	printer.print("--------------------------------------------------------------------\n");
	printer.println("CATEGORIES > " + category.getName());
	printer.print("--------------------------------------------------------------------\n");
	ArrayList<Project> tempArray = projectsRepo.getProjects(category);
	int index = 0;
	for (Project project : tempArray) {
	    index++;
	    printer.println("\t [" + index + "]" + project.getName());
	}
	printer.print("\n\t Choose the project: \n");
    }

    public void showDetailProject(Category category, Project project) {
	printer.print("--------------------------------------------------------------------\n");
	printer.println("CATEGORIES > " + category.getName() + " > "
		+ project.getName());
	printer.print("--------------------------------------------------------------------\n");
	printer.println("\t Name: " + project.getName());
	printer.println("\t Short Description: "
		+ project.getShortDescription());
	printer.println("\t Pledged: " + project.getPledged());
	printer.println("\t Days to go: " + project.getDaysToGo());
	printer.println("\t History: " + project.getFullDescription());
	printer.println("\t Video link: " + project.getLink());
    }
}

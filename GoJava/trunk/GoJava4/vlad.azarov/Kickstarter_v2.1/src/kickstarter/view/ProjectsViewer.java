package kickstarter.view;

import java.util.ArrayList;

import kickstarter.model.Category;
import kickstarter.model.Project;
import kickstarter.printer.Printer;
import kickstarter.reader.ConsoleReader;
import kickstarter.reader.Reader;
import kickstarter.repos.CategoriesRepo;
import kickstarter.repos.ProjectsRepo;

public class ProjectsViewer {

    Printer printer;
    Reader reader;
    Category category;
    ProjectsRepo projectsRepo;
    //CategoriesRepo categoriesRepo;

    public ProjectsViewer(Printer printer) {
	this.printer = printer;
	this.reader = new ConsoleReader();
	this.projectsRepo = new ProjectsRepo();
	//this.categoriesRepo = new CategoriesRepo();
    }
    
    public void showAllProjectsOfCategory(String categoryName) {
	printer.print("--------------------------------------------------------------------\n");
	printer.println("CATEGORIES > " + categoryName);
	printer.print("--------------------------------------------------------------------\n");
	
//	if (categoryName.equals(categoriesRepo.getCategory(categoryName))) {
//	    Category particularCategory = categoriesRepo.getCategory(categoryName);
//	}
	
	ArrayList<Project> tempArray = projectsRepo.getProjects(categoryName);
	int index = 0;
	for (Project project : tempArray) {
	    index++;
	    printer.println("\t [" + index + "] " + project.getName());
	}
	printer.println("\t [0] CATEGORIES");
	
 	
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

    public void showDetailProject(String categoryName, String projectName) {
	printer.print("--------------------------------------------------------------------\n");
	printer.println("CATEGORIES > " + categoryName + " > "
		+ projectName);
	printer.print("--------------------------------------------------------------------\n");
	Project project = projectsRepo.getProject(projectName);
	printer.println("\t Name: " + project.getName());
	printer.println("\t Short Description: "
		+ project.getShortDescription());
	printer.println("\t Pledged: " + project.getPledged());
	printer.println("\t Days to go: " + project.getDaysToGo());
	printer.println("\t History: " + project.getFullDescription());
	printer.println("\t Video link: " + project.getLink());
	
	
    }

 
}

package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ua.com.goit.gojava.kickstarter.model.CategoriesRepository;
import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.model.QuotesRepository;

public class Kickstarter {

    public static int DEFAULT_INPUT = -1;

    public void run() {
	
	QuotesControl quotesControl = new QuotesControl();
	CategoriesControl categoriesControl = new CategoriesControl();
	
	boolean isExit = false;
	while (!isExit) {
	    quotesControl.callToShowQuoteMenu();
	    categoriesControl.showCategories();
	    
	    System.out.print("Choose category or print 0 to exit: ");

	    int userInput = DEFAULT_INPUT;
	    userInput = readUserInput();
	    ArrayList <Category> categories = categoriesControl.getCategories();
	    if (userInput == 0) {
		isExit = true;
	    } else if (userInput > 0 && userInput <= categories.size()) {
		showCategoryMenu(categories.get(userInput-1));
	    } else {
		System.out.println("No such category.");
	    }
	}
    }

    public static int readUserInput() {
	int result = DEFAULT_INPUT;
	try {
	    result = new Scanner(System.in).nextInt();
	} catch (InputMismatchException e) {
	    e.printStackTrace();
	}
	System.out.println();
	return (result >= DEFAULT_INPUT) ? result : DEFAULT_INPUT;
    }

    public static void showCategoryMenu(Category category) {
	ProjectsControl projectsControl = new ProjectsControl();
	ArrayList <Project> projectsOfCurrentCategory = projectsControl.getProjectsByCategory(category);

	while (true) {
	    showProjectsOfCategory(category);

	    System.out.println();
	    System.out.println("Press 0 for exit from this category");
	    System.out
		    .println("====================================================================");

	    int keyCode = readUserInput();
	    if (keyCode == 0) {
		break;
	    } else {
		if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.size()) {
		    Project selectedProject = projectsOfCurrentCategory.get(keyCode);
		    showProjectMenu(selectedProject);
		} else {
		    System.out.println("Project with #" + keyCode
			    + " does not exist");
		}
	    }
	}
    }

    private static void showProjectsOfCategory(Category category) {
	System.out.println("Category: " + category.getName());
	System.out.println(" Projects: ");
	ProjectsControl projectsControl = new ProjectsControl();
	ArrayList <Project> projectsOfCurrentCategory = projectsControl.getProjectsByCategory(category);
	for (int i = 0; i < projectsOfCurrentCategory.size(); i++) {
	    System.out.print("  " + (i + 1) + ": ");
	    Project currentProject = projectsOfCurrentCategory.get(i);
	    System.out.println(currentProject.getName());
	    System.out.println("  Short Description: "
		    + currentProject.getBrief());
	    System.out.println("  Pledged: "
		    + currentProject.getPledged());
	    System.out.println("  Days to go: "
		    + currentProject.getDaysToGo());
	}
    }

    public static void showProjectInfo(Project project) {
	System.out.println(project.getName());
	System.out.println("  Short Description: " + project.getBrief());
	System.out.println("  Pledged: " + project.getPledged());
	System.out.println("  Days to go: " + project.getDaysToGo());
	System.out.println("  History: " + project.getDescription());
	System.out.println("  Video link: " + project.getLink());
	System.out.println("  Questions/Answers " + project.getFAQ());
    }

    private static void showProjectMenu(Project project) {
	while (true) {

	    showProjectInfo(project);

	    System.out.println();
	    System.out.println("Press 0 to return back");
	    System.out
		    .println("------------------------------------------------------------------");

	    int keyCode = readUserInput();
	    if (keyCode == 0) {
		break;
	    } else {
		System.out.println("Wrong code!");
	    }
	}

    }

}

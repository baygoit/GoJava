package launcher;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Category;
import entities.Project;
import entities.Quotes;

public class RunKickstarter {

    public static int DEFAULT_INPUT = -1;

    public static void main(String[] args) {

	Category designCategory = new Category("DESIGN");
	Category technologyCategory = new Category("TECHNOLOGY");

	Project designProject01 = new Project(
		"SNAP",
		"Design Your Own Furniture",
		15000,
		27000,
		30,
		"With SNAP you can create endless solutions for your living space. You can "
			+ "transform any surface into a unique piece of furniture.",
		"http://www.youtube.com/01",
		"How do I choose the color combination?");
	Project designProject02 = new Project("HYDAWAY",
		"A Pocket-Sized Water Bottle Fit for any Adventure", 20000,
		181437, 3,
		"HYDAWAY is a handy alternative to disposable plastic water bottles - it folds"
			+ "down easily to fit in almost any pocket!",
		"http://www.youtube.com/0143534",
		"How much is the bottle weight");
	Project designProject03 = new Project(
		"Dash 4.0 Wallet",
		"A Minimal Wallet Redefined",
		5000,
		46848,
		52,
		"The ORIGINAL quickdraw wallet for minimalists. Carry the things you need, and "
			+ "access them easily.",
		"http://www.youtube.com/0143534",
		"What are the dimensions of the wallet?");
	Project designProject04 = new Project(
		"USB ChargeDoubler",
		"Double your charging speed!",
		2750,
		2140,
		32,
		"THE ORIGINAL Up to 200% charging speed for iPhoneÂ & Android. No data theft. "
			+ "The magnetic usb cable for your keyring.",
		"http://www.youtube.com/0143534", "Have a question?");
	Project[] designProjects = { designProject01, designProject02,
		designProject03, designProject04 };

	Project technologyProject01 = new Project(
		"FireFly Hand",
		"Light up your life",
		3500,
		470,
		25,
		"FireFly Hand is the next generation electric "
			+ "flashlight, which is capable of making your life significantly easier.â€‹",
		"http://www.youtube.com/0143534", "Have a question?");
	Project technologyProject02 = new Project(
		"Cubit",
		"The Make Anything Platform",
		50000,
		169,
		34,
		"A platform that brings together plug & play hardware and drag & drop software "
			+ "to allow everyone to create and invent!",
		"http://www.youtube.com/0143534", "Have a question?");
	Project technologyProject03 = new Project(
		"Noki",
		"The smart doorlock for Europe",
		125000,
		119082,
		44,
		"Noki is the first smart doorlock for Europe. It opens your door when you come "
			+ "home and locks it when you leave.",
		"http://www.youtube.com/031234", "Have a question?");
	Project[] technologyProjects = { technologyProject01,
		technologyProject02, technologyProject03 };

	designCategory.setProjects(designProjects);
	technologyCategory.setProjects(technologyProjects);
	Category[] categoryArray = { designCategory, technologyCategory };

	boolean isExit = false;
	while (!isExit) {
	    Quotes quotes = new Quotes();
	    quotes.showQuoteMenu();
	    showCategories(categoryArray);
	    System.out.print("Choose category or print 0 to exit: ");

	    int userInput = DEFAULT_INPUT;
	    userInput = readUserInput();
	    if (userInput == 0) {
		isExit = true;
	    } else if (userInput > 0 && userInput <= categoryArray.length) {
		showCategoryMenu(categoryArray[userInput - 1]);
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
	return (result >= DEFAULT_INPUT) ? result : DEFAULT_INPUT;
    }

    public static void showCategories(Category[] categories) {
	System.out.println("Select category: ");
	for (int i = 0; i < categories.length; i++) {
	    System.out.println(i + 1 + ": " + categories[i].getName());
	}
    }

    public static void showCategoryMenu(Category category) {
	Project[] projectsOfCurrentCategory = category.getProjects();

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
		if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.length) {
		    Project selectedProject = projectsOfCurrentCategory[keyCode - 1];
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
	Project[] currentCategoryProjects = category.getProjects();
	for (int i = 0; i < currentCategoryProjects.length; i++) {
	    System.out.print("  " + (i + 1) + ": ");
	    System.out.println(currentCategoryProjects[i].getName());
	    System.out.println("  Short Description: "
		    + currentCategoryProjects[i].getBrief());
	    System.out.println("  Pledged: "
		    + currentCategoryProjects[i].getPledged());
	    System.out.println("  Days to go: "
		    + currentCategoryProjects[i].getDaysToGo());
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

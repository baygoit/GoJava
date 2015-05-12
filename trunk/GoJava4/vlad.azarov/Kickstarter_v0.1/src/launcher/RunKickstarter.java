package launcher;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.*;
import storages.*;

public class RunKickstarter {

	public static int DEFAULT_INPUT = -1;

	public static void main(String[] args) {

		Category videoCategory = new Category("Video");
		Category designCategory = new Category("Design");

		Project videoProject01 = new Project("Some video project #1", 0001,
				"Short description", 5000, 365, "Long description", null, null);
		Project videoProject02 = new Project("Some video project #2", 0002,
				"Short description", 250000, 25, "Long description", null, null);
		Project videoProject03 = new Project("Some video project #3", 0003,
				"Short description", 500150, 96, "Long description", null, null);
		Project videoProject04 = new Project("Some video project #4", 0004,
				"Short description", 1000000, 96, "Long description", null,
				null);
		Project[] videoProjects = { videoProject01, videoProject02,
				videoProject03, videoProject04 };

		Project designProject01 = new Project("Some design roject #1", 0005,
				"Short description", 1000000, 226, "Long description", null,
				null);
		Project designProject02 = new Project("Some design roject #2", 0006,
				"Short description", 100, 3, "Long description", null, null);
		Project designProject03 = new Project("Some design roject #3", 0007,
				"Short description", 5600, 26, "Long description", null, null);
		Project[] designProjects = { designProject01, designProject02,
				designProject03 };

		videoCategory.setProjects(videoProjects);
		designCategory.setProjects(designProjects);
		Category[] categoryArray = { videoCategory, designCategory };

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
					.println("==============================================");

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
			System.out.println("  Short Description: " + currentCategoryProjects[i].getBrief() );
			System.out.println("  Pledged: " + currentCategoryProjects[i].getPledged());
			System.out.println("  Days to go: " + currentCategoryProjects[i].getDaysToGo());
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
		while(true) {
			
			showProjectInfo(project);
			
			System.out.println();
			System.out.println("Press 0 to return back");
			System.out.println("-------------------------------------------");
			
			int keyCode = readUserInput();
			if (keyCode == 0) {
				break;
			} else {
				System.out.println("Wrong code!");
			}
		}
		
	}
	
	

}

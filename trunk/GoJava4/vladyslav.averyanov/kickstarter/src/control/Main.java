package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

import model.Category;
import model.Project;
import model.Quote;
import control.QuoteControl;
import view.ConsolePrinter;

public class Main {

	public static int DEFAULT_VALUE = -1;

	public static void main(String[] args) {
		
		QuoteControl quoteControl = new QuoteControl(); 
		CategoryControl categoryControl = new CategoryControl();
		ProjectControl projectControl = new ProjectControl();
		
		projectControl.getProjects(categoryControl.)
		
		ConsolePrinter consolePrinter = new ConsolePrinter();

		Project[] videoProjects = { firstVideoProject, secondVideoProject,
				thirdVideoProject, fourthVideoProject };

		Category[] categoryArray = { videoCategory, audioCategory };

		boolean isExit = false;
		while (!isExit) {
			consolePrinter.print(quoteControl.getRandomQuote());
			showCategories(categoryArray);
			System.out.print("Please choose category or print 0 to exit: ");

			int userInput = DEFAULT_VALUE;
			userInput = readUserInput();
			if (userInput == 0) {
				isExit = true;
			} else if (userInput > 0 && userInput <= categoryArray.length) {
				showCategoryMenu(categoryArray[userInput-1]);
			} else {
				System.out.println("No such category.");
			}
		}
	}

	public static int readUserInput() {
		int result = DEFAULT_VALUE;
		try {
			result = new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return (result >= DEFAULT_VALUE) ? result : DEFAULT_VALUE;
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
			System.out.println("--------------------------------------------");

			int keyCode = readUserInput();
			if (keyCode == 0) {
				break;
			} else {
				if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.length) {
					Project selectedProject = projectsOfCurrentCategory[keyCode - 1];
					showProjectMenu(selectedProject);
				} else {
					System.out.println("Project with ¹" + keyCode
							+ " does not exist");
				}
			}
		}
	}

	public static void showProjectsOfCategory(Category category) {
		System.out.println("Category: " + category.getName());
		System.out.println("  Projects: ");
		Project[] currentCategoryProjects = category.getProjects();
		for (int i = 0; i < currentCategoryProjects.length; i++) {
			System.out.print("  " + (i + 1) + ": ");
			System.out.println(currentCategoryProjects[i].getName());
			System.out.println(" Short Description: "
					+ currentCategoryProjects[i].getShortDescription());
			System.out.println(" Needed amount: "
					+ currentCategoryProjects[i].getNeededAmount());
			System.out.println(" Current money: "
					+ currentCategoryProjects[i].getCurrentAmount());
			System.out.println(" Days left: "
					+ currentCategoryProjects[i].getDaysLeft());
		}
	}

	public static void showProjectInfo(Project project) {
        System.out.println(project.getName());
        System.out.println(" Short Description: " + project.getShortDescription());
        System.out.println(" Needed amount: " + project.getNeededAmount());
        System.out.println(" Current money: " + project.getCurrentAmount());
        System.out.println(" Days left: " + project.getDaysLeft());
        System.out.println(" History: " + project.getHistory());
        //System.out.println(" Video URL: " + project.getUrlVideo());
        System.out.println(" Questions And Answers: ");
        for (String s : project.getQuestionsAndAnswers()) {
            System.out.println("  " + s);
        }
    }

	public static void showProjectMenu(Project project) {
		while (true) {

			showProjectInfo(project);

			System.out.println();
			System.out.println("Press 0 to return back");
			System.out.println("--------------------------------------------");

			int keyCode = readUserInput();
			if (keyCode == 0) {
				break;
			} else {
				System.out.println("Wrong code!");
			}
		}
	}

}

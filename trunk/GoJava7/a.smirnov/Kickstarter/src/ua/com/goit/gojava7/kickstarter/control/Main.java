package ua.com.goit.gojava7.kickstarter.control;

import java.util.List;
import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.view.PrinterCategory;
import ua.com.goit.gojava7.kickstarter.view.PrinterProject;
import ua.com.goit.gojava7.kickstarter.view.PrinterQuotes;

public class Main {

	private static final String CHOOSE_CATEGORY = "Please, choose neccessary category: \n";
	private static final String USER_CHOICE = "You chose category: ";
	private static final String WRONG_CHOICE = "You chose mismatch option. So try again \n";

	private Scanner in = null;
	private int userChoice;
	private String chooseCategoryName;

	public static void main(String[] args) {

		QuoteDAO allQuotes = new QuoteDAO();
		CategoryDAO allCategories = new CategoryDAO();
		ProjectDAO allProjects = new ProjectDAO();

		PrinterCategory printerCategory = new PrinterCategory();
		PrinterProject printerProject = new PrinterProject();
		PrinterQuotes printerQuotes = new PrinterQuotes();

		new Main().showMenu(allCategories, allProjects);
		printerProject.printProjectsFromCategory(allProjects, new Main().getChooseCategoryName());
	}

	public void showMenu(CategoryDAO categories, ProjectDAO projects) {
		boolean UserAccurancy = true;

		while (UserAccurancy) {
			try {
				System.out.println(setStartMenu(categories));
				in = new Scanner(System.in);
				userChoice = in.nextInt();
				System.out.println(USER_CHOICE + chooseCategoryName);
				UserAccurancy = false;
			} catch (Exception e) {
				System.out.println(WRONG_CHOICE);
			}
		}
	}

	private String setStartMenu(CategoryDAO allCategories) {
		StringBuilder result = new StringBuilder();
		result.append(CHOOSE_CATEGORY);
		List<Category> categories = allCategories.getDataSource();
		int length = categories.size();

		for (int index = 0; index < length; index++) {
			if (index == length - 1) {
				result.append(index + 1).append(". ").append(categories.get(index).getName());
			} else {
				result.append(index + 1).append(". ").append(categories.get(index).getName()).append("\n");
			}
		}
		return result.toString();
	}

	private void findCategoryName(CategoryDAO allCategories) {
		List<Category> categories = allCategories.getDataSource();
		for (int index = 0; index < categories.size(); index++) {
			if (userChoice == index + 1) {
				chooseCategoryName = categories.get(index).getName();
			}
		}
	}
	
	
	public  String getChooseCategoryName() {
		return chooseCategoryName;
	}
	
}

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

public class Kickstarter {

	private static final String CHOOSE_CATEGORY = "Please, choose neccessary category: \n";
	private static final String USER_CHOICE = "You chose category: ";
	private static final String WRONG_CHOICE = "You chose mismatch option. So try again \n";
	private static final String CATEGORY_PROJECTS = "This category has folowing projects: \n";
	private static final String SEPARATOR = "=========================\n";
	private static final PrinterProject PRINTER_PROJECT = new PrinterProject();
	private static final PrinterQuotes PRINTER_QUOTE = new PrinterQuotes();


	public static void main(String[] args) {

		CategoryDAO allCategories = new CategoryDAO();
		ProjectDAO allProjects = new ProjectDAO();
		QuoteDAO allQuotes = new QuoteDAO();
		
		PRINTER_QUOTE.printRandomQuote(allQuotes);
		System.out.print(SEPARATOR);
		new Kickstarter().showMenu(allCategories, allProjects);
		
	}

	public void showMenu(CategoryDAO categories, ProjectDAO projects) {
		boolean UserAccurancy = true;

		while (UserAccurancy) {
			try {
				System.out.println(setStartMenu(categories));
				Scanner in = new Scanner(System.in);
				int userChoice = in.nextInt();
				StringBuilder result = new StringBuilder();
				
				while (UserAccurancy) {
					switch (userChoice) {
					case 1: {
						result.append(USER_CHOICE).
							append("Arts").
							append("\n").
							append(SEPARATOR).
							append(CATEGORY_PROJECTS).
							append(PRINTER_PROJECT.printProjectsFromCategory(projects, "Arts"));
						System.out.println(result.toString());
						UserAccurancy = false;
					};break;
					case 2: {
						result.append(USER_CHOICE).
							append("Music").
							append("\n").
							append(SEPARATOR).
							append(CATEGORY_PROJECTS).
							append(PRINTER_PROJECT.printProjectsFromCategory(projects, "Music"));
						System.out.println(result.toString());
						UserAccurancy = false;
					};break;
					case 3: {
						result.append(USER_CHOICE).
							append("Sports").
							append("\n").
							append(SEPARATOR).
							append(CATEGORY_PROJECTS).
							append(PRINTER_PROJECT.printProjectsFromCategory(projects, "Sports"));
						System.out.println(result.toString());
						UserAccurancy = false;
					};break;
					case 4: {
						result.append(USER_CHOICE).
							append("Culture").
							append("\n").
							append(SEPARATOR).
							append(CATEGORY_PROJECTS).
							append(PRINTER_PROJECT.printProjectsFromCategory(projects, "Culture"));
						System.out.println(result.toString());
						UserAccurancy = false;
					};break;
					case 5: {
						result.append(USER_CHOICE).
							append("Movie").
							append("\n").
							append(SEPARATOR).
							append(CATEGORY_PROJECTS).
							append(PRINTER_PROJECT.printProjectsFromCategory(projects, "Movie"));
						System.out.println(result.toString());
						UserAccurancy = false;
					};break;
					default:
						System.out.println(WRONG_CHOICE);
					}
				}
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
}

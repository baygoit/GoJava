package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class PrinterCategory {
	private static final String CHOOSE_CATEGORY = "You choose category: ";
	private static final String MAKE_CHOISE = "Please, make a choise: ";
	private List<Category> listOfCategories = null;
	private Scanner in = null;
	
	public void showMenuToChooseCategory(CategoryDAO categories, ProjectDAO projects) {
		boolean UserAccurancy = true;
		
		while(UserAccurancy) {
			try {
				System.out.println(MAKE_CHOISE);
				printAllCategories(categories);
				in = new Scanner(System.in);
				int chooseNumber = in.nextInt();
				
				Category userChoice = listOfCategories.get(chooseNumber - 1);
				System.out.println(CHOOSE_CATEGORY + userChoice.getName());
				
				UserAccurancy = false;
			} catch (Exception e) {
				System.out.println("Problems...");
			} finally {
				in.close();
			}
		}
	}
	
	public void printAllCategories(CategoryDAO storageOfCategories) {
		listOfCategories = storageOfCategories.getDataSource();
		int amountOfCategories = listOfCategories.size();
		StringBuilder result = new StringBuilder();
		
		for (int index = 0; index < amountOfCategories; index++) {
			result.append(index + 1).append(". ").append(listOfCategories.get(index).getName()).append("\n");
		}
		
		System.out.println(result.toString());
	}
}

package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoriesStorage;

public class PrinterCategory {
	private static final String CHOOSE_CATEGORY = "You choose category: ";
	private static final String MAKE_CHOISE = "Please, make a choise: ";
	private String userChoice = "";
	private List<Category> listOfCategories = null;
	private Scanner scanner;
	private PrinterProject printerProject;
	
	public void showMenu() {
		boolean flag = true;
		
		while(flag) {
			try {
				System.out.println(MAKE_CHOISE);
				printAllCategories();
				scanner = new Scanner(System.in);
				int chooseNumber = scanner.nextInt();
				
				userChoice = listOfCategories.get(chooseNumber - 1).getName(); 
				System.out.println(CHOOSE_CATEGORY + userChoice);
				printerProject.printProjectsFromCategory(userChoice);
				
				flag = false;
			} catch (Exception e) {
				System.out.println("Problems...");
			}
		}
	}
	
	private void printAllCategories() {
		CategoriesStorage storageOfQuotes = new CategoriesStorage();

		listOfCategories = storageOfQuotes.getDataSource();
		int amountOfCategories = listOfCategories.size();
		StringBuilder result = new StringBuilder();
		for (int index = 0; index < amountOfCategories; index++) {
			result.append(index + 1).append(". ").append(listOfCategories.get(index).getName()).append("\n");
		}
		System.out.println(result.toString());
	}
	
	public String getUserChoice() {
		return userChoice;
	}
	
	
}

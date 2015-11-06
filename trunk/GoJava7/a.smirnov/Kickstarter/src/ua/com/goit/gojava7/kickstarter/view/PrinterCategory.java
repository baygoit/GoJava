package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class PrinterCategory {
	private List<Category> listOfCategories = null;
	
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

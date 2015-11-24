package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryPrinter {
	
	public void printCategories(List<Category> categories) {
		//TODO cut
		System.out.println("categories.size() " );
		System.out.print(categories.size());
		for (int i = 0; i < categories.size(); i++) {
			System.out.println(i + 1 + ": " + categories.get(i).getName());
		}
	}	
}

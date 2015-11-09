package ua.com.goit.gojava7.kickstarter.console;

import java.util.ArrayList;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {
	public void print(Quote quote) {
		System.out.println(quote.getText() + " " + quote.getAuthor());
	}
	
	public void print(ArrayList<Category> categories) {
		System.out.println(categories.size() + 
				" diverse categories. Thousands of amazing projects.");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println((i + 1) + ". " + category.getName());
		}
	}
	
	public void print(Category category) {
		System.out.println(category);
	}
	
	public void print (String string) {
		System.out.println(string);
	}
}

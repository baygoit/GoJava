package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {

	public void print(Quote quote) {
		System.out.println(quote.getText() + " " + quote.getAuthor());
	}

	public void print(List<Category> categories) {
		System.out.println("All categories:");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println(i + " : " + category.getName());
		}
	}

	public void print(String string) {
		System.out.println(string);
	}
}

package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public final class ConsolePrinter {

	private ConsolePrinter() {

	}

	public static void print(Quote quote) {
		System.out.println(quote.getText() + " " + quote.getAuthor());
	}

	public static void print(List<Category> categories) {
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println(i + " : " + category.getName());
		}
	}
}

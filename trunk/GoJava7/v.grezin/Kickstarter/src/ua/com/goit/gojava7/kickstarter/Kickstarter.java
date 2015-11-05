package ua.com.goit.gojava7.kickstarter;

import java.util.List;
import java.util.Scanner;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorage();
		ConsolePrinter.println(quoteStorage.getRandomQuote());

		// show all categories with index
		ProjectStorage categoryStorage = new ProjectStorage();

		List<String> categories = categoryStorage.getAllCategories();
		ConsolePrinter.println(categories);
		Scanner scan = new Scanner(System.in);
		for (int number = -1; number != 0;) {
			ConsolePrinter.println("Please choose category by number");

			number = scan.nextInt();
			if (number != 0) {
				ConsolePrinter.println(categories.get(number - 1) + ":");
			}
			for (int projectNumber = -1; projectNumber != 0;) {
				categoryStorage
						.getCategorizedProjects(categories.get(number - 1));
				ConsolePrinter.println("Please choose project by number");
			}
		}
		scan.close();
		// show selected category
	}
}

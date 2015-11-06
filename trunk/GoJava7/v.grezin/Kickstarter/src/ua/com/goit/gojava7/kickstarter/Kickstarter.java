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
		ProjectStorage projectStore = new ProjectStorage();
		List<Project> projects;
		Scanner scan = new Scanner(System.in);
		for (int number = -1; number != 0;) {
			ConsolePrinter.println(categories);
			ConsolePrinter.println(
					"Please choose category by number or '0' for exit");

			number = scan.nextInt();
			if (number != 0) {
				ConsolePrinter.println(categories.get(number - 1) + ":");
			}
			for (int projectNumber = -1; projectNumber != 0;) {
				projects = projectStore
						.getCategorizedProjects(categories.get(number - 1));
				for (int i = 1; i <= projects.size(); i++) {
					Project tempProject = projects.get(i - 1);
					System.out.print(i + ": ");
					ConsolePrinter.printProjects(tempProject);
				}

				ConsolePrinter.println(
						"Please choose project by number or '0' for exit to category list");
				projectNumber = scan.nextInt();
			}
		}
		scan.close();

	}
}

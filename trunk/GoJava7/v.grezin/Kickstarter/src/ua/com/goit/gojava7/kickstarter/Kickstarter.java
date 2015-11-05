package ua.com.goit.gojava7.kickstarter;

import java.util.List;
import java.util.Scanner;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorage();
		ConsolePrinter.println(quoteStorage.getRandomQuote());

		// show all categories with index
		CategoryStorage categoryStorage = new CategoryStorage();

		List<String> categories = categoryStorage.getAllCategories();
		ConsolePrinter.println(categories);
		ConsolePrinter.println("Please choose category by number");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		ConsolePrinter.println(categories.get(number) + ":");
		scan.close();
		// show selected category
	}
}

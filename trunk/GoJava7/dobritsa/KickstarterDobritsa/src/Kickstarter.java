

import java.util.List;

public class Kickstarter {


		public static void main(String[] args) {
			QuoteStorage quoteStorage = new QuoteStorage();
			ConsolePrinter.println(quoteStorage.getRandomQuote());
			
			// show all categories with index
			CategoryStorage categoryStorage = new CategoryStorage();
			
			// ConsolePrinter.println(categoryStorage);
			List<String> categories = categoryStorage.getAllCategories();
			ConsolePrinter.printlnListWithIndexes(categories);
			ConsolePrinter.println("Choose a category by number: ");
			ConsoleInspector consoleInspector = new ConsoleInspector();
			
			ConsolePrinter.println("You have chosen the category: " 
					+ categoryStorage.getCategiry(consoleInspector.getInt()));
		

				
					// read user input
					// show selected category


	}

}

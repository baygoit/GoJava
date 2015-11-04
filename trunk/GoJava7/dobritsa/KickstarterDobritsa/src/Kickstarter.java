

import java.util.List;

public class Kickstarter {


		public static void main(String[] args) {
			QuoteStorage quoteStorage = new QuoteStorage();
			ConsolePrinter.println(quoteStorage.getRandomQuote());
			
			CategoryStorage categoryStorage = new CategoryStorage();
			
			List<String> categories = categoryStorage.getAllCategories();
			ConsolePrinter.printlnListWithIndexes(categories);
			ConsolePrinter.println("Choose a category by number: ");
			ConsoleInspector consoleInspector = new ConsoleInspector();
			
			ConsolePrinter.println("You have chosen the category: " 
					+ categoryStorage.getCategiry(consoleInspector.getInt() - 1));
		

	}

}

import java.util.List;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorage();
		ConsolePrinter.println(quoteStorage.getRandomQuote());			
	
		CategoryStorage categoryStorage = new CategoryStorage();			

		List<String> categories = categoryStorage.getAllCategories();
		ConsolePrinter.printlnListWithIndexes(categories);
		
		ConsolePrinter.println("\nChoose a category by number: ");
		ConsoleInspector consoleInspector = new ConsoleInspector();			
		int categoryNumber = consoleInspector.getInt() - 1;
		ConsolePrinter.println("You have chosen the category: " + categoryStorage.getCategiry(categoryNumber));
			
		ProjectStorage projectStorage = new ProjectStorage();
		projectStorage.setProjectStorage(categoryNumber);
		projectStorage.printShort();		
		
		ConsolePrinter.println("\nChoose a project by number: ");
		int projectNumber = consoleInspector.getInt();
		ConsolePrinter.println("You have chosen the project: " + projectNumber);
		
		consoleInspector.close();
	}
}

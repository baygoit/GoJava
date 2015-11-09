package ua.com.goit.gojava7.kickstarter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRun {
	public static void main(String[] args) {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleInspector consoleInspector = new ConsoleInspector();

		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategories();
		ProjectStorage projectStorage = null;

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleInspector, quoteStorage, categoryStorage, projectStorage);
		kickstarter.run();
		kickstarter.shutdown();
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.
				add(new Quote("I work to stay alive.", "Bette Davis"));
		quoteStorage.
				add(new Quote("There is only one boss. The customer. And he can fire everybody"
						+ "\n     in the company from the chairman on down, simply by "
						+ "\n     spending his money somewhere else.", "Sam Walton"));
		quoteStorage.
				add(new Quote("Ideas pull the trigger, but instinct loads the gun. ", "Don Marquis"));
		quoteStorage.
				add(new Quote("There are no secrets to success. It is the result of preparation, "
						+ "\n     hard work, and learning from failure. ", "Colin Powell"));
		quoteStorage.
				add(new Quote("Happiness does not come from doing easy work but from the "
						+ "\n     afterglow of satisfaction that comes after the achievement "
						+ "\n     of a difficult task that demanded our best. ", "Theodore Isaac Rubin"));		
		return quoteStorage;
	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.add(new Category("Music"));
		categoryStorage.add(new Category("Dances"));
		categoryStorage.add(new Category("Food"));
		return categoryStorage;
	}	
}	
	

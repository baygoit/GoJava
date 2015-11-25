package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class KickstarterRunner {

	/**
	 * args[0] is a type of data source
	 * 
	 * Supported types are memory, file and mysql. Memory by default
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DataSource dataSource = DataSource.MEMORY;
		if (args.length != 0 && args[0] != null) {
			try {
				dataSource = DataSource.valueOf(args[0].toUpperCase());
			} catch (IllegalArgumentException e) {
				System.err.println("Type of data source " + args[0] + " if not supported. Fall back to memory");
			}
		}
		System.err.println("Using " + dataSource + " data source");

		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleScanner = new ConsoleScanner();

		DaoProvider daoProvider = new DaoProvider(dataSource);
		daoProvider.open();

		QuoteDao quoteDao = daoProvider.getQuoteDao();
		CategoryDao categoryDao = daoProvider.getCategoryDao();
		// initCategories();

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteDao, categoryDao);
		kickstarter.run();
		kickstarter.shutdown();

		daoProvider.close();
	}


	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();

		Category category = new Category();
		category.setName("Movie");

		Project project = new Project("New funnny movie", "The movie about new funny story", 5000000L, 30);
		project.setHistory("No history");
		project.setVideoUrl("https://example.com/video.mp4");
		project.setQuestionsAndAnswers("Q: What is our real content? A: Currently, we are waiting for it");
		category.getProjects().add(project);

		project = new Project("Not funnny movie", "The movie about sad story", 500000L, 14);
		category.getProjects().add(project);

		categoryStorage.add(category);
		// cut
		category = new Category();
		category.setName("Dances");

		project = new Project("Dance with me", "It's about tango", 50000L, 30);
		category.getProjects().add(project);

		project = new Project("Waltz", "It's about waltz", 20000L, 14);
		category.getProjects().add(project);

		categoryStorage.add(category);
		// cut
		category = new Category();
		category.setName("Food");

		project = new Project("Prosciutto ", "Italian ham", 5000L, 10);
		category.getProjects().add(project);

		project = new Project("Popato", "Belarussian potato", 200L, 5);
		category.getProjects().add(project);

		categoryStorage.add(category);
		return categoryStorage;
	}
}

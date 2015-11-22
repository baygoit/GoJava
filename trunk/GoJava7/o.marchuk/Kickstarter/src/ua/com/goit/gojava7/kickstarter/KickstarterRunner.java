package ua.com.goit.gojava7.kickstarter;

import java.io.File;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.FileQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.MemoryQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class KickstarterRunner {

	private static final File QUOTES_FILE = new File("./quotes.txt");

	private static QuoteReader getQuoteReader(boolean isFromFile) {
		if (!isFromFile) {
			return new MemoryQuoteReader();
		} else {
			return new FileQuoteReader(QUOTES_FILE);
		}
	}

	public static void main(String[] args) {
		boolean isFromFile = false;
		if (args.length != 0) {
			isFromFile = true;
		}

		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleScanner = new ConsoleScanner();

		QuoteDao quoteStorage = initQuotes(isFromFile);
		CategoryStorage categoryStorage = initCategories();

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteStorage, categoryStorage);
		kickstarter.run();
		kickstarter.shutdown();
	}

	private static QuoteDao initQuotes(boolean isFromFile) {
		QuoteDaoMemoryImpl quoteStorage = new QuoteDaoMemoryImpl(new Random());
		QuoteReader quoteReader = getQuoteReader(isFromFile);
		List<Quote> quotes = quoteReader.readQuotes();
		quoteStorage.setQuotes(quotes);
		return quoteStorage;
	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();

		Category category = new Category("Movie");

		Project project = new Project("New funnny movie", "The movie about new funny story", 5000000L, 30);
		project.setHistory("No history");
		project.setVideoUrl("https://example.com/video.mp4");
		project.setQuestionsAndAnswers("Q: What is our real content? A: Currently, we are waiting for it");
		category.getProjects().add(project);

		project = new Project("Not funnny movie", "The movie about sad story", 500000L, 14);
		category.getProjects().add(project);

		categoryStorage.add(category);
		// cut
		category = new Category("Dances");

		project = new Project("Dance with me", "It's about tango", 50000L, 30);
		category.getProjects().add(project);

		project = new Project("Waltz", "It's about waltz", 20000L, 14);
		category.getProjects().add(project);

		categoryStorage.add(category);
		// cut
		category = new Category("Food");

		project = new Project("Prosciutto ", "Italian ham", 5000L, 10);
		category.getProjects().add(project);

		project = new Project("Popato", "Belarussian potato", 200L, 5);
		category.getProjects().add(project);

		categoryStorage.add(category);
		return categoryStorage;
	}
}

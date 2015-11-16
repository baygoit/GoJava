package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRunner {

	public static void main(String[] args) {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleScanner = new ConsoleScanner();

		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategories();

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleScanner, quoteStorage, categoryStorage);
		kickstarter.run();
		kickstarter.shutdown();
	}

	private static QuoteStorage initQuotes() {
		List<Quote> quotes = new ArrayList<>();

		quotes
				.add(new Quote(
						"Your work is going to fill a large part of your life,"
								+ " and the only way to be truly satisfied is to do what"
								+ " you believe is great work. And the only way to do"
								+ " great work is to love what you do. If you haven't"
								+ " found it yet, keep looking. Don't settle. As with"
								+ " all matters of the heart, you'll know when you"
								+ " find it.", "Steve Jobs"));
		quotes.add(new Quote(
				"Innovation distinguishes between a leader and a follower.",
				"Steve Jobs"));

		QuoteStorage quoteStorage = new QuoteStorage(new Random());
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

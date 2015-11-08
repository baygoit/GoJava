package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRunner {
	public static void main(String[] args) {

		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleReader consoleReader = new ConsoleReader();
		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategories();
		ProjectStorage projectStorage = initProjects(categoryStorage);

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleReader, quoteStorage, categoryStorage,
				projectStorage);
		kickstarter.run();
		kickstarter.shutdown();

	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.add(new Quote("Your work is going to fill a large part of your life,"
				+ " and the only way to be truly satisfied is to do what"
				+ " you believe is great work. And the only way to do"
				+ " great work is to love what you do. If you haven't"
				+ " found it yet, keep looking. Don't settle. As with"
				+ " all matters of the heart, you'll know when you" + " find it.", "Steve Jobs."));
		quoteStorage.add(new Quote("Innovation distinguishes between a leader and a follower.", " Steve Jobs."));
		return quoteStorage;
	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.add(new Category("Games"));
		categoryStorage.add(new Category("Design"));
		categoryStorage.add(new Category("Film & Video"));
		categoryStorage.add(new Category("Technology"));
		return categoryStorage;
	}

	private static ProjectStorage initProjects(CategoryStorage categoryStorage) {
		ProjectStorage projectStorage = new ProjectStorage();

		Project progect1 = new Project("Super project", categoryStorage.get(0), 123, 14, 123, "descr", "owner", 100,
				"link");
		Project progect2 = new Project("Mege project", categoryStorage.get(1), 342, 12, 432, "descrip", "owner2", 100,
				"link2");

		projectStorage.add(progect1);
		projectStorage.add(progect2);

		return projectStorage;
	}
}

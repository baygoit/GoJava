package ua.com.goit.gojava7.kickstarter;

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
		ConsoleScanner consoleReader = new ConsoleScanner();
		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategories();

		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleReader, quoteStorage, categoryStorage);
		kickstarter.runKickstarter();
		kickstarter.shutdown();

	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage(new Random());
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
		Category category = new Category("Games");
		initProjects(category);
		categoryStorage.add(category);
		categoryStorage.add(new Category("Design"));
		categoryStorage.add(new Category("Film & Video"));
		categoryStorage.add(new Category("Technology"));
		return categoryStorage;
	}

	private static void initProjects(Category category) {

		Project progect1 = new Project("Super project");
		progect1.setFunded(123);
		progect1.setDaysToGo(14);
		progect1.setPledged(123);
		progect1.setGoal(100);
		progect1.setOwner("owner");
		progect1.setDescription("descr");
		progect1.setLinkVideo("link");

		Project progect2 = new Project("Mege project");

		category.addProject(progect1);
		category.addProject(progect2);

	}
}

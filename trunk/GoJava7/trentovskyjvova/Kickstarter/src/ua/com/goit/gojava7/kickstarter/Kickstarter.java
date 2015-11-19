package ua.com.goit.gojava7.kickstarter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ua.com.goit.gojava7.kickstarter.Level.CategoryLevel;
import ua.com.goit.gojava7.kickstarter.Level.Level;
import ua.com.goit.gojava7.kickstarter.Level.MenuLevel;
import ua.com.goit.gojava7.kickstarter.Level.PaymentLevel;
import ua.com.goit.gojava7.kickstarter.Level.PledgeLevel;
import ua.com.goit.gojava7.kickstarter.Level.ProjectLevel;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {

	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;

	private List<Level> levels;

	public Kickstarter(ConsolePrinter consolePrinter,
			ConsoleScanner consoleScanner, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.consolePrinter = consolePrinter;
		this.consoleScanner = consoleScanner;

		levels = new LinkedList<>(Arrays.asList(new MenuLevel(),
				new CategoryLevel(), new ProjectLevel(), new PaymentLevel(), new PledgeLevel()));
	}

	public void runKickstarter() {
		consolePrinter.print(quoteStorage.getRandomQuote());

		ListIterator<Level> levelsIterator = levels.listIterator();
		List<Category> categories = categoryStorage.getAllCategories();

		Level userPositionLevel = levelsIterator.next();
		int userChoise = 0;
		Category selectedCategory = null;
		Project selectedProject = null;
		String answer;

		answer = userPositionLevel.generateAnswer(categories, userChoise,
				selectedCategory, selectedProject);

		consolePrinter.print(answer);

		boolean notExit = true;
		while (notExit) {

			userChoise = consoleScanner.scan();

			if (userChoise == 0) {
				if (levelsIterator.nextIndex() == 1) {
					notExit = false;
					continue;
				}
			}

			answer = userPositionLevel.validateUserChoise(categories,
					userChoise, selectedCategory, selectedProject);
			if (!answer.equals("")) {
				consolePrinter.print(answer);
				continue;
			}

			userPositionLevel = findNewUserPositionLevel(levelsIterator,
					userChoise);
			userChoise--;

			selectedCategory = userPositionLevel.findSelectedCategory(
					categories, userChoise, selectedCategory);
			selectedProject = userPositionLevel.findSelectedProject(userChoise,
					selectedCategory, selectedProject);

			answer = userPositionLevel.generateAnswer(categories, userChoise,
					selectedCategory, selectedProject);
			if (!answer.equals("")) {
				consolePrinter.print(answer);
			}

			answer = userPositionLevel.fillOutForm(selectedProject,
					userChoise + 1, consoleScanner);
			if (!answer.equals("")) {
				consolePrinter.print(answer);
			}

		}
		consolePrinter.print("Goodbye!");
	}

	public void shutdown() {
		consoleScanner.close();
	}

	private Level findNewUserPositionLevel(ListIterator<Level> listIterator,
			int userChoise) {

		if (userChoise == 0) {
			listIterator.hasPrevious();
			listIterator.previous();
			listIterator.previous();

		}
		return listIterator.next();
	}
}

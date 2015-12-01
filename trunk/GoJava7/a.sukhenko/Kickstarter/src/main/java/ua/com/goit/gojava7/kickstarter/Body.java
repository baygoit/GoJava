package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Body {
	public static final String CATEGORIES = "Categories: ";
	public static final String GO_IT_KICKSTARTER_C_BY_ARTUR_SUKHENKO = "GoIT Kickstarter (c) by Artur Sukhenko";
	public static final String WELCOME_TO_KICKSTARTER_BETA = "Welcome to Kickstarter Beta";


	public void generateHeader() {
		ConsolePrinter.print(WELCOME_TO_KICKSTARTER_BETA);
	}

	public void generateFooter() {
		ConsolePrinter.print(GO_IT_KICKSTARTER_C_BY_ARTUR_SUKHENKO);
	}

	public void generateBody(ProjectManager projectManager,
			CategoryStorage categoryStorage) {
		generateProjectInfo(projectManager.getProjectById(0), categoryStorage);
	}

	public void generateQuoteBlock(QuoteStorage quoteStorage) {
		Quote quote = quoteStorage.getRandomQuote();
		ConsolePrinter.printHorizontalLine();
		ConsolePrinter.println(quote);
	}

	public void generateCategories(CategoryStorage categoryStorage) {
		ConsolePrinter.printHorizontalLine();
		ConsolePrinter.print(CATEGORIES);
		categoryStorage.getCategories().forEach(a -> generateCategoryInfo(a));
	}

	public void generateMainPage(QuoteStorage quoteStorage, ProjectManager projectManager,
			ConsolePrinter consolePrinter, CategoryStorage categoryStorage) {
		generateHeader();
		generateQuoteBlock(quoteStorage);
		generateBody(projectManager, categoryStorage);
		generateFooter();
	}

	public void generateCategoryInfo(Category category) {
		ConsolePrinter.printCategory(category);
	}

	public void generateProjectInfo(Project project,CategoryStorage categoryStorage) {

		ConsolePrinter.printHorizontalLine();
		ConsolePrinter.print("Project: " + project.getProjectName() + "   |  Category: "
				+ categoryStorage.getCategoryById(project.getProjectCategoryId()).getCategoryName());
		ConsolePrinter.print(project.getProjectEndTime());
		ConsolePrinter.print("[ " + project.getProjectDescription() + " ]");
		ConsolePrinter.print("Funded: " + project.getFundedPercentage() + " Backers: " + project.getBackers().size()
				+ " | Pledged: $" + project.getMoneyPledged());

	}

}

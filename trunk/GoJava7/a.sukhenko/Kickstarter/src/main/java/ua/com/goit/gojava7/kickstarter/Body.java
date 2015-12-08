package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class Body{
	public static final String	CATEGORIES								= "Categories: ";
	public static final String	GO_IT_KICKSTARTER_C_BY_ARTUR_SUKHENKO	= "GoIT Kickstarter (c) by Artur Sukhenko";
	public static final String	WELCOME_TO_KICKSTARTER_BETA				= "Welcome to Kickstarter Beta";

	public void generateHeader() {
		ConsolePrinter.print(WELCOME_TO_KICKSTARTER_BETA);
	}

	public void generateFooter() {
		ConsolePrinter.print(GO_IT_KICKSTARTER_C_BY_ARTUR_SUKHENKO);
	}

	public void generateBody(ProjectStorage projectStorage, CategoryStorage categoryStorage) {
		generateProjectInfo(projectStorage.getByNumber(projectStorage.getAll().size()-1), categoryStorage);
	}

	public void generateQuoteBlock(QuoteStorage quoteStorage) {
		Quote quote = quoteStorage.getRandomQuote();
		ConsolePrinter.printHorizontalLine();
		ConsolePrinter.println(quote);
	}

	public void generateCategories(CategoryStorage categoryStorage) {
		ConsolePrinter.printHorizontalLine();
		ConsolePrinter.print(CATEGORIES);
		categoryStorage.getAll().forEach(a -> generateCategoryInfo(a));
	}

	public void generateMainPage(QuoteStorage quoteStorage, ProjectStorage projectStorage,
			CategoryStorage categoryStorage) {
		generateHeader();
		generateQuoteBlock(quoteStorage);
		generateBody(projectStorage, categoryStorage);
		generateFooter();
	}

	public void generateCategoryInfo(Category category) {
		ConsolePrinter.printCategory(category);
	}

	public void generateProjectInfo(Project project, CategoryStorage categoryStorage) {
		ConsolePrinter.printHorizontalLine();
		System.out.println(project.getProjectName());
		System.out.println("Size:" + categoryStorage.size());
		ConsolePrinter.print("Project: " + project.getProjectName() + "   |  Category: "
				+ categoryStorage.getCategoryById(project.getProjectCategoryId()).getCategoryName());
		ConsolePrinter.print(project.getProjectEndTime());
		ConsolePrinter.print("[ " + project.getProjectDescription() + " ]");
		ConsolePrinter.print("Funded: " + project.getFundedPercentage() + " | Pledged: $" + project.getPledged());

	}

}

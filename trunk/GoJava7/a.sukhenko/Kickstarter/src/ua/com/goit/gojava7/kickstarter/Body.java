package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class Body{
	public static final String CATEGORIES = "Categories: ";
	public static final String GO_IT_KICKSTARTER_C_BY_ARTUR_SUKHENKO = "GoIT Kickstarter (c) by Artur Sukhenko";
	public static final String WELCOME_TO_KICKSTARTER_BETA = "Welcome to Kickstarter Beta";
	private Kickstarter		kickstarter;
	public Kickstarter getKickstarter() {
		return kickstarter;
	}
	public void setKickstarter(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}
	public ConsolePrinter getConsolePrinter() {
		return consolePrinter;
	}
	public void setConsolePrinter(ConsolePrinter consolePrinter) {
		this.consolePrinter = consolePrinter;
	}

	private ConsolePrinter	consolePrinter;

	public Body(Kickstarter kickstarter, ConsolePrinter consolePrinter2) {
		this.kickstarter = kickstarter;
		this.consolePrinter = consolePrinter2;
	}
	public Body() {
		
	}
	public void generateHeader() {
		consolePrinter.print(WELCOME_TO_KICKSTARTER_BETA);
	}

	public void generateFooter() {
		consolePrinter.print(GO_IT_KICKSTARTER_C_BY_ARTUR_SUKHENKO);
	}

	public void generateBody() {
		Project first = kickstarter.getProjectManager().getProjectById(0);
		generateProjectInfo(first);
	}

	public void generateQuoteBlock() {
		Quote quote = kickstarter.getQuoteStorage().getRandomQuote();
		consolePrinter.printHorizontalLine();
		consolePrinter.println(quote);
	}

	public void generateCategories() {
		consolePrinter.printHorizontalLine();
		consolePrinter.print(CATEGORIES);
		kickstarter.getCategoryStorage().getCategories().forEach(a -> {
			generateCategoryInfo(a);
		});
	}

	public void generateMainPage() {
		generateHeader();
		generateQuoteBlock();
		generateBody();
		generateFooter();
	}

	public void generateCategoryInfo(Category category) {
		consolePrinter.printCategory(category);
	}

	public void generateProjectInfo(Project project) {

		consolePrinter.printHorizontalLine();
		consolePrinter.print(
				"Project: " + project.getProjectName() + "   |  Category: "
						+ project.getProjectCategory().getCategoryName());
		consolePrinter.print(project.getProjectEndTime());
		consolePrinter.print("[ " + project.getProjectDescription() + " ]");
		consolePrinter.print("Funded: " + project.getFundedPercentage()
				+ " Backers: " + project.getBackers().size() + " | Pledged: $"
				+ project.getMoneyPledged());

	}

}

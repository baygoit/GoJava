package ua.com.goit.gojava7.kikstarter;

public class ConsolePrinter {

	private static final String NEXT_LINE = "\n";
	private static final String SEPARETOR = " : ";
	private static final String INDENT = "===============================";

	public void printString(String valueStr) {
		System.out.println(valueStr);
	}

	public void printQuote(Quote quote) {
		System.out.println(quote.getQuoteContent() + NEXT_LINE + quote.getQuoteAuthor() + NEXT_LINE
				+ INDENT);
	}

	public void printAllCategories(CategoryStorage categoryStorage) {
		System.out.println("All categories:");
		for (int i = 0; i < categoryStorage.getAllCategories().size(); i++) {
			System.out.println((i + 1) + " : " + categoryStorage.getCategory(i).getNameCategory());
		}
		System.out.println(INDENT);
	}

	public void printProjectsOfCurrentCategory(CategoryStorage categoryStorage, int numberOfCategory) {
		Category projectsCategory = categoryStorage.getCategory(numberOfCategory);
		for (int i = 0; i < projectsCategory.getAllProjectsInThisCategory().size(); i++) {
			Project currentProject = projectsCategory.getAllProjectsInThisCategory().get(i);
			System.out.println("¹" + (i + 1) + SEPARETOR + currentProject.getProjectName()
					+ NEXT_LINE + "Title" + SEPARETOR + currentProject.getProjectDescription()
					+ NEXT_LINE + "Necessary amount" + SEPARETOR
					+ currentProject.getProjectNecessaryAmount() + NEXT_LINE + "Collected amount"
					+ SEPARETOR + currentProject.getProjectAmountCollected() + NEXT_LINE
					+ "Days to go" + SEPARETOR + currentProject.getProjectDaysToEnd() + NEXT_LINE
					+ "Question" + SEPARETOR + currentProject.getProjectQuestion() + NEXT_LINE
					+ INDENT);
		}
	}

	public void printCategory(Category category) {
		System.out.println(INDENT + NEXT_LINE + category.getNameCategory() + NEXT_LINE + INDENT);
	}

	public void printPoject(Project project) {
		System.out.println("Title" + SEPARETOR + project.getProjectDescription() + NEXT_LINE
				+ "Necessary amount" + SEPARETOR + project.getProjectNecessaryAmount() + NEXT_LINE
				+ "Collected amount" + SEPARETOR + project.getProjectAmountCollected() + NEXT_LINE
				+ "Days to go" + SEPARETOR + project.getProjectDaysToEnd() + NEXT_LINE
				+ "About this project" + SEPARETOR + project.getProjectDetailedDescription()
				+ NEXT_LINE + "Reference on project" + SEPARETOR + project.getProjectUrl()
				+ NEXT_LINE + "Question" + SEPARETOR + project.getProjectQuestion() + NEXT_LINE
				+ INDENT);
	}
}

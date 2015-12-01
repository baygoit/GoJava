package ua.com.goit.gojava7.kikstarter;

import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class ConsolePrinter {

	private static final String NEXT_LINE = "\n";
	private static final String SEPARETOR = " : ";
	private static final String INDENT = "===============================";

	public void printString(String valueStr) {
		System.out.println(valueStr);
	}

	public void printQuote(Quote quote) {
		System.out.println(quote.getContent() + NEXT_LINE + quote.getAuthor() + NEXT_LINE
				+ INDENT);
	}

	public void printAllCategories(CategoryStorage categoryStorage) {
		System.out.println("All categories:");
		for (int i = 0; i < categoryStorage.getAllCategories().size(); i++) {
			System.out.println((i + 1) + " : " + categoryStorage.getCategory(i).getName());
		}
		System.out.println(INDENT);
	}

	public void printProjectsOfCurrentCategory(CategoryStorage categoryStorage, int numberOfCategory) {
		Category projectsCategory = categoryStorage.getCategory(numberOfCategory);
		for (int i = 0; i < projectsCategory.getAllProjectsInThisCategory().size(); i++) {
			Project currentProject = projectsCategory.getAllProjectsInThisCategory().get(i);
			System.out.println("¹" + (i + 1) + SEPARETOR + currentProject.getName()
					+ NEXT_LINE + "Title" + SEPARETOR + currentProject.getDescription()
					+ NEXT_LINE + "Necessary amount" + SEPARETOR
					+ currentProject.getNecessaryAmount() + NEXT_LINE + "Collected amount"
					+ SEPARETOR + currentProject.getAmountCollected() + NEXT_LINE
					+ "Days to go" + SEPARETOR + currentProject.getEndOfDays() + NEXT_LINE
					+ "Question" + SEPARETOR + currentProject.getProjectQuestion() + NEXT_LINE
					+ INDENT);
		}
	}

	public void printCategory(Category category) {
		System.out.println(INDENT + NEXT_LINE + category.getName() + NEXT_LINE + INDENT);
	}

	public void printPoject(Project project) {
		System.out.println("Title" + SEPARETOR + project.getDescription() + NEXT_LINE
				+ "Necessary amount" + SEPARETOR + project.getNecessaryAmount() + NEXT_LINE
				+ "Collected amount" + SEPARETOR + project.getAmountCollected() + NEXT_LINE
				+ "Days to go" + SEPARETOR + project.getEndOfDays() + NEXT_LINE
				+ "About this project" + SEPARETOR + project.getDetailedDescription()
				+ NEXT_LINE + "Reference on project" + SEPARETOR + project.getUrl()
				+ NEXT_LINE + "Question" + SEPARETOR + project.getProjectQuestion() + NEXT_LINE
				+ INDENT);
	}
}

package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final String DOUBLE_MOVE_TO_THE_NEXT_LINE = "\n\n";
	private static final String USD = "USD";
	private static final char SPACE = ' ';
	private static final TextModifer TEXT_MODIFER = new TextModifer();

	// Printing quote and its author in console
	public void print(Quote quote) {
		String result = TEXT_MODIFER.modifyQuoteTextBeforePrint(quote.getQuoteText(), quote.getAuthor());
		System.out.println(result);
	}

	// Printing all categories 
	public void print(List<Category> categories) {
		System.out.println("All categories:");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println((i + 1) + " : " + category.getName());
		}
	}
	
	// Printing brief projects info
	public void printListOfProjects(List<Project> listOfProjects) {		
		if (listOfProjects.isEmpty()) {
			System.out.println("There are no any projects in selected category.");
		} else {
			System.out.println("All projects from selected category : ");
			List<Project> projects = listOfProjects;
			int amountOfProjects = listOfProjects.size();
			for (int index = 0; index < amountOfProjects; index++) {
				StringBuilder projectInfo = new StringBuilder();
				projectInfo.
					append(MOVE_TO_THE_NEXT_LINE).
					append("Project ¹ : ").
					append(index + 1);
				System.out.println(projectInfo.toString());
				printBriefInfoProject(projects.get(index));
			}
		}
	}	
		

	
	// Printing information about project
	public void printBriefInfoProject(Project project) {
		StringBuilder result = new StringBuilder();
		result.
			append("Project title : ").
			append(TEXT_MODIFER.getModifiedString(project.getTitle())).
			append(MOVE_TO_THE_NEXT_LINE).
			append("About : ").
			append(TEXT_MODIFER.getModifiedString(project.getBriefDescription())).
			append(MOVE_TO_THE_NEXT_LINE).
			append("Required amount of $ : ").
			append(project.getRequiredAmountOfMoney()).
			append(SPACE).
			append(USD).
			append(MOVE_TO_THE_NEXT_LINE).
			append("Current collected amount of $ : ").
			append(project.getCurrentAmoutOfMoney()).
			append(SPACE).
			append(USD).
			append(MOVE_TO_THE_NEXT_LINE).
			append("Days to go : ").
			append(project.getDaysLeft());
		System.out.println(result.toString());
	}
	
	// Printing information about project
		public void printFullInfoProject(Project project) {
			StringBuilder result = new StringBuilder();
			result.
				append("Project title : ").
				append(TEXT_MODIFER.getModifiedString(project.getTitle())).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("About : ").
				append(TEXT_MODIFER.getModifiedString(project.getBriefDescription())).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("Required amount of $ : ").
				append(project.getRequiredAmountOfMoney()).
				append(SPACE).
				append(USD).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("Current collected amount of $ : ").
				append(project.getCurrentAmoutOfMoney()).
				append(SPACE).
				append(USD).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("Days to go : ").
				append(project.getDaysLeft()).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("About this project : ").
				append(TEXT_MODIFER.getModifiedString(project.getFullDescription())).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("Link on viedo with demo : ").
				append(project.getLinkOnVideo()).
				append(DOUBLE_MOVE_TO_THE_NEXT_LINE).
				append("Question : ").
				append(TEXT_MODIFER.getModifiedString(project.getQuestion())).
				append(MOVE_TO_THE_NEXT_LINE).
				append("Answer : ").
				append(TEXT_MODIFER.getModifiedString(project.getAnswer()));
			System.out.println(result.toString());
		}
	
		
	// Printing category name
	public void print(Category category) {
		System.out.println(category.getName());
	}

	// Printing simple string
	public void print(String string) {
		System.out.println(string);
	}	
}

package ua.com.goit.gojava7.kickstarter.view;

import java.util.Iterator;
import java.util.Set;


import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final String DOUBLE_MOVE_TO_THE_NEXT_LINE = "\n\n";
	private static final String USD = "USD";
	private static final char SPACE = ' ';
	private static final TextModifer TEXT_MODIFER = new TextModifer();

	// Printing quote and its author
	public void print(Quote quote) {
		String result = TEXT_MODIFER.modifyQuoteTextBeforePrint(quote.getQuoteText(), quote.getAuthor());
		System.out.println(result);
	}

	// Printing all categories 
	public void printCategories(Set<Category> categories) {
		Iterator<Category> categoryIterator = categories.iterator();
		StringBuilder result = new StringBuilder();
		
		result.
			append("All categories:").
			append(MOVE_TO_THE_NEXT_LINE);
			
		int numberOfProject = 0;
		while (categoryIterator.hasNext()) {
			numberOfProject ++;
			Category category = categoryIterator.next();
			result.
				append(numberOfProject).
				append(" : ").
				append(category.getName()).
				append(MOVE_TO_THE_NEXT_LINE);
		}
		System.out.println(result.toString());
	}
		
	// Printing brief projects info
	public void printProjects(Set<Project> projects) {	
		StringBuilder result = new StringBuilder();
		
		if (projects.isEmpty()) {
			result.
				append("There is no any project in selected category.");
			System.out.println(result.toString());
		} else {
			result.
				append("All projects from selected category : ").
				append(MOVE_TO_THE_NEXT_LINE);
			
			int stepCounter = 0;
			Iterator<Project> projectIterator = projects.iterator();
			while (projectIterator.hasNext()) {				
				result.
					append("Project ¹ : ").
					append(++ stepCounter).
					append(MOVE_TO_THE_NEXT_LINE).
					append(printBriefInfoProject(projectIterator.next()));
			}
			System.out.println(result.toString());
		}
	}	
		
	// Printing information about project
	public String printBriefInfoProject(Project project) {
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
		return result.toString();
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
		System.out.println("Category : " + category.getName());
	}

	// Printing simple string
	public void print(String string) {
		System.out.println(string);
	}	
	
	
}

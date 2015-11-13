package ua.com.goit.gojava7.kickstarter.view;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;


import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final TextModifer TEXT_MODIFER = new TextModifer();
	private PrintStream printStream;
	
	public ConsolePrinter(PrintStream printStream) {
		this.printStream = printStream;
	}

	public String getBriefProjectInfo(Project project) {
		StringBuilder result = new StringBuilder();
		result.
			append("Project title : ").
			append(TEXT_MODIFER.getModifiedString(project.getTitle())).
			append(MOVE_TO_THE_NEXT_LINE).
			append("About : ").
			append(TEXT_MODIFER.getModifiedString(project.getBriefDescription())).
			append(MOVE_TO_THE_NEXT_LINE).
			append(project.getCurrentAmoutOfMoney()).
			append(" pledged of $ ").
			append(project.getRequiredAmountOfMoney()).
			append(" goal").
			append(MOVE_TO_THE_NEXT_LINE).
			append("Days to go : ").
			append(project.getExpiryDays()).
			append(MOVE_TO_THE_NEXT_LINE);
		return result.toString();
	}
	
	public void printFullProjectInfo(Project project) {
		StringBuilder result = new StringBuilder();
		result.
			append(getBriefProjectInfo(project)).
			append(project.getExpiryDays()).
			append(MOVE_TO_THE_NEXT_LINE).
			append("History : ").
			append(TEXT_MODIFER.getModifiedString(project.getFullDescription())).
			append(MOVE_TO_THE_NEXT_LINE).
			append("Video : ").
			append(project.getLinkOnVideo()).
			append(MOVE_TO_THE_NEXT_LINE).
			append("FAQ").
			append(MOVE_TO_THE_NEXT_LINE).
			append("Question : ").
			append(project.getQuestion()).
			append(MOVE_TO_THE_NEXT_LINE);
		printStream.println(result.toString());
	}

	
	
	public void print(Quote quote) {
		String result = TEXT_MODIFER.modifyQuoteTextBeforePrint(quote.getQuoteText(), quote.getAuthor());
		printStream.println(result);
	}

	public void printCategories(Set<Category> categories) {
		Iterator<Category> categoryIterator = categories.iterator();
		StringBuilder categoriesInfo = new StringBuilder();
		
		categoriesInfo.
			append("All categories : ").
			append(MOVE_TO_THE_NEXT_LINE);
			
		int categoryNumber = 0;
		while (categoryIterator.hasNext()) {
			categoryNumber ++;
			Category category = categoryIterator.next();
			
			categoriesInfo.
				append(categoryNumber).
				append(" : ").
				append(category.getName()).
				append(MOVE_TO_THE_NEXT_LINE);
		}
		printStream.println(categoriesInfo.toString());
	}
		
	public void printProjects(Set<Project> projects, boolean userChoise) {	
		StringBuilder projectsInfo = new StringBuilder();
		
		projectsInfo.
			append("All projects from selected category : ").
			append(MOVE_TO_THE_NEXT_LINE).
			append(MOVE_TO_THE_NEXT_LINE);
			
		int stepCounter = 0;
		Iterator<Project> projectIterator = projects.iterator();
		while (projectIterator.hasNext()) {				
			projectsInfo.
				append("Project ¹ ").
				append(++ stepCounter).
				append(MOVE_TO_THE_NEXT_LINE).
				append(getBriefProjectInfo(projectIterator.next())).
				append(MOVE_TO_THE_NEXT_LINE);
		}
			printStream.print(projectsInfo.toString());
	}
	
	
	public void print(Category category) {
		printStream.println("Category : " + category.getName());
	}

	public void print(String string) {
		printStream.println(string);
	}		
}

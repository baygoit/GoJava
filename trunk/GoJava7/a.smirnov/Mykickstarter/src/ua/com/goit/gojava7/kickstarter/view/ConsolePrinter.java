package ua.com.goit.gojava7.kickstarter.view;

import java.util.Iterator;
import java.util.Set;


import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Faq;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.FaqStorage;
import ua.com.goit.gojava7.kickstarter.templates.Templateble;

public class ConsolePrinter {
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final TextModifer TEXT_MODIFER = new TextModifer();

	public void print(Quote quote) {
		String result = TEXT_MODIFER.getModifiedQuoteBeforePrint(quote.getQuoteText(), quote.getAuthor());
		System.out.println(result);
	}

	public void print(Category category) {
		System.out.println("Category : " + category.getName());
	}
	
	public void print(String string) {
		System.out.println(string);
	}		
	
	public void printBriefProjectInfo(Project project) {
		StringBuilder result = new StringBuilder();
		
		result.
			append("Title : ").
			append(TEXT_MODIFER.getModifiedText(project.getTitle())).
			append(MOVE_TO_THE_NEXT_LINE).
			append("About : ").
			append(TEXT_MODIFER.getModifiedText(project.getBriefDescription())).
			append(MOVE_TO_THE_NEXT_LINE).
			append(project.getCurrentAmoutOfMoney()).
			append(" pledged of $ ").
			append(project.getRequiredAmountOfMoney()).
			append(" goal").
			append(MOVE_TO_THE_NEXT_LINE).
			append("Days to go : ").
			append(project.getExpiryDays());
		System.out.println(result.toString());
	}
	
	public void printFullProjectInfo(Project project) {
		StringBuilder result = new StringBuilder();
		
		printBriefProjectInfo(project);
		
		result.
			append("History : ").
			append(TEXT_MODIFER.getModifiedText(project.getFullDescription())).
			append(MOVE_TO_THE_NEXT_LINE).
			append("Video : ").
			append(project.getLinkOnVideo()).
			append(MOVE_TO_THE_NEXT_LINE);
		System.out.println(result.toString());
		
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
		System.out.println(categoriesInfo.toString());
	}
		
	public void printProjects(Set<Project> projects, boolean userChoise) {	
		StringBuilder projectInfo = new StringBuilder();
		
		projectInfo.
			append("All projects from selected category : ").
			append(MOVE_TO_THE_NEXT_LINE);
		
		int stepCounter = 0;
		Iterator<Project> projectIterator = projects.iterator();
		
		while (projectIterator.hasNext()) {				
			projectInfo.
				append(MOVE_TO_THE_NEXT_LINE).
				append("Project ¹ ").
				append(++ stepCounter);
			System.out.println(projectInfo.toString());
			projectInfo.delete(0, projectInfo.length());
			
			printBriefProjectInfo(projectIterator.next());
		}
	}
	
	public void printFAQs(Set<Faq> FAQs) {
		Set<Faq> AllFAQsInSelectedProject = FAQs;
		
		if (AllFAQsInSelectedProject.size() == 0) {
			return;
		} else {
			StringBuilder result = new StringBuilder();
			
			result.
				append("FAQ : ").
				append(MOVE_TO_THE_NEXT_LINE);
			
			Iterator<Faq> iteratorFAQ = AllFAQsInSelectedProject.iterator();
			
			int stepsCounter = 0;
			while (iteratorFAQ.hasNext()) {
				stepsCounter ++;
				
				Faq faq = iteratorFAQ.next();
				
				if (!faq.getQuestion().isEmpty()) {
					result.
						append(" ").
						append(stepsCounter).
						append(" question : ").
						append(faq.getQuestion()).
						append(MOVE_TO_THE_NEXT_LINE);
				} 
			}
			System.out.println(result.toString());
		}
	}
}

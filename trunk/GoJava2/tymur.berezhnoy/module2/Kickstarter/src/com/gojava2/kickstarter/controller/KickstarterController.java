package com.gojava2.kickstarter.controller;

import java.util.List;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorage;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.ProjectStorage;
import com.gojava2.kickstarter.model.QuoteStorage;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class KickstarterController {
	
	private List<Project> projects;
	
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	
	private	ConsoleView consoleView;
	
	private ConsoleInput consoleInput = new ConsoleInput();
	public KickstarterController(QuoteStorage quoteStorage, CategoryStorage categoryStorage,
								ProjectStorage projectStorage, ConsoleView consoleView) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.consoleView = consoleView; 
	}
	
	public void selectCategory() {
		consoleView.display(1);
		int input = consoleInput.choice();
		int amountCategory = categoryStorage.getContent().size();
		if(input > 0 && input <= amountCategory) {
			projects = projectStorage.getSpecificProjects((Category) categoryStorage.getContent().toArray()[input - 1]);
			consoleView.display(projects);
			selectProject();
			selectCategory();
		} else if(input == 0) {
			System.out.print("- App closed");
			return;
		} else {
			selectCategory();
		}
	}
	
	public void selectProject() {
		consoleView.display(2);
		int input = consoleInput.choice();
		
		if(input > 0) {
			consoleView.display(projects.get(input - 1));
			backToProjects();
			selectProject();
		} else if (input == 0) {
			consoleView.display(categoryStorage.getContent());
		}
	}
	
	public void backToProjects() {
		consoleView.display(3); 
		if(consoleInput.choice() == 0) {
			consoleView.display(projects);
		} else {
			backToProjects();
		}
	}
	
	public void run() {
		consoleView.displayTitle();
		consoleView.display(quoteStorage.getRandomQuote());
		
		consoleView.display(categoryStorage.getContent());
		
		selectCategory();
	}
}
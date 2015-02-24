package com.gojava2.kickstarter.controller;

import java.util.List;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorageInVM;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.ProjectStorageInVM;
import com.gojava2.kickstarter.model.QuoteStorageInVM;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class KickstarterController {
	
	private QuoteStorageInVM quoteStorage;
	private CategoryStorageInVM categoryStorage;
	private ProjectStorageInVM projectStorage;
	
	private	ConsoleView consoleView;
	private ConsoleInput consoleInput;
	
	public KickstarterController(QuoteStorageInVM quoteStorage, CategoryStorageInVM categoryStorage,
								ProjectStorageInVM projectStorage, ConsoleView consoleView) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.consoleView = consoleView;
		consoleInput = new ConsoleInput();
	}
	
	public void selectCategory() {
		consoleView.displaySelectOption(1);
		int input = consoleInput.choice();
		int amountCategory = categoryStorage.getCategories().size();
		if(input > 0 && input <= amountCategory) {
			List<Project> projects = projectStorage.getSpecificProjects((Category) categoryStorage.getCategories().toArray()[input - 1]);
			consoleView.display(projects);
			selectProject(projects);
			selectCategory();
		} else if(input == 0) {
			System.out.print("- App closed");
			return;
		} else {
			selectCategory();
		}
	}
	
	public void selectProject(List<Project> projects) {
		consoleView.displaySelectOption(2);
		int input = consoleInput.choice();
		
		if(input > 0) {
			consoleView.display(projects.get(input - 1));
			backToProjects(projects);
			selectProject(projects);
		} else if (input == 0) {
			consoleView.display(categoryStorage.getCategories());
		}
	}
	
	public void backToProjects(List<Project> projects) {
		consoleView.displaySelectOption(3); 
		if(consoleInput.choice() == 0) {
			consoleView.display(projects);
		} else {
			backToProjects(projects);
		}
	}
	
	public void run() {
		consoleView.displayTitle();
		consoleView.display(quoteStorage.getRandomQuote());
		
		consoleView.display(categoryStorage.getCategories());
		
		selectCategory();
	}
}
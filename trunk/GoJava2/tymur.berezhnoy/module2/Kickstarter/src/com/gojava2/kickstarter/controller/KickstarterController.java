package com.gojava2.kickstarter.controller;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorageInVM;
import com.gojava2.kickstarter.model.ProjectStorageInVM;
import com.gojava2.kickstarter.model.QuoteStorageInVM;
import com.gojava2.kickstarter.view.ConsoleView;
import com.gojava2.kickstarter.view.InPut;

public class KickstarterController {
	
	private QuoteStorageInVM quoteStorage;
	private CategoryStorageInVM categoryStorage;
	private ProjectStorageInVM projectStorage;
	
	private	ConsoleView view;
	private InPut in;
	
	public KickstarterController(QuoteStorageInVM quoteStorage, CategoryStorageInVM categoryStorage,
								ProjectStorageInVM projectStorage, ConsoleView consoleView, 
								InPut in) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.view = consoleView;
		this.in = in;
	}
	
	public void selectCategory() {
		view.displaySelectOption(1);
		int input = in.read();
		int amountCategory = categoryStorage.getSize();
		if(input > 0 && input <= amountCategory) {
			Category category = categoryStorage.getCategory(input);
			view.display(projectStorage.getProjectsOfCategory(category));
			selectProject(category);
			selectCategory();
		} else if(input == 0) {
			System.out.print("- App closed");
			return;
		} else {
			selectCategory();
		}
	}
	
	public void selectProject(Category category) {
		view.displaySelectOption(2);
		int input = in.read();
		
		if(input > 0 && input <= projectStorage.getSize()) {
			view.display(projectStorage.getProject(input));
			backToProjects(category);
			selectProject(category);
		} else if (input == 0) {
			view.display(categoryStorage.getCategories());
		} else if (input > projectStorage.getSize()) {
			selectProject(category);
		}
	}
	
	public void backToProjects(Category category) {
		view.displaySelectOption(3); 
		if(in.read() == 0) {
			view.display(projectStorage.getProjectsOfCategory(category));
		} else {
			backToProjects(category);
		}
	}
	
	public void run() {
		view.displayTitle();
		view.display(quoteStorage.getRandomQuote());
		view.display(categoryStorage.getCategories());
		
		selectCategory();
	}
}
package com.gojava2.kickstarter.controller;

import java.util.InputMismatchException;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorage;
import com.gojava2.kickstarter.model.ProjectStorage;
import com.gojava2.kickstarter.model.QuoteStorage;
import com.gojava2.kickstarter.view.ConsoleView;
import com.gojava2.kickstarter.view.InPut;

public class KickstarterController {
	
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	
	private	ConsoleView view;
	private InPut in;
	
	public KickstarterController(QuoteStorage quoteStorage, CategoryStorage categoryStorage,
								ProjectStorage projectStorage, ConsoleView consoleView, 
								InPut in) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.view = consoleView;
		this.in = in;
	}
	
	public void menuLevelOne() {
		view.printOption(1);
		
		try {
			int input = in.read();
			int amountCategory = categoryStorage.getSize();
			if(input > 0 && input <= amountCategory) {
				Category category = categoryStorage.getCategory(input);
				view.display(projectStorage.getProjects(category));
				menuLevelTwo(category);
				menuLevelOne();
			} else if(input == 0) {
				System.out.print("- App closed");
				return;
			} else {
				view.noExistCategoryMessage(input);
				menuLevelOne();
			}			
		} catch (InputMismatchException e) {
			view.inputMismatchMessage();
			menuLevelOne();
		}
	}
	
	public void menuLevelTwo(Category category) {
		view.printOption(2);
		
		try {
			int input = in.read();
			
			if(input > 0 && input <= projectStorage.getSize()) {
				view.display(projectStorage.getProject(category, input));
				menuLevelThree(category);
				menuLevelTwo(category);
			} else if (input == 0) {
				view.display(categoryStorage.getCategories());
			} else if (input > projectStorage.getSize()) {
				view.noExistProjectMessage(input);
				menuLevelTwo(category);
			}			
		} catch (InputMismatchException e) {
			view.inputMismatchMessage();
			menuLevelTwo(category);
		}
	}
	
	public void menuLevelThree(Category category) {
		view.printOption(3);
		
		try {
			int input = in.read();
			if(input == 0) {
				view.display(projectStorage.getProjects(category));
			} else {
				menuLevelThree(category);
			}			
		} catch (InputMismatchException e) {
			view.inputMismatchMessage();
			menuLevelThree(category);
		}
	}
	
	public void run() {
		view.displayTitle();
		try {			
			view.display(quoteStorage.getRandomQuote());
		} catch (Exception e) {
			System.out.println("There are no quotes");
		}
		view.display(categoryStorage.getCategories());
		
		menuLevelOne();
	}
}
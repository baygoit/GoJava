package com.gojava2.kickstarter.controller;

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
	
	private InPut in;
	private	ConsoleView view;
	
	public KickstarterController(QuoteStorage quoteStorage, CategoryStorage categoryStorage,
								ProjectStorage projectStorage, ConsoleView consoleView, 
								InPut in) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.view = consoleView;
		this.in = in;
	}
	
	public void levelOne() {
		Menu menu = new Menu(in, view, 1) {
			@Override
			void logic(int i) {				
				if(i > 0 && i <= categoryStorage.getSize()) {
					Category category = categoryStorage.getCategory(i);
					view.display(projectStorage.getProjects(category));
					levelTwo(category);
					recursion();
				} else if(i == 0) {
					System.out.print("- App closed");
					return;
				} else {
					view.noExistCategoryMessage(i);
					recursion();
				}			
			}
			
			@Override
			void recursion() {				
				levelOne();
			}
		};
		menu.levelGo();
	}
	
	public void levelTwo(final Category category) {
		Menu menu = new Menu(in, view, 2) {
			@Override
			void logic(int i) {
				if(i > 0 && i <= projectStorage.getSize()) {
					view.display(projectStorage.getProject(category, i));
					levelThree(category);
					recursion();
				} else if (i == 0) {
					view.display(categoryStorage.getCategories());
				} else if (i > projectStorage.getSize()) {
					view.noExistProjectMessage(i);
					recursion();
				}							
			}
			
			@Override
			void recursion() {				
				levelTwo(category);
			}
		};
		menu.levelGo();
	}
	
	public void levelThree(final Category category) {
		Menu menu = new Menu(in, view, 3) {
			@Override
			void logic(int i) {
				if(i == 0) {
					view.display(projectStorage.getProjects(category));
				} else {
					recursion();
				}						
			}
			
			@Override
			void recursion() {				
				levelThree(category);
			}
		};
		menu.levelGo();
	}
	
	public void run() {
		view.displayTitle();
		try {			
			view.display(quoteStorage.getRandomQuote());
		} catch (Exception e) {
			System.out.println("There are no quotes");
		}
		view.display(categoryStorage.getCategories());
		
		levelOne();
	}
}
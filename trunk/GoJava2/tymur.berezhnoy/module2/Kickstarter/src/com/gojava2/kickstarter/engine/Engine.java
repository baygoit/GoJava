package com.gojava2.kickstarter.engine;

import com.gojava2.kickstarter.controller.CategoryController;
import com.gojava2.kickstarter.controller.ProjectController;
import com.gojava2.kickstarter.controller.QuoteController;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class Engine {
	
	private	ConsoleView xonConsoleView;
	private ConsoleInput consoleInput;
	
	public Engine() {
		xonConsoleView = new ConsoleView(new QuoteController(), new CategoryController(),
							new ProjectController());
		consoleInput = new ConsoleInput();
	}
	
	public void consoleLevel1() {
		System.out.print("[0 - exit; 1 - * - selec category;]\n> ");
		int input = consoleInput.choice();
		int amountCategory = new StorageFactory().getCategoryStorage().getContent().size();
		if(input > 0 && input <= amountCategory) {
			xonConsoleView.setCategoryPath(input);
			xonConsoleView.displayProjects();
			consoleLevel2();
			consoleLevel1();
		} else if(input == 0) {
			System.out.print("- App closed");
			return;
		} else {
			consoleLevel1();
		}
	}
	
	public void consoleLevel2() {
		System.out.print("[0 - to categories; 1 - * - select project;]\n> ");
		int input = consoleInput.choice();
		
		if(input > 0) {
			xonConsoleView.displaySpecificProject(input);
			consoleLevel3();
			consoleLevel2();
		} else if (input == 0) {
			xonConsoleView.displayCategories();
		}
	}
	
	public void consoleLevel3() {
		System.out.print("[0 - to projects;]\n> "); 
		if(consoleInput.choice() == 0) {
			xonConsoleView.displayProjects();
		} else {
			consoleLevel3();
		}
	}
	
	public void start() {
		xonConsoleView.displayHead();
		xonConsoleView.displayCategories();	
		consoleLevel1();
	}
}
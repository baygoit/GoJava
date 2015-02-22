package com.gojava2.kickstarter.engine;

import com.gojava2.kickstarter.controller.CategoryController;
import com.gojava2.kickstarter.controller.ProjectController;
import com.gojava2.kickstarter.controller.QuoteController;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class Engine {
	
	private	ConsoleView view;
	private ConsoleInput scann;
	private StorageFactory storageFactory;
	
	public Engine() {
		storageFactory = new StorageFactory();
		view = new ConsoleView(new QuoteController(), new CategoryController(),
							new ProjectController());
		scann = new ConsoleInput();
	}
	
	public void consoleLevel1() {
		System.out.print("[0 - exit; 1 - * - selec category;]\n> ");
		int input = scann.choice();
		int amountCategory = storageFactory.getCategoryStorage().getContent().size();
		if(input > 0 && input <= amountCategory) {
			view.setCategoryPath(input);
			view.displayProjects();
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
		int input = scann.choice();
		
		if(input > 0) {
			view.displaySpecificProject(input);
			consoleLevel3();
			consoleLevel2();
		} else if (input == 0) {
			view.displayCategories();
		}
	}
	
	public void consoleLevel3() {
		System.out.print("[0 - to projects;]\n> "); 
		if(scann.choice() == 0) {
			view.displayProjects();
		} else {
			consoleLevel3();
		}
	}
	
	public void start() {
		view.displayHead();
		view.displayCategories();	
		consoleLevel1();
	}
}
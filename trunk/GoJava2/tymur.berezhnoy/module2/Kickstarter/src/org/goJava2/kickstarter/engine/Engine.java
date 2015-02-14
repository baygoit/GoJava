package org.goJava2.kickstarter.engine;

import org.goJava2.kickstarter.controller.CategoryController;
import org.goJava2.kickstarter.controller.ProjectController;
import org.goJava2.kickstarter.controller.QuoteController;
import org.goJava2.kickstarter.factory.StorageFactory;
import org.goJava2.kickstarter.model.CategoryStorage;
import org.goJava2.kickstarter.view.InOut;
import org.goJava2.kickstarter.view.ConsoleView;

public class Engine {
	
	private	ConsoleView view;
	private InOut scann;
	
	public Engine() {
		view = new ConsoleView(new QuoteController(), new CategoryController(), new ProjectController());
		scann = new InOut();
	}
	
	public void consoleLevel1() {
		System.out.print("[0 - exit; 1 - * - selec category;]\n> ");
		int input = scann.choice();
		CategoryStorage storage = new StorageFactory().getCategoryStorage();
		if(input > 0 && input <= storage.getContent().size()) {
			view.displaySpecificCategory(input);
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
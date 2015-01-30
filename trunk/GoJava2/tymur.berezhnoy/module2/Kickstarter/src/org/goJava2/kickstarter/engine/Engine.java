package org.goJava2.kickstarter.engine;
import java.util.ArrayList;

import org.goJava2.kickstarter.controller.Controller;
import org.goJava2.kickstarter.model.GeneralStorage;
import org.goJava2.kickstarter.model.Quote;
import org.goJava2.kickstarter.model.QuoteStorage;
import org.goJava2.kickstarter.view.Scann;
import org.goJava2.kickstarter.view.View;

public class Engine {
	
	private QuoteStorage quoteStorage;
	private GeneralStorage generalStorage;
	private View view;
	private Controller controller;
	private Scann scann;
	
	public Engine() {
		quoteStorage = new QuoteStorage(new ArrayList<Quote>());
		generalStorage = new GeneralStorage();
		view = new View();
		controller = new Controller(quoteStorage, generalStorage, view);
		scann = new Scann();
	}
	
	public void start() {
		controller.displayQuote();
		controller.displayCategories();
		int input;
		
		while(true) {
			System.out.print("[0 - exit; 1 - * - select category]\n> ");
			input = scann.choice();
			if(input > 0 && input <= generalStorage.getCategories().size()) {
				controller.selectCategory(input);
				while(true) {
					System.out.print("[0 - to categories; 1 - * - select project]\n> ");
					input = scann.choice();
					if(input > 0) {
						try {
						controller.selectProject(input);
						} catch(IndexOutOfBoundsException e) {
							System.out.println("- There are no project at number: " + input);
						}
						while(true) {
							System.out.print("[0 - to projects;]\n> ");
							input = scann.choice();
							if(input == 0) {
								controller.displaySpecificProjects();
								break;
							}
						}
					} else if(input == 0) {
						controller.displayCategories();
						break;
					}
				}
			} else if(input == 0) {
				System.out.println("- App closed!");
				break;
			}
		}
	}
}
package org.goJava2.kickstarter.engine;
import java.util.ArrayList;

import org.goJava2.kickstarter.controller.ControllerApp;
import org.goJava2.kickstarter.model.GeneralStorage;
import org.goJava2.kickstarter.model.Quote;
import org.goJava2.kickstarter.model.QuoteStorage;
import org.goJava2.kickstarter.model.Scann;
import org.goJava2.kickstarter.view.View;

public class Engine {
	
	private QuoteStorage quoteStorage = new QuoteStorage(new ArrayList<Quote>());
	private GeneralStorage generalStorage = new GeneralStorage();
	private View view = new View();
	private ControllerApp controller = new ControllerApp(quoteStorage, generalStorage, view);
	private Scann scann = new Scann();
	
	public void start() {
		controller.displayQuote();
		controller.displayCategorys();
		int input;
		
		while(true) {
			System.out.print("[0 - exit; 1 - * - select category]\n> ");
			input = scann.choise();
			if(input > 0 && input <= generalStorage.getCategories().size()) {
				controller.selectCategory(input);
				while(true) {
					System.out.print("[0 - to categories; 1 - * - select project]\n> ");
					input = scann.choise();
					if(input > 0) {
						controller.selectProject(input);
						while(true) {
							System.out.print("[0 - to projects;]\n> ");
							input = scann.choise();
							if(input == 0) {
								controller.displaySpecificProjects();
								break;
							}
						}
					} else if(input == 0) {
						controller.displayCategorys();
						break;
					}
				}
			} else if(input == 0) {
				System.out.println("App closed!");
				break;
			}
		}
	}
}
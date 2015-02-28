package com.kickstarter.controller;
import java.util.List;

import com.kickstarter.model.DataStorage;
import com.kickstarter.model.Project;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.ConsoleView;
import com.kickstarter.view.InPut;

public class Engine {

	private InPut inPut;
	private ConsoleView consoleView;
	private DataStorage dataStorage;
	
	public Engine(ConsoleView consoleView, DataStorage dataStorage, InPut inPut) {
		this.consoleView = consoleView;
		this.inPut = inPut;
		this.dataStorage = dataStorage;
	}

	public void consolePart_1() {
		System.out.print("\n" + "Please select category: ");
		int input = inPut.readInput();
		if(input > 0 && input <= dataStorage.getCategoriesList().size()) {
			Сategory category = dataStorage.getCategoriesList().get(input - 1);
			consoleView.displaySelectedCategory(category);
			List<Project> projects = dataStorage.getSpecificProjects(category);
			consoleView.displayProjectsOfCategory(projects);	
			consolePart_2(projects);
		    consolePart_1();
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_1();
		}
	}

	public void consolePart_2(List<Project> projects) {
		System.out.print("(Press \"0\" - back to categories.)" + "\n" + "Select project: ");
		int input = inPut.readInput();
		if (input > 0 && input <= projects.size()) {
			consoleView.displayCurrentProject(projects.get(input - 1));
			consolePart_3(projects);
			consolePart_2(projects);
		} else if (input == 0) {
			consoleView.displayListCategories(dataStorage.getCategoriesList());
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_2(projects);
		}
	}

	public void consolePart_3(List<Project> projects) {
		System.out.print("\n" + "Press \"0\"  - back to projects: ");
		int input = inPut.readInput();
		if (input == 0) {
			consoleView.displayProjectsOfCategory(projects);
		} else {
			consolePart_3(projects);
		}
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayQuote(dataStorage.getRundomQuote());
		consoleView.displayListCategories(dataStorage.getCategoriesList());
		consolePart_1();
	}
}
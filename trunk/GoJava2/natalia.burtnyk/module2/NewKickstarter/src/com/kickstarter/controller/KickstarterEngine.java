package com.kickstarter.controller;
import java.util.List;

import com.kickstarter.model.DataStorage;
import com.kickstarter.model.Project;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.ConsoleView;
import com.kickstarter.view.InPut;

public class KickstarterEngine {

	private InPut inPut;
	private ConsoleView consoleView;
	private DataStorage dataStorage;
	
	public KickstarterEngine(ConsoleView consoleView, DataStorage dataStorage, InPut inPut) {
		this.consoleView = consoleView;
		this.inPut = inPut;
		this.dataStorage = dataStorage;
	}

	public void consolePart_1() {
		System.out.print("\n" + "Please select category: ");
		int input = inPut.readInput();
		if(input > 0 && input <= dataStorage.getSizeCategories()) {
			Сategory category = dataStorage.getSpecificCategory(input);
			consoleView.displaySelectedCategory(category);
			List<Project> projects = dataStorage.getSpecificProjects(category);
			consoleView.displayProjectsOfCategory(projects);	
			consolePart_2(category);
		    consolePart_1();
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_1();
		}
	}

	public void consolePart_2(Сategory сategory) {
		System.out.print("(Press \"0\" - back to categories.)" + "\n" + "Select project: ");
		int input = inPut.readInput();
		if (input > 0 && input <= dataStorage.getSizeProjectsOfCategory()) {
			consoleView.displayCurrentProject(dataStorage.getProject(input));
			consolePart_3(сategory);
			consolePart_2(сategory);
		} else if (input == 0) {
			consoleView.displayListCategories(dataStorage.getCategoriesList());
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_2(сategory);
		}
	}

	public void consolePart_3(Сategory category) {
		System.out.print("\n" + "Press \"0\"  - back to projects: ");
		int input = inPut.readInput();
		if (input == 0) {
			consoleView.displayProjectsOfCategory(dataStorage.getSpecificProjects(category));
		} else {
			consolePart_3(category);
		}
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayQuote(dataStorage.getRundomQuote());
		consoleView.displayListCategories(dataStorage.getCategoriesList());
		consolePart_1();
	}
}
package com.kickstarter.controller;
import java.util.List;

import com.kickstarter.model.Categories;
import com.kickstarter.model.InMemoryCategories;
import com.kickstarter.model.QuotesStorage;
import com.kickstarter.model.Project;
import com.kickstarter.model.ProjectsStorage;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.ConsoleView;
import com.kickstarter.view.InPut;

public class KickstarterEngine {

	private InPut inPut;
	private ConsoleView consoleView;
	private QuotesStorage quotesStorage;
	private Categories categories;
	private ProjectsStorage projectsStorage;
	
	public KickstarterEngine(ConsoleView consoleView, QuotesStorage quotesStorage , InPut inPut, Categories categories, ProjectsStorage projects) {
		this.consoleView = consoleView;
		this.inPut = inPut;
		this.quotesStorage = quotesStorage;
		this.categories = categories;
		this.projectsStorage = projects;
	}

	public void consolePart_1() {
		System.out.print("\n" + "Please select category: ");
		int input = inPut.readInput();
		if(input > 0 && input <= categories.size()) {
			Сategory category = categories.get(input);
			consoleView.displaySelectedCategory(category);
			List<Project> projects = projectsStorage.getSpecificProjects(category);
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
		if (input > 0 && input <= projectsStorage.getSizeProjectsOfCategory()) {
			consoleView.displayCurrentProject(projectsStorage.getProject(input));
			consolePart_3(сategory);
			consolePart_2(сategory);
		} else if (input == 0) {
			consoleView.displayListCategories(categories.getCategories());
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_2(сategory);
		}
	}

	public void consolePart_3(Сategory category) {
		System.out.print("\n" + "Press \"0\"  - back to projects: ");
		int input = inPut.readInput();
		if (input == 0) {
			consoleView.displayProjectsOfCategory(projectsStorage.getSpecificProjects(category));
		} else {
			consolePart_3(category);
		}
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayQuote(quotesStorage.getRundomQuote());
		consoleView.displayListCategories(categories.getCategories());
		consolePart_1();
	}
}
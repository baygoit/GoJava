package com.kickstarter.controller;

import java.util.List;

import com.kickstarter.model.Categories;
import com.kickstarter.model.Project;
import com.kickstarter.model.Projects;
import com.kickstarter.model.QuotesStorage;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.ConsoleView;
import com.kickstarter.view.InPut;

public class KickstarterEngine {

	private InPut inPut;
	private ConsoleView consoleView;
	private QuotesStorage quotesStorage;
	private Categories categoriesStorage;
	private Projects projectStorage;

	public KickstarterEngine(ConsoleView consoleView,
			QuotesStorage quotesStorage, InPut inPut, Categories categories,
			Projects projectStorage) {
		
		this.consoleView = consoleView;
		this.inPut = inPut;
		this.quotesStorage = quotesStorage;
		this.categoriesStorage = categories;
		this.projectStorage = projectStorage;
	}

	public void consolePart_1() {
		System.out.print("\n" + "Please select category: ");
		int input = inPut.readInput();
		if (input > 0 && input <= categoriesStorage.size()) {
			Сategory category = categoriesStorage.get(input);
			consoleView.displaySelectedCategory(category);
			List<Project> projects = projectStorage.getProjects(category);
			consoleView.displayProjectsOfCategory(projects);
			consolePart_2(category);
			consolePart_1();
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_1();
		}
	}

	public void consolePart_2(Сategory сategory) {
		System.out.print("(Press \"0\" - back to categories.)" + "\n"
				+ "Select project: ");
		int input = inPut.readInput();
		if (input > 0 && input <= projectStorage.getSize()) {
			consoleView.displayCurrentProject(projectStorage.get(input));
			consolePart_3(сategory);
			consolePart_2(сategory);
		} else if (input == 0) {
			consoleView
					.displayListCategories(categoriesStorage.getCategories());
		} else {
			System.out.println("Incorrect number. Please try again.");
			consolePart_2(сategory);
		}
	}

	public void consolePart_3(Сategory category) {
		System.out.print("\n" + "Press \"0\"  - back to projects: ");
		int input = inPut.readInput();
		if (input == 0) {
			consoleView.displayProjectsOfCategory(projectStorage
					.getProjects(category));
		} else {
			consolePart_3(category);
		}
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayQuote(quotesStorage.getRundomQuote());
		consoleView.displayListCategories(categoriesStorage.getCategories());
		consolePart_1();
	}
}
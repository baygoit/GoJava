package com.kickstarter.controller;

import java.util.List;

import com.kickstarter.model.Categories;
import com.kickstarter.model.QuotesDAO;
import com.kickstarter.model.Project;
import com.kickstarter.model.Projects;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.In;
import com.kickstarter.view.View;
import com.kickstarter.view.InPutConsole;

public class KickstarterEngine {

	private In inPut;
	private View consoleView;
	private QuotesDAO quotesStorage;
	private Categories categoriesStorage;
	private Projects projectStorage;
	

	public KickstarterEngine(View consoleView,
			QuotesDAO quotesStorage, In inPut, Categories categories,
			Projects projectStorage) {
		
		this.consoleView = consoleView;
		this.inPut = inPut;
		this.quotesStorage = quotesStorage;
		this.categoriesStorage = categories;
		this.projectStorage = projectStorage;
	}

	public void consolePart_1() {
		consoleView.select(1);
		int input = inPut.readInput();
		if (input > 0 && input <= categoriesStorage.size()) {
			Сategory category = categoriesStorage.get(input);
			consoleView.displaySelectedCategory(category);
			List<Project> projects = projectStorage.getProjects(category);
			consoleView.displayProjects(projects);
			consolePart_2(category);
			consolePart_1();
		} else {
			consoleView.incorrect();
			consolePart_1();
		}
	}

	public void consolePart_2(Сategory сategory) {
		consoleView.select(2);
		int input = inPut.readInput();
		if (input > 0 && input <= projectStorage.getSize()) {
			consoleView.displayProject(projectStorage.get(input));
			consolePart_3(сategory);
			consolePart_2(сategory);
		} else if (input == 0) {
			consoleView.displayListCategories(categoriesStorage.getCategories());
		} else {
			consoleView.incorrect();
			consolePart_2(сategory);
		}
	}

	public void consolePart_3(Сategory category) {
		consoleView.select(3);
		int input = inPut.readInput();
		if (input == 0) {
			consoleView.displayProjects(projectStorage.getProjects(category));
		} else {
			consolePart_3(category);
		}
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayQuote(quotesStorage.getRandomQuote());
		consoleView.displayListCategories(categoriesStorage.getCategories());
		consolePart_1();
	}
}
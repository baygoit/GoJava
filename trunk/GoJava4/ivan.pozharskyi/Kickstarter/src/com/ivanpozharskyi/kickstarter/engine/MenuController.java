package com.ivanpozharskyi.kickstarter.engine;

import com.ivanpozharskyi.kickstarter.datastorage.Category;
import com.ivanpozharskyi.kickstarter.datastorage.CategoryStorage;
import com.ivanpozharskyi.kickstarter.datastorage.Project;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;
import com.ivanpozharskyi.kickstarter.datastorage.QuotesStorage;
import com.ivanpozharskyi.kickstarter.userinterface.MenuMain;
import com.ivanpozharskyi.kickstarter.userinterface.MenuProject;
import com.ivanpozharskyi.kickstarter.userinterface.MenuProjects;
import com.ivanpozharskyi.kickstarter.userinterface.MenuTypes;

public class MenuController {
	private MenuRunner menuRunner;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	private QuotesStorage quotesStorage;
	private Readable reader;
	private MenuTypes currentMenu = MenuTypes.MenuMain;
	private int choice;
	private Category currentCategory;
	private Project currentProject;
	private int previousChoice;
	private Printer printer;

	public MenuController(CategoryStorage categoryStorage,
			ProjectStorage projectStorage,QuotesStorage quotesStorage, Printer printer, Readable reader) {
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.quotesStorage = quotesStorage;
		this.printer = printer;
		this.reader = reader;
	}

	public void chooseMenu() {
		while (true) {
			if (currentMenu == MenuTypes.MenuMain) {
				runMenuMain();
			} else {
				if (currentMenu == MenuTypes.MenuProjects) {
					runMenuProjects();
				} else {
					runMenuProject();
				}
			}
		}
	}

	private void runMenuProject() {
		currentProject = projectStorage.getProjectsInCategory(currentCategory)
				.getProject(choice);
		menuRunner.setMenu(new MenuProject(projectStorage
				.getProjectsInCategory(currentCategory), printer));
		menuRunner.setChoise(currentProject);
		menuRunner.showMenu();
		while (choice != 0) {
			choice = reader.read();
		}
		currentMenu = MenuTypes.MenuProjects;

	}

	private void runMenuProjects() {

		menuRunner.setMenu(new MenuProjects(projectStorage, printer));
		currentCategory = categoryStorage.getCategory(previousChoice);
		menuRunner.setChoise(currentCategory);
		menuRunner.showMenu();
		choice = reader.read();
		if (choice == 0) {
			currentMenu = MenuTypes.MenuMain;
		} else {
			currentMenu = MenuTypes.MenuProject;
		}
	}

	private void runMenuMain() {

		menuRunner = new MenuRunner();
		menuRunner.setMenu(new MenuMain(categoryStorage,quotesStorage, printer));
		menuRunner.showMenu();
		choice = reader.read();
		if (choice == 0) {
			System.exit(0);
		} else {
			currentMenu = MenuTypes.MenuProjects;
			previousChoice = choice;
		}
	}

}

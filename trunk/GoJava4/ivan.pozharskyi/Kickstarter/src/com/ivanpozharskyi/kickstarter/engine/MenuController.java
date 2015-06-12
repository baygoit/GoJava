package com.ivanpozharskyi.kickstarter.engine;

import java.sql.SQLException;

import com.ivanpozharskyi.kickstarter.entity.Categories;
import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.CategoriesImpl;
import com.ivanpozharskyi.kickstarter.entity.Project;
import com.ivanpozharskyi.kickstarter.entity.Projects;
import com.ivanpozharskyi.kickstarter.entity.ProjectsImpl;
import com.ivanpozharskyi.kickstarter.entity.Quotes;
import com.ivanpozharskyi.kickstarter.entity.QuotesImpl;
import com.ivanpozharskyi.kickstarter.userinterface.MenuMain;
import com.ivanpozharskyi.kickstarter.userinterface.MenuProject;
import com.ivanpozharskyi.kickstarter.userinterface.MenuProjects;
import com.ivanpozharskyi.kickstarter.userinterface.MenuTypes;

public class MenuController {
	private MenuRunner menuRunner;
	private Categories categories;
	private Projects projects;
	private Quotes quotes;
	private Readable reader;
	private MenuTypes currentMenu = MenuTypes.MenuMain;
	private int choice;
	private Category currentCategory;
	private Project currentProject;
	private int previousChoice;
	private Printer printer;

	public MenuController(Categories categories,
			Projects projects,Quotes quotes, Printer printer, Readable reader) {
		this.categories = categories;
		this.projects = projects;
		this.quotes = quotes;
		this.printer = printer;
		this.reader = reader;
	}

	public void chooseMenu() throws SQLException {
							//TO DO  normal exception
		while (true) {
			boolean correctChoice = false;	
			if (currentMenu == MenuTypes.MenuMain) {
				while(!correctChoice){
					try{
						runMenuMain();
						correctChoice = true;
					} catch(IllegalArgumentException ex){
						printer.println("choosen category does not exist");	//don't print
						correctChoice = false;
					}
				}
				
			} else {
				
				if (currentMenu == MenuTypes.MenuProjects) {
					correctChoice = false;
					while(!correctChoice){
						try{
							runMenuProjects();
							correctChoice = true;
						} catch(IllegalArgumentException ex){
							printer.println("dsfsaf");							//don't print
							correctChoice = false;
						}
					}
				} else {
					runMenuProject();
				}
			}
		}
	}

	private void runMenuProject() throws SQLException {
		currentProject = projects.getProjectsInCategory(currentCategory)
				.get(choice-1);												//TO DO magic number
		menuRunner.setMenu(new MenuProject(projects
				.getProjectsInCategory(currentCategory), printer));
		menuRunner.setChoise(currentProject);
		menuRunner.showMenu();
		while (choice != 0) {
			choice = reader.read();
		}
		currentMenu = MenuTypes.MenuProjects;

	}

	private void runMenuProjects() throws SQLException {

		menuRunner.setMenu(new MenuProjects(projects, printer));
		currentCategory = categories.getCategory(previousChoice);
		menuRunner.setChoise(currentCategory);
		menuRunner.showMenu();
		choice = reader.read();
		if(choice < 0 || choice > projects.getProjectsInCategory(currentCategory).size()){
			throw new IllegalArgumentException();
		}
		if (choice == 0) {
			currentMenu = MenuTypes.MenuMain;
		} else {
			currentMenu = MenuTypes.MenuProject;
		}
	}

	private void runMenuMain() throws IllegalArgumentException, SQLException {

		menuRunner = new MenuRunner();
		menuRunner.setMenu(new MenuMain(categories.getAll(),quotes, printer));
		menuRunner.showMenu();
		choice = reader.read();
		if (choice<0 || choice>categories.getSize()){
			throw new IllegalArgumentException("try again: ");
		}
		if (choice == 0) {
			System.exit(0);
		} else {
			currentMenu = MenuTypes.MenuProjects;
			previousChoice = choice;
		}
	}

}

package com.goit.kickstarter.service;

import java.sql.Connection;
import java.sql.DriverManager;

import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.dao.ProjectDAO;
import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.Project;
import com.goit.kickstarter.view.ConsoleIO;

public class Kickstarter {
	
	private Connection connection;	
	private ConsoleIO io = new ConsoleIO();
	private InputCheck checker = new InputCheck(io);
	private ProjectDAO projDao = new ProjectDAO();
	private CategoryDAO catDao = new CategoryDAO(connection);
	private ProjectService service = new ProjectService(connection);
	
	public Kickstarter(Connection c){
		connection=c;
	}
	public void run(){
		io.out("Welcome to the place where your dreams become real possibilities! ;)\n");
		
		categoriesMenu();
		
		io.out("Good bye! :)");
	}
	
	public void categoriesMenu(){
		Menu menu = new Menu(checker) {
			
			@Override
			void showPositions() {
				service.showCategories();
			}
			
			@Override
			void nextSubmenu(Object object, int choice) {
				categoryMenu((Category)object);
			}
			
			@Override
			Object getObject(int choice) {
				return catDao.getCategory(choice);
			}
		};
		menu.run(catDao.getLength());
	}
	
	public void categoryMenu(Category category){
		Menu menu = new Menu(checker) {
			
			@Override
			void showPositions() {
				service.showProjects(category.getId());
			}
			
			@Override
			void nextSubmenu(Object object, int choice) {
				projectMenu(((Project)object).getTitle());
			}
			
			@Override
			Object getObject(int choice) {
				return projDao.getProject(choice);
			}
		};
		menu.run(projDao.getLength("WHERE category=\'"+category+"\'"));
	}
	
	public void projectMenu(String project){
		Menu menu = new Menu(checker) {
			
			@Override
			void showPositions() {
				service.showProject(project);
			}
			
			@Override
			void nextSubmenu(Object object, int choice) {
				inProjectMenu(((Project)object).getTitle());
			}
			
			@Override
			Object getObject(int choice) {
				return projDao.getProject(project);
			}
		};
		menu.run(2);
	}
	
	public void inProjectMenu(String project) {
		
	}
}
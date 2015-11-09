package com.kickstarter.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;
import com.kickstarter.dao.CategoryDAO;
import com.kickstarter.dao.CommonDAO;
import com.kickstarter.dao.PledgeDAO;
import com.kickstarter.dao.ProjectDAO;
import com.kickstarter.dao.QuoteDAO;
import com.kickstarter.view.MainPage;

public class MainPageController {

	private final Random RND = new Random();
	private MainPage page;
	private CommonDAO<Quote> quoteDAO;
	private CommonDAO<Category> categoryDAO;
	private ProjectDAO projectDAO;
	private PledgeDAO pledgeDAO;
	private Scanner sc;
	
	public MainPageController(MainPage page) {
		this.page = page;
		quoteDAO = new QuoteDAO();
		categoryDAO = new CategoryDAO();
		projectDAO = new ProjectDAO();
		pledgeDAO = new PledgeDAO();
		sc = new Scanner(System.in);
	}
	
	public void showMainPage() {
	
		showCategories();
	
	}
	
	public void showCategories(){
		List<Category> categories = categoryDAO.getAll();
		
		showTopPage();
		page.showCategories(categories);
		
		int option = getUserInput(categories.size());
		if (option == 0) {
			return;
		} 
		
		showProjectsInCategory(categories.get(option-1));
		
		showCategories();
	}

	public void showProjectsInCategory(Category category)  throws InputMismatchException{
		List<Project> foundProjects = projectDAO.getByCategory(category); 
		
		showTopPage();
		page.showProjects(foundProjects);
		
		int option = getUserInput(foundProjects.size());
		if (option == 0) {
			return;
		}
		
		showProjectDetails(foundProjects.get(option-1));
		
		showProjectsInCategory(category);
	}

	private int getUserInput(int limit) {
		int option = -1;
		do{
			if (sc.hasNextInt()) {
				option = sc.nextInt();
			} else {
				sc.next();
			}
			
			if (option > limit || option < 0) {
				page.showMessage("Use positive numeric index not higher than " + limit);
			}
		}
		while(option > limit || option < 0);
		
		return option;
	}

	public void showProjectDetails(Project project){
		showTopPage();
		page.showProjectDetails(project);
		
		int option = getUserInput(0);
		if (option == 0) {
			return;
		}
		
		showProjectDetails(project);
	}

	private void showTopPage() {
		
		List<Quote> quotes = quoteDAO.getAll();
		
		page.showDivider();
		
		if (quotes.size() > 0) {
			page.showQuote(quotes.get(RND.nextInt(quotes.size())));
		}
		
	}

}

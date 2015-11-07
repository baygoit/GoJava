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
import com.kickstarter.dao.ProjectDAO;
import com.kickstarter.dao.QuoteDAO;
import com.kickstarter.view.MainPage;

public class MainPageController {

	private final Random RND = new Random();
	private MainPage page;
	private CommonDAO<Quote> quoteDAO;
	private CommonDAO<Category> categoryDAO;
	private ProjectDAO projectDAO;
	private Scanner sc;
	
	public MainPageController(MainPage page) {
		this.page = page;
		quoteDAO = new QuoteDAO();
		categoryDAO = new CategoryDAO();
		projectDAO = new ProjectDAO();
		sc = new Scanner(System.in);
	}
	
	public void showMainPage() {
		
		try {
			showCategories();
		} catch (InputMismatchException e) {
			sc.nextLine();
			page.showMessage("Use correct numeric index! \nPress <Enter> to return to main page");
			if (sc.nextLine().isEmpty()) {
				showMainPage();
			}
		}
	
	}
	
	public void showCategories() throws InputMismatchException{
		List<Category> categories = categoryDAO.getAll();
		
		showTopPage();
		page.showCategories(categories);
		
		int option = sc.nextInt();
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
		
		int option = sc.nextInt();
		if (option == 0) {
			return;
		}
		
		showProjectDetails(foundProjects.get(option-1));
		
		showProjectsInCategory(category);
	}

	public void showProjectDetails(Project project)  throws InputMismatchException{
		showTopPage();
		page.showProjectDetails(project);
		
		int option = sc.nextInt();
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

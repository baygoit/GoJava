package com.goit.kickstarter.glmax.controller;

import java.util.*;

import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.PaymentVariant;
import com.goit.kickstarter.glmax.enteties.Project;
import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.pages.Page;
import com.goit.kickstarter.glmax.pages.PageFactory;
import com.goit.kickstarter.glmax.view.*;

public class Runner {
	private DataSource dataSource;
	private PageFactory pageFactory;
	private Input reader;
	private Output printer;

	public Runner(DataSource dataSource, View view) {
		this.dataSource = dataSource;
		this.pageFactory = new ConsolePageFactory(dataSource);
		this.reader = new ConsoleIn();
		this.printer = new ConsoleOut();

	}

	public void run() {
		Page currentPage = initManePage();
		currentPage.show(printer);
		int userChois;
		
		while (true) {
			userChois = reader.getValidatedUserChois(currentPage.getMenuVariantsAmount());
			if (userChois == 0) {
				currentPage = currentPage.getParentPage();
				currentPage.show(printer);
			} else {
				currentPage = currentPage.getChildPage(userChois);
				
				//TODO finished here
			}
		}
	}

	private Page initManePage() {
		Page result = pageFactory.getPage(Position.Main, dataSource.getSomeQuote());
		ArrayList<Page> childPages;
		for (Category category : dataSource.getCategories()) {
			childPages.add(pageFactory.getPage(Position.Category, category));
		}
		result.addChildPages(childPages);
		return result;
	}

	private void moveForward(int nextPosition) {
		if (currentLevel == Position.Main) {
			currentLevel = Position.Category;
			currentMenuObjectIndex = nextPosition;
		} else if (currentLevel == Position.Category) {
			currentLevel = Position.Project;
			menuHistory.put(Position.Category, currentMenuObjectIndex);
			currentMenuObjectIndex = nextPosition;
		} else if (currentLevel == Position.Project && nextPosition == 1) {
			currentLevel = Position.Payment;
			menuHistory.put(Position.Project, currentMenuObjectIndex);
			currentMenuObjectIndex = 1;
		} else if (currentLevel == Position.Project && nextPosition == 2) {
			currentLevel = Position.Question;
			menuHistory.put(Position.Project, currentMenuObjectIndex);
			currentMenuObjectIndex = 2;
		}
	}

	private void moveBack() {
		if (currentLevel == Position.Main) {
			dataSource.persistData();
			System.exit(0);
		} else if (currentLevel == Position.Category) {
			currentLevel = Position.Main;
			currentMenuObjectIndex = 0;
		} else if (currentLevel == Position.Project) {
			currentLevel = Position.Category;
			currentMenuObjectIndex = menuHistory.get(Position.Category);
		} else if (currentLevel == Position.Payment) {
			currentLevel = Position.Project;
			currentMenuObjectIndex = menuHistory.get(Position.Project);
		} else if (currentLevel == Position.Question) {
			currentLevel = Position.Project;
			currentMenuObjectIndex = menuHistory.get(Position.Project);
		}

	}


	public String getSomeQoute() {
		return dataSource.getSomeQuote();
	}

	public ArrayList<Category> getCategories() {
		return dataSource.getCategoriesList();
	}

	public int getCurrentEntetieIndex() {
		return currentMenuObjectIndex;
	}

	public String getCategoryName() {
		return dataSource.getCategoryName(currentMenuObjectIndex);
	}

	public ArrayList<Project> getProjectsList() {
		return dataSource.getProjectsList(currentMenuObjectIndex);
	}

	public Project getProject() {
		return dataSource.getProject(menuHistory.get(Position.Category), currentMenuObjectIndex);
	}

	public PaymentVariant getpaymentVariants() {
		return dataSource.getpaymentVariants(menuHistory.get(Position.Category), menuHistory.get(Position.Project));
	}
}

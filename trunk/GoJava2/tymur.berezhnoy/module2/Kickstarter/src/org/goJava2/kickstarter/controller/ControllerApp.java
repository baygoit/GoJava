package org.goJava2.kickstarter.controller;

import org.goJava2.kickstarter.model.Category;
import org.goJava2.kickstarter.model.QuoteStorage;
import org.goJava2.kickstarter.model.GeneralStorage;
import org.goJava2.kickstarter.view.View;

public class ControllerApp implements QuoteManagement, StorageManagement {

	private GeneralStorage storage;
	private QuoteStorage qouteStorage;
	private View view;
	private Category category;
	
	public ControllerApp(QuoteStorage qouteStorage, GeneralStorage storage, View view) {
		this.storage = storage;
		this.qouteStorage = qouteStorage;
		this.view = view;
	}
	
	@Override
	public void displayQuote() {
		view.displayHead(qouteStorage.getRandomQuote());
	}
	
	@Override
	public void displayCategorys() {
		view.displayCategories(storage.getCategories());
	}
	
	public void selectCategory(int input) {
			category = storage.getCategories().get(input - 1);
			displayCurrentCategory();
			displaySpecificProjects();
	}
	
	public void displayCurrentCategory() {
		view.displaySelectedCategory(category);
	}
	
	public void selectProject(int i) {
		view.displayCurrentProject(storage.getSpecificProjects(category).get(i - 1));
	}
	
	@Override
	public void displaySpecificProjects() {
		view.displayProjects(storage.getSpecificProjects(category));
	}
}
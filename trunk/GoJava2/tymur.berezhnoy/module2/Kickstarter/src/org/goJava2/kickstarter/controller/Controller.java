package org.goJava2.kickstarter.controller;

import org.goJava2.kickstarter.model.Category;
import org.goJava2.kickstarter.model.QuoteStorage;
import org.goJava2.kickstarter.model.GeneralStorage;
import org.goJava2.kickstarter.view.View;

public class Controller implements QuoteManagement, StorageManagement {

	private GeneralStorage storage;
	private QuoteStorage quoteStorage;
	private View view;
	private Category category;
	
	public Controller(QuoteStorage quoteStorage, GeneralStorage storage, View view) {
		this.storage = storage;
		this.quoteStorage = quoteStorage;
		this.view = view;
	}
	
	@Override
	public void displayQuote() {
		view.displayHead(quoteStorage.getRandomQuote());
	}
	
	@Override
	public void displayCategories() {
		view.displayCategories(storage.getCategories());
	}
	
	@Override
	public void selectCategory(int input) {
			category = storage.getCategories().get(input - 1);
			displayCurrentCategory();
			displaySpecificProjects();
	}
	
	@Override
	public void displayCurrentCategory() {
		view.displaySelectedCategory(category);
	}
	
	@Override
	public void selectProject(int i) {
		view.displayCurrentProject(storage.getSpecificProjects(category).get(i - 1));
	}
	
	@Override
	public void displaySpecificProjects() {
		view.displayProjects(storage.getSpecificProjects(category));
	}
}
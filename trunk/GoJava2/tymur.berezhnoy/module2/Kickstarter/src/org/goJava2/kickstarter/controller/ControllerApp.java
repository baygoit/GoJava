package org.goJava2.kickstarter.controller;
import java.util.ArrayList;

import org.goJava2.kickstarter.model.Category;
import org.goJava2.kickstarter.model.Project;
import org.goJava2.kickstarter.model.Quote;
import org.goJava2.kickstarter.model.QuoteStorage;
import org.goJava2.kickstarter.model.GeneralStorage;

public class ControllerApp implements QuoteManagement, StorageManagement {

	private GeneralStorage storage;
	private QuoteStorage qouteStorage;
	
	public ControllerApp(QuoteStorage qouteStorage, GeneralStorage storage) {
		this.storage = storage;
		this.qouteStorage = qouteStorage;
	}
	
	@Override
	public void createQuote(String content, String author) {
		Quote quote = new Quote(content, author);
		qouteStorage.addQuoteToStorage(quote);
	}
	
	@Override
	public Quote getQuote() {
		return qouteStorage.getRandomQuote();
	}
	
	@Override
	public ArrayList<Category> getCategories() {
		return storage.getCategories();
	}
	
	@Override
	public ArrayList<Project> getSpecificProjetcs(Category category) {
		return storage.getSpecificProjects(category);
	}
}
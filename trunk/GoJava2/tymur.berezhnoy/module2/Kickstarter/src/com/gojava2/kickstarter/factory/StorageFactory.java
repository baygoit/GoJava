package com.gojava2.kickstarter.factory;

import com.gojava2.kickstarter.model.CategoryStorage;
import com.gojava2.kickstarter.model.ProjectStorage;
import com.gojava2.kickstarter.model.QuoteStorage;

public class StorageFactory {
	
	private static QuoteStorage quoteStorage;
	private static CategoryStorage categoryStorage;
	private static ProjectStorage projectStorage;
	
	public QuoteStorage getQuoteStorage() {
		if(quoteStorage == null) {
			quoteStorage = new QuoteStorage();
		}
		return quoteStorage;
	}
	
	public CategoryStorage getCategoryStorage() {
		if(categoryStorage == null) {
			categoryStorage = new CategoryStorage();
		}
		return categoryStorage;
	}
	
	public ProjectStorage getProjectStorage() {
		if(projectStorage == null) {
			projectStorage = new ProjectStorage();
		}
		return projectStorage;
	}
}
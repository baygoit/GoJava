package org.goJava2.kickstarter.factory;

import org.goJava2.kickstarter.model.CategoryStorage;
import org.goJava2.kickstarter.model.ProjectStorage;
import org.goJava2.kickstarter.model.QuoteStorage;

public class StorageFactory {
	
	private static QuoteStorage quoteStorage;
	private static CategoryStorage categoryStorage;
	private static ProjectStorage projectStorage;
	
	public static QuoteStorage getQuoteStorage() {
		if(quoteStorage == null) {
			quoteStorage = new QuoteStorage();
		}
		return quoteStorage;
	}
	
	public static CategoryStorage getCategoryStorage() {
		if(categoryStorage == null) {
			categoryStorage = new CategoryStorage();
		}
		return categoryStorage;
	}
	
	public static ProjectStorage getProjectStorage() {
		if(projectStorage == null) {
			projectStorage = new ProjectStorage();
		}
		return projectStorage;
	}
}
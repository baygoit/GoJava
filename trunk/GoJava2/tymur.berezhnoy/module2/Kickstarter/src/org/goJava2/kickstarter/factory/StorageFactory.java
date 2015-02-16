package org.goJava2.kickstarter.factory;

import org.goJava2.kickstarter.model.CategoryStorage;
import org.goJava2.kickstarter.model.ProjectStorage;
import org.goJava2.kickstarter.model.QuoteStorage;
import org.goJava2.kickstarter.model.ReadCategoryFromDB;

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
	
//	public CategoryStorage getCategoryStorage() {
//		if(categoryStorage == null) {
//			categoryStorage = new CategoryStorage();
//		}
//		return categoryStorage;
//	}
	
	public ProjectStorage getProjectStorage() {
		if(projectStorage == null) {
			projectStorage = new ProjectStorage(getCategoryStorageCustom());
		}
		return projectStorage;
	}
	
	public CategoryStorage getCategoryStorageCustom() {
		if(categoryStorage == null) {
			categoryStorage = new CategoryStorage(new ReadCategoryFromDB().getCategoryFromFile());
		}
		return categoryStorage;
	}
}
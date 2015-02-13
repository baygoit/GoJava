package ua.home.kickstarter.factory;

import ua.home.kickstarter.model.CategoryStorage;
import ua.home.kickstarter.model.ProjectStorage;

public class StorageFactory {

	private static CategoryStorage categoryStorage;
	private static ProjectStorage projectStorage;
	
	public CategoryStorage getCategoryStorage() {
		if (categoryStorage == null) {
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
package org.goJava2.kickstarter.controller;
import java.util.ArrayList;

import org.goJava2.kickstarter.model.Category;
import org.goJava2.kickstarter.model.Project;

public interface StorageManagement {
	
	public ArrayList<Category> getCategories();
	public ArrayList<Project> getSpecificProjetcs(Category category);
}
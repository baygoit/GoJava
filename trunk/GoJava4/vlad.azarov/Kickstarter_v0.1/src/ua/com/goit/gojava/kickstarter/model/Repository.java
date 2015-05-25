package ua.com.goit.gojava.kickstarter.model;

import java.util.ArrayList;

public interface Repository {

	ArrayList<Project> getProjectsOfCategoryArray(Category category);    
}

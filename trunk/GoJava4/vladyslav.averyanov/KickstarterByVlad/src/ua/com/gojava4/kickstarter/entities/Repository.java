package ua.com.gojava4.kickstarter.entities;

import java.util.ArrayList;

public interface Repository {

	ArrayList<Project> getProjectsOfCategoryArray(categoryRepository category);    
}

package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public interface Categories {


	List<Project> getProjects(Category category);

	Project getProject(int i) throws IlligalInputException;

	int size();

}
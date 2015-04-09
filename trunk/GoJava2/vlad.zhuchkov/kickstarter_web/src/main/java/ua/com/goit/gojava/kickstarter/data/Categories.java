package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public interface Categories {


	List<Project> getProjects(int id);

	Project get(int i) throws IlligalInputException;

	int size();

}
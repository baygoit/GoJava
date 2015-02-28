package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public interface Category {

	String getName();

	List<String> getProjectCatalog();

	Project getProject(int i) throws IlligalInputException;

	int size();

}
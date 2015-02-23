package ua.com.goit.gojava.kickstarter;


import java.util.List;

import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;
import ua.com.goit.gojava.kickstarter.in_memory_storage.Project;

public interface Category {

	String getName();

	List<String> getProjectCatalog();

	Project getProject(int i) throws IlligalInputException;

	int size();

}
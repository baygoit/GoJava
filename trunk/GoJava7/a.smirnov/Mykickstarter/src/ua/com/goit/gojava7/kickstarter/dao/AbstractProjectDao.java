package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public abstract class AbstractProjectDao {
	
	public final String SEMICOLON_DELIMITER = ";";
	public final String NEW_LINE_SEPARATOR = "\n";
	
	public final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	public final String USER_NAME = "root";
	public final String PASSWORD = "root";
	
	public abstract void add(Project element);

	public abstract void remove(Project element);
	
	public abstract List<Project> getAll();
	
	public abstract int getSize();

	public abstract List<Project> getProjectsFromCategory(Category category);

}

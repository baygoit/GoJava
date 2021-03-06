package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public abstract class AbstractCategoryDao {
	
	public final String SEMICOLON_DELIMITER = ";";
	public final String NEW_LINE_SEPARATOR = "\n";
	
	public final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	public final String USER_NAME = "root";
	public final String PASSWORD = "root";
	
	public abstract void add(Category element);

	public abstract void remove(Category element);
	
	public abstract List<Category> getAll();
	
	public abstract int getSize();
}

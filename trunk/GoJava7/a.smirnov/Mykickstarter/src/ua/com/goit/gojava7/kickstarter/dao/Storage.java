package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

public interface Storage<T> {
	
	public final String SEMICOLON_DELIMITER = ";";
	public final String NEW_LINE_SEPARATOR = "\n";
	
	public final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	public final String USER_NAME = "root";
	public final String PASSWORD = "root";
	
	public abstract void add(T element);

	public abstract void remove(T element);
	
	public abstract List<T> getAll();
	
	public abstract int getSize();

}

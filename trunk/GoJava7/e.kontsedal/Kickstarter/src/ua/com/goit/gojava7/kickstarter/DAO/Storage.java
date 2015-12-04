package ua.com.goit.gojava7.kickstarter.DAO;

import java.util.List;

public interface Storage<T> {
	
	public final String DBPASSWORD = "admin";
	public final String DBLOGIN = "admin";
	public final String DATABASE_URL = "jdbc:mysql://localhost:3306/kickstarter";
	
	
	List<T> getAll();
	
	void add(T element);
	
}

package ua.com.goit.gojava7.kickstarter.DAO;

import java.util.List;

public interface Storage<T> {
	
	List<T> getAll();
	
	void add(T element);
	
}

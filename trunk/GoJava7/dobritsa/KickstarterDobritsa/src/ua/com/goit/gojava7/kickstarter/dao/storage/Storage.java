package ua.com.goit.gojava7.kickstarter.dao.storage;

import java.util.List;

public interface Storage<T> {
		
	List<T> getAll();
	
	void setAll(List<T> list);

	T get(int index);

	int size();
	
}

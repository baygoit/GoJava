package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Storage<T> {
	
	protected List<T> dataSource;

	protected Storage() {
		dataSource = new ArrayList<>();
	}

	public List<T> getAll() {
		return Collections.unmodifiableList(dataSource);
	}
	
	public T get(int index) {
		//TODO Error
		
		return dataSource.get(index);
	}

	public void add(T element) {
		dataSource.add(element);
	}

	public void remove(T element) {
		dataSource.remove(element);
	}
	
	public int size() {
		return dataSource.size();
	}
	
	public int indexOf(T element) {
		return dataSource.indexOf(element);
		
	}
	
}

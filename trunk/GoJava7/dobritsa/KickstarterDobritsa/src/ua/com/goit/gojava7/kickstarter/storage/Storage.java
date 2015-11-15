package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Storage<T> {
	
	protected List<T> data;

	protected Storage() {
		data = new ArrayList<>();
	}

	public List<T> getAll() {
		return Collections.unmodifiableList(data);
	}
	
	public void setAll(List<T> dataSource) {
		this.data = dataSource;
	}
	
	public T get(int index) {
		if(data.size() == 0) {
			System.out.println("Nothing to show");
			System.exit(0);
			return null;
		}		
		return data.get(index);
	}

	public void add(T element) {
		data.add(element);
	}

	public void remove(T element) {
		data.remove(element);
	}
	
	public int size() {
		return data.size();
	}
	
	public int indexOf(T element) {
		return data.indexOf(element);
		
	}
	
}

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
	
	public void setAll(List<T> data) {
		this.data = data;
	}
	
	public T get(int index) {
		if(data.size() == 0) {
			System.out.println("Nothing to show");
			//System.exit(0);
			return null;
		}		
		return data.get(index);
	}

	public void add(T element) {
		data.add(element);
	}

	public int size() {
		return data.size();
	}
	
}

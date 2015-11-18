package ua.com.goit.gojava7.kickstarter.templates;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractStorage<T> implements Templateble<T> {
	private List<T> storage;

	public AbstractStorage() {
		storage = new ArrayList<>();
	}

	public List<T> getAll() {
		return storage;
	}
	
	public int getSize() {
		return storage.size();
	}
	
	public void add(T element) {
		storage.add(element);
	}

	public void remove(T element) {
		storage.remove(element);
	}
}
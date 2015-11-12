package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTemplate<T> {
	protected List<T> sourceStorage;

	protected AbstractTemplate() {
		sourceStorage = new ArrayList<>();
	}

	public List<T> getAll() {
		return sourceStorage;
	}

	public void add(T element) {
		sourceStorage.add(element);
	}

	public void remove(T element) {
		sourceStorage.remove(element);
	}

	public List<T> getListOfSource() {
		return sourceStorage;
	}
}
package ua.com.goit.gojava7.kickstarter.dao;

import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.storage.Storage;

public abstract class MemoryDao<T> implements Storage<T> {

	protected List<T> data;

	protected MemoryDao(List<T> data) {
		this.data = data;
	}

	@Override
	public List<T> getAll() {
		return Collections.unmodifiableList(data);
	}

	public void setAll(List<T> data) {
		this.data = data;
	}
	
	@Override
	public T get(int index) {
		if (data.size() == 0) {
			System.out.println("Nothing to show");
			return null;
		}
		return data.get(index);
	}

	public void add(T element) {
		data.add(element);
	}

	@Override
	public int size() {
		return data.size();
	}

}

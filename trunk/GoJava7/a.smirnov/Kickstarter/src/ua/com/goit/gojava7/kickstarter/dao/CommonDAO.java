package ua.com.goit.gojava7.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonDAO<T> {
	protected List<T> dataSource;

	protected CommonDAO() {
		dataSource = new ArrayList<>();
	}

	public List<T> getAll() {
		return dataSource;
	}

	void add(T element) {
		dataSource.add(element);
	}

	void remove(T element) {
		dataSource.remove(element);
	}

	public List<T> getDataSource() {
		return dataSource;
	}
}
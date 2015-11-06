package com.kickstarter.dao;

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

	public void add(T element) {
		dataSource.add(element);
	}

	public void remove(T element) {
		dataSource.remove(element);
	}
}

package kickstarter.storages;

import java.util.TreeSet;

import kickstarter.engine.Data;

public abstract class AbstractStorage<T extends Data> implements Storage<T> {
	private TreeSet<T> dataSet = new TreeSet<T>();

	@Override
	public void add(T data) {
		dataSet.add(data);
	}

	@Override
	public int size() {
		return dataSet.size();
	}

	@Override
	public boolean isEmpty() {
		return dataSet.isEmpty();
	}

	@Override
	public T get(int id) {
		for (T data : dataSet) {
			if (data.getId() == id) {
				return data;
			}
		}
		throw new IndexOutOfBoundsException();
	}
}

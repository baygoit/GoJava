package kickstarter.storages;

import java.util.LinkedList;

import kickstarter.engine.Data;

public abstract class UniversalStorage<T extends Data> implements Storage<T> {
	private LinkedList<T> objects = new LinkedList<T>();

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		return objects.get(index);
	}

	@Override
	public T getById(int id) throws IndexOutOfBoundsException {
		for (int i = 0; i < size(); i++) {
			if (get(i).getId() == id) {
				return get(i);
			}
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void add(T object) {
		objects.add(object);
	}

	@Override
	public int size() {
		return objects.size();
	}

	@Override
	public boolean isEmpty() {
		return objects.isEmpty();
	}

}

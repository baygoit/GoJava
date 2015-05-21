package kickstarter.storages;

import java.util.HashSet;
import java.util.Iterator;

import kickstarter.engine.Data;

public abstract class UniversalStorage<T extends Data> implements Storage<T> {
	private HashSet<T> objects = new HashSet<T>();

	@Override
	public T get(int id) throws IndexOutOfBoundsException {
		Iterator<T> iterator = getIterator();
		while (iterator.hasNext()) {
			T object = iterator.next();
			if (object.getId() == id) {
				return object;
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

	@Override
	public Iterator<T> getIterator() {
		return objects.iterator();
	}
}

package storages;

import java.util.Arrays;

import data_types.Data;

public class UniversalStorage<T extends Data> implements Storage<T> {
	public static final int MINIMUM_STORAGE_SIZE = 10;

	private Data[] objects = new Data[MINIMUM_STORAGE_SIZE];
	private int size = 0;

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return (T) objects[index];
	}
	
	@Override
	public T getById(int id) throws IndexOutOfBoundsException {
		for (int i = 0; i < size(); i++) {
			if (objects[i].getId() == id) {
				return (T) objects[i];
			}
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void add(T object) {
		checkArrayLenght();
		objects[size++] = object;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		return size() == 0;
	}

	private void checkArrayLenght() {
		if (size() < objects.length) {
			return;
		}
		int newLength = objects.length + MINIMUM_STORAGE_SIZE;
		objects = Arrays.copyOf(objects, newLength);
	}
}

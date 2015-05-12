package kickstarter.Repository;

import java.util.Random;

public class EntityStorage<T> implements Storage<T> {
	final int INIT_SIZE = 10;
	final int ADD_TO_SIZE = 10;
	final int START_INDEX = 0;
	private Object[] objects = new Object[INIT_SIZE];
	int pointer = START_INDEX;

	@Override
	public void add(T entity) {
		if (pointer >= objects.length) {
			Object[] newObjects = new Object[objects.length + ADD_TO_SIZE];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects = newObjects;
			objects[pointer] = entity;
		}
		objects[pointer] = entity;
		pointer++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntity(int index) {
		return (T) objects[index];
	}

	@Override
	public int length() {
		int length = pointer;
		return length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getRandom() {
		int random = new Random().nextInt(length());
		return (T) objects[random];
	}
}

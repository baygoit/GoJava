package kickstarter.Repository;

import java.util.Random;

public class EntityStorage<T> implements Storage<T> {
	Object[] objects = new Object[10];
	int pointer = 0;

	@Override
	public void add(T entity) {
		if (pointer >= objects.length) {
			Object[] newObjects = new Object[objects.length + 10];
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

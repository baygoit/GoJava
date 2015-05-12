package kickstarter.Repository;

public class EntityStorage<T> implements Storage<T> {
	Object[] objects = new Object[10];
	int pointer=0;

	@Override
	public void add(T entity) {
		objects[pointer] = entity;
		pointer++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntity(int index) {
		
		return (T) objects[index];
	}

}

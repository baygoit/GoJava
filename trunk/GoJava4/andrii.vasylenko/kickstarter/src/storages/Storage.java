package storages;

import data_types.Data;

public interface Storage<T extends Data> {
	public T get(int index);
	
	public T getById(int id);

	public void add(T object);

	public int size();
	
	public boolean empty();
}

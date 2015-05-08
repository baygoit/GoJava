package kickstarter.storages;

import kickstarter.data_types.Data;

public interface Storage<T extends Data> {
	T get(int index);
	
	T getById(int id);

	void add(T object);

	int size();
	
	boolean empty();
}

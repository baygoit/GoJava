package kickstarter.storages;

import kickstarter.engine.Data;

public interface Storage<T extends Data> {
	T get(int id);

	void add(T object);

	int size();
	
	boolean isEmpty();
}

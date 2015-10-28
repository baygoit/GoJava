package kickstarter.container;

import java.util.List;

public class EntityContainer<T> {
	protected List data;

	public T get(int index) {
		return (T) data.get(index);
	}

	public int size() {
		return data.size();
	}

	public void add(T newData) {
		data.add(newData);
	}

	public List<T> getData() {
		return data;
	}
}

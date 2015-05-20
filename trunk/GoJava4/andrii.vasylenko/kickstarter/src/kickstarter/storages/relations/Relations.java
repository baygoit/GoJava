package kickstarter.storages.relations;

import kickstarter.engine.Data;
import kickstarter.storages.Storage;

public interface Relations<T extends Data, E extends Data> {
	void add(T value, E key);

	Storage<T> getProjects(E key);
}

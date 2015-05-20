package kickstarter.interfaces.display;

import kickstarter.engine.Data;

public interface Display<T extends Data> {
	String getDescription(T data);
}

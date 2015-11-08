package kickstarter.interfaces.display;

import java.util.Iterator;

import kickstarter.engine.Data;

public interface Display<T extends Data> {
	String getView(T data);

	String getView(Iterator<T> iterator);
}

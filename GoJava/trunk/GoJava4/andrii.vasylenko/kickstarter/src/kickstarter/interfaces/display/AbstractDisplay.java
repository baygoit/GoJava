package kickstarter.interfaces.display;

import java.util.Iterator;

import kickstarter.engine.Data;

public abstract class AbstractDisplay<T extends Data> implements Display<T> {

	@Override
	public String getView(Iterator<T> iterator) {
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(getView(iterator.next()));
		}

		return result.toString();
	}

}

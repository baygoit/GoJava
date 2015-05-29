package kickstarter.model;

import java.util.List;

public interface Model {
	List<String> getData();

	boolean showOnly();

	List<Object> getParameters(int item);
}

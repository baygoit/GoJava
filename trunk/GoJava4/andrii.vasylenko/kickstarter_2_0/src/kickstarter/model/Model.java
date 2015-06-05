package kickstarter.model;

import java.util.List;

import kickstarter.exception.ProcessedException;

public interface Model {
	List<String> getData() throws ProcessedException;

	boolean showOnly();

	List<Object> getParameters(int item, String input) throws ProcessedException;
}

package kickstarter.model;

import java.util.List;

import kickstarter.exception.CannotGetDataException;

public interface Model {
	List<String> getData() throws CannotGetDataException;

	boolean showOnly();

	List<Object> getParameters(int item) throws CannotGetDataException;
}

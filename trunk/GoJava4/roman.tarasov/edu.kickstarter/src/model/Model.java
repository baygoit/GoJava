package model;

import database.KickstarterException;

public interface Model {

	Object getAttribute(String name) throws KickstarterException;

	void setParameters(Object parameter);
}

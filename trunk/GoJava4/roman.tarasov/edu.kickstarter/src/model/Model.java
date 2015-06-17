package model;

import dao.pool.KickstarterException;

public interface Model {

	Object getAttribute(String name) throws KickstarterException;

	void setParameters(Object parameter);
}

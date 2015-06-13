package edu.kickstarter.model;


import edu.kickstarter.database.KickstarterException;

public interface Model {

	Object getAttribute(String name) throws KickstarterException;
	void setParameters(Object parameter);
}

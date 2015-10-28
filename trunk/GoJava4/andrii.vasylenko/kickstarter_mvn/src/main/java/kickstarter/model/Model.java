package kickstarter.model;

import java.sql.SQLException;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.dao.DAO;

public interface Model {
	/**
	 * initialize DAO for current Model
	 */
	void init(DAO dao) throws IncorrectInputException;

	/**
	 * get data from DAO and return them
	 */
	Map<String, Object> getData(Map<String, Object> parameters) throws IncorrectInputException, DataBaseException,
			SQLException;
}

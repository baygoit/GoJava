package kickstarter.model;

import java.sql.SQLException;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.model.dao.DAO;

public interface Model {
	/**
	 * initialize DAO for current Model
	 */
	void init(DAO dao);

	/**
	 * get data from DAO and return them
	 */
	Map<String, Object> getData(Map<String, Object> parameters) throws DataBaseException, SQLException;
}

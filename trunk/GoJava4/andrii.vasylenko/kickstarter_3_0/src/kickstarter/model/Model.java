package kickstarter.model;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.ProcessedException;
import kickstarter.model.dao.DAO;

public interface Model {
	void init(DAO dao, List<Object> parameters);

	List<String> getData() throws ProcessedException, SQLException;

	boolean showOnly();

	List<Object> getParameters(int item, String input) throws ProcessedException, SQLException;
}

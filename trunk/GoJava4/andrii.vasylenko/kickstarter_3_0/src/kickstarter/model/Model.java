package kickstarter.model;

import java.util.Map;

import kickstarter.model.dao.DAO;

public interface Model {
	void init(DAO dao);

	Map<String, Object> getData(Map<String, Object> parameters) throws Exception;
}

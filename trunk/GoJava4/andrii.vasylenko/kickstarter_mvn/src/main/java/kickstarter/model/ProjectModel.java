package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.model.dao.DAO;

public class ProjectModel implements Model {
	private DAO dao;

	@Override
	public void init(DAO dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> getData(Map<String, Object> parameters) throws DataBaseException, SQLException {
		Map<String, Object> result = new HashMap<String, Object>();

		int id = (int) parameters.get("project");
		int categoryId = (int) parameters.get("category");
		result.put("project", dao.getProject(id, categoryId));

		return result;
	}
}

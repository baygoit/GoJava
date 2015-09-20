package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.dao.DAO;

public class ProjectsModel implements Model {
	private DAO dao;

	@Override
	public void init(DAO dao) throws IncorrectInputException {
		if (dao == null) {
			throw new IncorrectInputException("can not init: dao is null");
		}
		this.dao = dao;
	}

	@Override
	public Map<String, Object> getData(Map<String, Object> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		Map<String, Object> result = new HashMap<String, Object>();

		int categoryId = (int) parameters.get("category");
		result.put("projects", dao.getProjects(categoryId));

		return result;
	}
}

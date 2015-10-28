package kickstarter.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.dao.DAO;
import kickstarter.model.engine.Category;

public class CategoriesModel implements Model {
	private DAO dao;

	@Override
	public void init(DAO dao, List<Object> parameters) {
		this.dao = dao;
	}

	@Override
	public List<String> getData() throws SQLException {
		List<String> result = new ArrayList<>();

		for (Category category : dao.getCategories()) {
			result.add(getDescription(category.getId(), category.getName()));
		}

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws NoSuchDataException, SQLException {
		List<Object> result = new ArrayList<>();

		if (item != 0) {
			int id = item;
			Category category = dao.getCategory(id);
			result.add(category);
		}

		return result;
	}

	private String getDescription(int id, String name) {
		int item = id;
		return String.format("%s - %s", item, name);
	}
}

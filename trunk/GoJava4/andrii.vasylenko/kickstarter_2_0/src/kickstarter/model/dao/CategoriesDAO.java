package kickstarter.model.dao;

import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Category;

public interface CategoriesDAO {
	void createTableCategories() throws CannotCreateTableException;

	void addCategory(String name) throws CannotAddDataException;

	List<Category> getCategories() throws CannotGetDataException;

	Category getCategory(int id) throws CannotGetDataException;
}

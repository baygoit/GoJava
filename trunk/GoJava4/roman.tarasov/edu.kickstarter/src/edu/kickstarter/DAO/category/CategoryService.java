package edu.kickstarter.DAO.category;

import java.sql.SQLException;
import java.util.List;
import edu.kickstarter.entity.Category;

public interface CategoryService {

	List<Category> getAll() throws SQLException;
}

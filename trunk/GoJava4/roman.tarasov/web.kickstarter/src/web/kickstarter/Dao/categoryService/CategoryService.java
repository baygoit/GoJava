package web.kickstarter.Dao.categoryService;

import java.sql.SQLException;
import java.util.List;
import web.kickstarter.entity.Category;

public interface CategoryService {

	List<Category> getAll() throws SQLException;
}

package education.kickstarter.spring.ioc.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import education.kickstarter.spring.ioc.model.Category;

public class DefaultCategoryService implements iCategoryService {
	List<Category> categories;

	public DefaultCategoryService() {
		categories = new ArrayList<Category>();

		Category category = new Category();
		category.setID(5);
		category.setName("Technology");
		categories.add(category);

		category = new Category();
		category.setID(4);
		category.setName("Social");
		categories.add(category);

	}

	public List<Category> getAll() throws SQLException {
		return categories;
	}
}

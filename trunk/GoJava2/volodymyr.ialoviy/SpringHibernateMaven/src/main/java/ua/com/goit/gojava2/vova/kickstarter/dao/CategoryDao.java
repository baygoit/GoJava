package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;

public interface CategoryDao {

	void saveCategory(Category category);
	
	List<Category> findAllCategories();
	
	void deleteCategoryById(int id);

	Category findCategoryById(int id);

}

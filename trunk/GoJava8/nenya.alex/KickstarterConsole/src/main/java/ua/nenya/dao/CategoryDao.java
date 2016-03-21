package ua.nenya.dao;

import java.util.List;

import ua.nenya.project.Category;

public interface CategoryDao {
	void initCategories();

	List<Category> getCategories();
}

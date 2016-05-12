package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Category;

public interface CategoryDao {
	List<Category> getCategories();
	boolean isCategoryExist(Long id);
}

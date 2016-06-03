package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Category;

public interface CategoryDao {
	List<Category> getCategories();

	Category getCategoryByCategoryId(Long categoryId);

	Category deleteCategoryByCategoryId(Long categoryId);

	Category saveCategory(Category category);

	boolean isCategoryExistById(Long categoryId);

	boolean isCategoryExistByName(String categoryName);
}

package ua.goit.web.model.dao;

import java.util.ArrayList;
import java.util.List;


public class MemoryCategoryDaoImpl implements CategoryDao {
	List<Category> categories;

	public MemoryCategoryDaoImpl() {
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

	@Override
	public List<Category> getAll() {
		return categories;
	}
}

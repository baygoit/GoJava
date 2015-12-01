package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;

public interface CategoryDao {
	List<Category> getAll();

	int count();
}

package ua.com.goit.gojava7.kikstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Category;

public interface CategoryDao {

	void add(Category category);

	void remove(Category category);

	List<Category> getAll();

	int getSize();

}

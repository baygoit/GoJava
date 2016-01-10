package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public interface CategoryDao {

	List<Category> getAll();

	Category get(Long categoryId);
}

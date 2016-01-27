package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public interface CategoryDao extends Dao {
	List<Category> getCategories();
	
	Category getCategory(Long id);
	
}

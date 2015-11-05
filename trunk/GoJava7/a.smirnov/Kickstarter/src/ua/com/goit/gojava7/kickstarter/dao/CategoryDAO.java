package ua.com.goit.gojava7.kickstarter.dao;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryDAO extends CommonDAO<Category> {
	
	public CategoryDAO() {
		dataSource.add(new Category("Art"));
		dataSource.add(new Category("Music"));
		dataSource.add(new Category("Sports"));
	}
	
	
}


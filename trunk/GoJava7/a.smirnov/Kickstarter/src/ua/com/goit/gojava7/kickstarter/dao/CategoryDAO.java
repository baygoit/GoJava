package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryDAO extends CommonDAO<Category> {

	public CategoryDAO() {

		Category category1 = new Category("Art");
		Category category2 = new Category("Music");
		Category category3 = new Category("Sports");
		Category category4 = new Category("Culture");
		Category category5 = new Category("Movie");

		dataSource.add(category1);
		dataSource.add(category2);
		dataSource.add(category3);
		dataSource.add(category4);
		dataSource.add(category5);
	}

}

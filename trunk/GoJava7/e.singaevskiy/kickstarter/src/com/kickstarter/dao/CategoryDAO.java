package com.kickstarter.dao;

import com.kickstarter.beans.Category;

public class CategoryDAO extends CommonDAO<Category> {
	
	public CategoryDAO() {
		dataSource.add(new Category("Art"));
		dataSource.add(new Category("Music"));
		dataSource.add(new Category("Sports"));
	}

}

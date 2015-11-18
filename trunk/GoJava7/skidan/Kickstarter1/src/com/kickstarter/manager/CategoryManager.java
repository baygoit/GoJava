package com.kickstarter.manager;


import java.util.List;
import java.util.Map;

import com.kickstarter.db.CategoryDB;
import com.kickstarter.model.Category;

public class CategoryManager {

	CategoryDB cdb = new CategoryDB();

	public Map<Integer, Category> getAllCategories() {

		return cdb.categorylist;
	}

	public Category getCategorieByNumber(int categoryNumber) {

		return cdb.categorylist.get(categoryNumber);
	}

}
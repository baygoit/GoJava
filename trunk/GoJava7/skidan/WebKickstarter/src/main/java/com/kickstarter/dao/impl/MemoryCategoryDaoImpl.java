package com.kickstarter.dao.impl;

import java.util.List;

import com.kickstarter.dao.interfaces.CategoryDaoInterface;
import com.kickstarter.memory.storage.CategoryDB;
import com.kickstarter.model.Category;

public class MemoryCategoryDaoImpl implements CategoryDaoInterface {

	CategoryDB cdb = new CategoryDB();

	public List<Category> getAll() {

		return cdb.categorylist;
	}

	public Category getByNumber(int categoryNumber) {
		Category category = new Category();
		List<Category> list = cdb.categorylist;

		for (Category c : list) {
			if (c.getId() == categoryNumber) {
				category = c;
			} else {
				continue;
			}
		}
		return category;
	}

}
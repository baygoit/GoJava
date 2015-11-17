package com.kickstarter.db;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kickstarter.model.Category;

public class CategoryDB {

	public CategoryDB() {

		categorylist = fillList();

	}

	public Map<Integer, Category> categorylist = new HashMap<>();

	private Map<Integer, Category> fillList() {
		Map<Integer, Category> categorylist = new HashMap<>();
		categorylist.put(1, new Category("it", 1));
//		categorylist.put(new Category("it", 1));
		categorylist.put(2, new Category("education", 2));
		categorylist.put(3, new Category("sport", 3));
		return categorylist;

	}

}

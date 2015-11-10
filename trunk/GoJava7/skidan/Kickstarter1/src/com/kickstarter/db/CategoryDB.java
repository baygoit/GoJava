package com.kickstarter.db;

import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Category;

public class CategoryDB {

	public CategoryDB() {

		categorylist = listFiller();

	}

	public List<Category> categorylist = new ArrayList<>();

	private List<Category> listFiller() {
		List<Category> categorylist = new ArrayList<>();
		categorylist.add(new Category("it", 1));
		categorylist.add(new Category("it", 1));
		categorylist.add(new Category("education", 2));
		categorylist.add(new Category("sport", 3));
		return categorylist;

	}

}

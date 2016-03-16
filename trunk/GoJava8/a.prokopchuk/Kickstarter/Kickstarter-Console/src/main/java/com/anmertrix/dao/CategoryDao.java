package com.anmertrix.dao;

import java.util.ArrayList;
import java.util.List;

import com.anmertrix.Category;

public abstract class CategoryDao {

	protected List<Category> categories = new ArrayList<Category>();

	public CategoryDao() {
		
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Category getCategory(int i) {
		return categories.get(i);
	}

	public String getCategoriesMenu() {
		StringBuffer result = new StringBuffer();
		result.append("Please, select category or enter 0 - to exit: \n");
		for (int i = 0; i < categories.size(); i++) {
			result.append(i + 1).append(" - ")
					.append(categories.get(i).getName()).append("    ");
		}

		return result.toString().trim();
	}

	public String getNameSelectedCategory(int n) {
		return categories.get(n).getName();
	}

	public abstract void fillCategory();
	
}

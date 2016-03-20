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
		for (int i = 0; i < categories.size(); i++) {
			result.append(i + 1).append(" - ")
					.append(categories.get(i).getName()).append("    ");
		}
		result.append("0 - EXIT");
		result.append("\n \n");
		result.append("Please, select category...");
		return result.toString().trim();
	}

	public String getNameSelectedCategory(int n) {
		return categories.get(n).getName();
	}

	public abstract void fillCategory();
	
}

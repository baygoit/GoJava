package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.CategoryList;

import java.util.HashMap;
import java.util.Map;

public class CategoryModel extends Model {
	private CategoryList categories;
	
	public CategoryModel(String type, CategoryList categories, String name) {
		super(type, name);
		this.categories = categories;
	}
	
	@Override
	public int size() {
		return categories.size();
	}

	@Override
	public Map<Integer, Map<String, String>> getData() {
		Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String, String>>();
		for (int index = 0; index < size(); index++) {
			Map<String, String> info = new HashMap<String, String>();
			info.put(categories.getCategory(index).getName(), "");
			result.put(index + 1, info);
		}
		return result;
	}
}

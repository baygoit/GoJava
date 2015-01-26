package ua.home.kickstarter;

import java.util.ArrayList;

public class Categories {

	private ArrayList<Category> categories = new ArrayList<Category>();

	public void add(Category category) {
		categories.add(category);
	}

	public ArrayList<Object> getCategories() {
		ArrayList<Object> result = new ArrayList<Object>();
		for (int index = 0; index < categories.size(); index++) {
			result.add(String.valueOf(index + 1) + " - " + categories.get(index).getName());
		}
		return result;
	}

	public Category getName(int index) {
		return categories.get(index - 1);
	}
}

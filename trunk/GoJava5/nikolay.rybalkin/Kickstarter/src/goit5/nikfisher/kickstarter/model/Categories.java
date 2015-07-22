package goit5.nikfisher.kickstarter.model;

import java.util.HashMap;
import java.util.Map;

public class Categories {

	private Map<Integer,Category> categories = new HashMap<>();

	private int index = 0;

	public void add(Category category) {

		categories.put(index++, category);
	}

	public String[] getCategories(){

		String[] result = new String[index];

		for (int i = 0; i < index; i++) {
				result[i] = String.valueOf(i + 1) + ") " + categories.get(i).getName();
		}
		return result;
	}

	public Category get(int index) {
		return  categories.get(index);
	}

	public int size() {
		return index;
	}
}

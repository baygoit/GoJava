package goit5.nikfisher.kickstarter.model;

import java.util.LinkedList;
import java.util.List;

public class InMemoryCategories implements Categories {

	private List<Category> categories = new LinkedList<Category>();

	@Override
	public void add(Category category) {

		categories.add(category);
	}

	@Override
	public String[] getCategories(){

		String[] result = new String[categories.size()];

		for (int i = 0; i < categories.size(); i++) {
				result[i] = String.valueOf(i + 1) + ") " + categories.get(i).getName();
		}
		return result;
	}

	@Override
	public Category get(int index) {
		return  categories.get(index);
	}

	@Override
	public int size() {
		return categories.size();
	}
}

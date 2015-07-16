package goit5.nikfisher.kickstarter.model;

public class Categories {

	private Category[] categories = new Category[10];
	private int index = 0;

	public void add(Category category) {

		categories[index] = category;
		index++;
	}

	public String[] getCategories(){

		String[] result = new String[index];

		for (int i = 0; i < index; i++) {
				result[i] = String.valueOf(i + 1) + ") " + categories[i].getName();
		}
		return result;
	}

	public Category get(int index) {
		return categories[index];
	}

	public int size() {
		return index;
	}
}

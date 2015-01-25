package ua.home.kickstarter;

public class Categories {

	private int numberOfCategories = 10;
	
	private Category[] categories = new Category[numberOfCategories];

	private int count = 0;

	public void add(Category category) {
		categories[count] = category;
		count++;
	}

	public String[] getCategories() {
		String[] result = new String[count];
		for (int index = 0; index < count; index++) {
			result[index] = String.valueOf(index + 1) + " - " + categories[index].getName();
		}
		return result;
	}

	public Category getName(int index) {
		return categories[index - 1];
	}
}

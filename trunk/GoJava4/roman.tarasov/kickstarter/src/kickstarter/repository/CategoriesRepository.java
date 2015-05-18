package kickstarter.repository;

import kickstarter.entities.Category;

public class CategoriesRepository {
	iStorage<Category> categories;
	private String[] optionsStrings;
	private int[] optionsInts;

	public CategoriesRepository() {
		categories = new EntityStorage<Category>();
		Category category = new Category("Technology");
		category.ID = 5;
		categories.add(category);

		category = new Category("Social");
		category.ID = 4;
		categories.add(category);
	}

	public Category getCategoryById(int ID) {
		return categories.getEntity(ID);
	}

	public String getListAllCategories() {
		String result = "";
		int length = categories.length();
		optionsStrings = new String[length];

		for (int index = 0; index < length; index++) {

			result += ("ID:<" + categories.getEntity(index).ID + "> name:<"
					+ categories.getEntity(index).name + ">\n");
			optionsStrings[index] = Integer.toString(categories
					.getEntity(index).ID);
		}
		return result;
	}

	public int[] getIntOptions() {
		int length = categories.length();
		optionsInts = new int[length];
		for (int index = 0; index < length; index++) {
			optionsInts[index] = categories.getEntity(index).ID;
		}
		return optionsInts;
	}

	public String[] getStringOptions() {
		return optionsStrings;
	}
}

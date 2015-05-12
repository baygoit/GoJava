package kickstarter.Repository;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;

public class CategoryList {
	Category[] categories = new Category[10];
	int[] deleted = new int[10];
	int pointer = 0;

	public void addCategory(Category categoryToList) {
		if (pointer >= categories.length) {
			Category[] newCategories = new Category[categories.length + 10];
			System.arraycopy(categories, 0, newCategories, 0, categories.length);
			categories = newCategories;

			int[] newDeleted = new int[categories.length + 10];
			System.arraycopy(deleted, 0, newDeleted, 0, categories.length);
			deleted = newDeleted;

			categories[pointer] = categoryToList;
		}
		categories[pointer] = categoryToList;
		pointer++;
	}

	void deleteCategory(Category categoryToBeDeleted) {
		// TODO
	}

	public int[] printList(UserInterface ui) {
		if (pointer == 0) {
			ui.display("CategoryList null");
			return null;
		}
		int[] options = new int[pointer];
		for (int index = 0; index < pointer; index++) {
			ui.display(categories[index].id + "- " + categories[index].name);
			options[index] = categories[index].id;
		}
		return options;
	}

	public Category get(int pointer) {
		return categories[pointer];
	}
}

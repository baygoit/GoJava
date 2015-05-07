package kickstarter;

public class CategoryList {
	Category[] categories = new Category[10];
	int[] deleted = new int[10];
	int pointer = 0;

	void addCategory(Category categoryToList) {
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

	void printList(UserInterface ui) {
		if (pointer == 0) {
			ui.display("CategoryList null");
			return;
		}
		for (int index = 0; index < pointer; index++) {
			ui.display(index + "- " + categories[index].name);
		}
	}

	public Category get(int pointer) {

		return categories[pointer];
	}

}

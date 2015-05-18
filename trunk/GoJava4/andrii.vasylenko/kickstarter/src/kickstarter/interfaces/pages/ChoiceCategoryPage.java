package kickstarter.interfaces.pages;

import kickstarter.engine.Category;
import kickstarter.storages.CategoriesStorage;

public class ChoiceCategoryPage implements ChoicePage {

	private CategoriesStorage categories;
	private Category chosenItem;

	public ChoiceCategoryPage(CategoriesStorage categories) {
		this.categories = categories;
	}

	@Override
	public String getHead() {
		return "--------------------" + "\r\n" + "Choice Category:";
	}

	@Override
	public String getBody() {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < categories.size(); i++) {
			result.append(getDescription(categories.get(i)));
		}
		result.append(getDescription(Category.EXIT));

		return result.toString();
	}

	@Override
	public void setChosenItem(int itemId) {
		if (itemId == Category.EXIT.getId()) {
			chosenItem = Category.EXIT;
			return;
		}

		chosenItem = categories.getById(itemId);
	}

	@Override
	public Category getChosenItem() {
		return chosenItem;
	}

	private String getDescription(Category category) {
		StringBuilder result = new StringBuilder();
		result.append(category.getId());
		result.append(" - ");
		result.append(category.getName());
		result.append("\r\n");
		return result.toString();
	}

}

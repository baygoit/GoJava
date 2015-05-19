package kickstarter.storages;

import kickstarter.engine.Category;

public class CategoriesStorage implements Storage<Category> {
	private UniversalStorage<Category> categories = new UniversalStorage<Category>();

	@Override
	public Category get(int index) throws IndexOutOfBoundsException {
		return categories.get(index);
	}

	@Override
	public Category getById(int id) {
		return categories.getById(id);
	}

	@Override
	public void add(Category category) {
		categories.add(category);
	}

	@Override
	public int size() {
		return categories.size();
	}

	@Override
	public boolean empty() {
		return categories.empty();
	}
}

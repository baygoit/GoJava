package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryStorage extends AbstractCategoryStorage{
	private static int idGenerator;
	private List<Category> categories;
	
	public CategoryStorage(List<Category> categories) {
		idGenerator = 0;
		this.categories = categories;
	}

	public int getIdOfCategory(int numberOfCategory) {
		return categories.get(numberOfCategory).getIdCategory();
	}

	public Category getCategoryById(int idOfCategory) {
		for (Category category : categories) {
			if (category.getIdCategory() == idOfCategory){
				return category;
			}
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public void add(Category category) {
		category.setIdCategory(++idGenerator);
		categories.add(category);
	}

}

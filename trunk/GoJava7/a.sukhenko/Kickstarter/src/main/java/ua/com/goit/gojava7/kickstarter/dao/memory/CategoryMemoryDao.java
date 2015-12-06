package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.NoSuchElementException;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDao extends MemoryDao<Category> implements CategoryStorage{

	public CategoryMemoryDao(List<Category> data) {
		super(data);
	}

	@Override
	public Category getByNumber(int number) {
		int index = number;
		return get(index);
	}

	@Override
	public Category getCategoryById(int projectCategoryId) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getCategoryId() == projectCategoryId) {
				return data.get(i);
			}
		}
		throw new NoSuchElementException();
	}

}

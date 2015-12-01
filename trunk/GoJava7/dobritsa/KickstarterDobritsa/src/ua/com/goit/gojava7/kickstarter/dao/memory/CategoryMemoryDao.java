package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDao extends MemoryDao<Category> implements CategoryDao {

	public CategoryMemoryDao(List<Category> data) {
		super(data);
	}

	@Override
	public Category getByNumber(int number) {
		int index = number - 1;
		return get(index);
	}
}

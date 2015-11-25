package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDao extends MemoryDao<Category> implements CategoryStorage {

	public CategoryMemoryDao(List<Category> data) {
		super(data);
	}
}

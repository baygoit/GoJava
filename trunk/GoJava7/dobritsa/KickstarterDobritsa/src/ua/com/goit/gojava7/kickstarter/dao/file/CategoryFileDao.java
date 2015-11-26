package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.FileDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryFileDao extends FileDao<Category> implements CategoryStorage {

	public CategoryFileDao(List<Category> data) {
		super(data);
	}

	@Override
	public Category getByNumber(int number) {
		int index = number - 1;
		return get(index);
	}

}

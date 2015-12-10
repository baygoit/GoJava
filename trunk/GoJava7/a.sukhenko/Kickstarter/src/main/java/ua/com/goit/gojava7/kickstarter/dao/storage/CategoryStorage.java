package ua.com.goit.gojava7.kickstarter.dao.storage;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public interface CategoryStorage extends Storage<Category>{

	public Category getByNumber(int number);

	public Category getCategoryById(int projectCategoryId);

}

package ua.com.goit.gojava7.kickstarter.DAO;

import ua.com.goit.gojava7.kickstarter.model.Category;

public abstract class AbstractCategoryStorage implements Storage<Category>{
	
//	public abstract int getIdOfCategory(int numberOfCategory);
	
	public abstract Category getCategoryById(int idOfCategory);
	
}

package ua.com.goit.gojava7.kickstarter.storage;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoriesStorage extends AbstractStorage<Category> {
	
	public CategoriesStorage() {
		dataSource.add(new Category("Art"));
		dataSource.add(new Category("Music"));
		dataSource.add(new Category("Sports"));
	}
	
	
}


package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDaoMemoryImpl implements CategoryDao {
	private List<Category> categories = new ArrayList<>();
	
	@Override
	public List<Category> getCategories() {		
		categories = new ArrayList<>();
				
		categories.add(new Category("Games", 1));
		categories.add(new Category("Design", 2));
		categories.add(new Category("Film & Video", 3));
		categories.add(new Category("Technology", 4));
		return categories;
	}

	@Override
	public int size() {
		return categories.size();
	}

	@Override
	public Category getCategory(int id) {
		Category result = null;
		for (Category category : categories) {
			if(category.getId() == id){
				result = category;
				break;
			}
		}
		return result;
	}

}

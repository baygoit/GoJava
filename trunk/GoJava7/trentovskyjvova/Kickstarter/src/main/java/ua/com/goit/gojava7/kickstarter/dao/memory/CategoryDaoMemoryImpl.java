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
				
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Games");
		categories.add(category1);
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Design");
		categories.add(category2);
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Film & Video");
		categories.add(category3);
		
		Category category4 = new Category();
		category4.setId(4);
		category4.setName("Technology");
		categories.add(category4);
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

	@Override
	public Category getBestCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}

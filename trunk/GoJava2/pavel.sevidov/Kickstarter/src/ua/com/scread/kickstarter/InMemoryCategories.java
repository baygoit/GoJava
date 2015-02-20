package ua.com.scread.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;

public class InMemoryCategories implements Categories {

	private List<Category> categories;

	public InMemoryCategories() {
		categories = new ArrayList<Category>();
	}
		
	@Override
    public void add(Category category) {
		categories.add(category);	
	}
	
	@Override
    public int size() {
	    return categories.size();
	}

	@Override
    public List<Category> getCategories() {
		return categories;
	}

	@Override
    public Category get(int index) {
		return categories.get(index);
	}

}

package kickstarter.repos;

import java.util.ArrayList;

import kickstarter.model.Category;

public class CategoriesRepo {

    private ArrayList<Category> categories = new ArrayList<>();
    
    public CategoriesRepo() {
	add(new Category("TECHNOLOGY", 1));
	add(new Category("DESIGN", 2));
    }
    
    public void add(Category category) {
	categories.add(category);
    }
    
    public ArrayList<Category> getAll() {
	return categories;
    }
    
    public Category getCategory(String name) {
	for (Category category : categories) {
	    if (category.getName().equals(name)) {
		return category;
	    }
	}
	System.out.println("CategoryRepo getCategory() RETURNED NULL");
	return null;
    }
}

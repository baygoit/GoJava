package ua.com.goit.gojava7.kickstarter.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Category;

/**
 * @author Devian
 * @category Storage
 */
public class CategoryStorage {
	private final Map<Integer,Category> categories = new HashMap<Integer,Category>();

	public Map<Integer,Category> getCategories(){
		return Collections.unmodifiableMap(categories);
	}
	
	public void addCategory(Category cat){
		categories.put(cat.getCategoryId(), cat);
	}
	
	
}

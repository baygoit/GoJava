package ua.com.goit.gojava7.kickstarter.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
	
	public Category getCategoryById(int id){
		if(categories.containsKey(id))
		return categories.get(id);
		else{
			throw new NoSuchElementException();
		}
	}

	public int size() {
		return categories.size();
	}
	
}

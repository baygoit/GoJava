package main.ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import main.ua.com.goit.gojava7.kickstarter.beans.Category;

public interface CategoryDao {
	
	public void add(Category category);

	public void remove(Category category);
	
	public List<Category> getAll();
	
	public int getSize();
	
	public Category getCategoryById(int id);
}

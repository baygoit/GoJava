package home.GoJava2.Engine;

import home.GoJava2.Content.Category;
import home.GoJava2.DataBase.CategoryStorage;

import java.util.List;

public interface CategoryManagement {
	
	public List<Category> getCategorys();
	public CategoryStorage getCategoryStorage();
	public Category getCategory(int i);
}
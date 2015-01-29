package ua.com.goit.gojava.andriidnikitin;

import java.util.List;

public interface GoodStorage {
	
	public List<Category> getCategoryList();
	
	public List<Good> getGoodList(Category category) ;
	
	public boolean categoryExists(Category category);
	
	public boolean goodExists(Good good);
	
	public void addCategory (Category category) ;
	
	public void addGood (Good good) ;
	
	public void updateCategory(Category oldCategory, Category newCategory) ;
	
	public void updateGood(Good oldGood, Good newGood) ;
	
}	

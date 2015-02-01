package ua.com.goit.gojava.andriidnikitin;

import java.util.List;

public interface Storage {
	
	public List<Category> getCategoryList();
	
	public List<Good> getGoodList(Category category) ;
	
	public void save (Category category) ;
	
	public void save (Good good) ;
	
}	

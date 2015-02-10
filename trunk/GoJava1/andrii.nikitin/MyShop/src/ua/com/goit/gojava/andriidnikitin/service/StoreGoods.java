package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.Category;
import ua.com.goit.gojava.andriidnikitin.Good;

public interface StoreGoods {

	public List<Category> getCategoryList();
	
	public List<Good> getGoodList(Category category) ;
	
	public void save (Category category) ;
	
	public void save (Good good) ;
	
}	

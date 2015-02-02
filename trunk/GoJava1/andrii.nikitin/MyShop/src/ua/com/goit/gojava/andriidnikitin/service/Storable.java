package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;

public interface Storable {

	public List<Category> getCategoryList();
	
	public List<Good> getGoodList(Category category) ;
	
}	

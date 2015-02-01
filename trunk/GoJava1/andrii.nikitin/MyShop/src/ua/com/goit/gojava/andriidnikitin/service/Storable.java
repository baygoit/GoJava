package ua.com.goit.gojava.andriidnikitin.service;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;

public interface Storable {
	
	public void save (Category category) ;
	
	public void save (Good good) ;
	
}	

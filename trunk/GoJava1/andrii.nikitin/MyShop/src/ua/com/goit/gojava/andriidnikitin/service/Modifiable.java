package ua.com.goit.gojava.andriidnikitin.service;

import ua.com.goit.gojava.andriidnikitin.Category;
import ua.com.goit.gojava.andriidnikitin.Good;

public interface Modifiable {
	
	public void save (Category category) ;
	
	public void save (Good good) ;	

}

package ua.com.goit.gojava.andriidnikitin;

import java.util.List;

public interface GoodStorage {
	
	public List<Category> getCategoryList();
	
	public List<Good> getGoodList();
	
	public List<Good> getGoodList(Category category) ;

}

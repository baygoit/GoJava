package ua.com.goit.group1.admytruk.blabla.complex;

import java.util.List;

public interface DataManager {

	List<Category> getCategoryList();
	
	List<Product> getProductList(Category category);
		
}

package ua.com.goit.group1.admytruk.blabla;

import java.util.List;

public interface BlablaService {

	List<Category> getCategoryList();
	
	List<Product> getProductList(int categoryId);
	
}

package ua.com.goit.group1.admytruk.blabla;

import java.util.List;
import java.util.Map;

public class BlaBlaServiceImpl implements BlablaService {

	private static final List<Category> CATEGORY_DATA = DataGenerator.createCategories();
	
	private static final Map<Integer, List<Product>> PRODUCT_DATA = DataGenerator.createProducts(CATEGORY_DATA);	

	@Override
	public List<Category> getCategoryList() {		
		return CATEGORY_DATA;
	}

	@Override
	public List<Product> getProductList(int categoryId) {
		return PRODUCT_DATA.get(categoryId);
	}
	
}

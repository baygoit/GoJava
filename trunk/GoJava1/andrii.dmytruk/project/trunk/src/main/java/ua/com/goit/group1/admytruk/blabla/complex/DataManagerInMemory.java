package ua.com.goit.group1.admytruk.blabla.complex;

import java.util.ArrayList;
import java.util.List;

public class DataManagerInMemory extends DataManagerAbstract {

	private final List<Category> CATEGORY_LIST = new ArrayList<Category>();
	
	private final List<Product> PRODUCT_LIST = new ArrayList<Product>();
	
	public DataManagerInMemory() {
		super();
	}
	
	protected void init() {
		CATEGORY_LIST.add(new Category(1, "Category 1"));
		CATEGORY_LIST.add(new Category(2, "Category 2"));
		CATEGORY_LIST.add(new Category(3, "Category 3"));		
		PRODUCT_LIST.add(new Product(1, "Product - 001", CATEGORY_LIST.get(0)));
		PRODUCT_LIST.add(new Product(2, "Product - 002", CATEGORY_LIST.get(0)));
		PRODUCT_LIST.add(new Product(3, "Product - 003", CATEGORY_LIST.get(0)));
		PRODUCT_LIST.add(new Product(4, "Product - 004", CATEGORY_LIST.get(1)));
		PRODUCT_LIST.add(new Product(5, "Product - 005", CATEGORY_LIST.get(2)));
		PRODUCT_LIST.add(new Product(6, "Product - 006", CATEGORY_LIST.get(2)));	
		
	}
	
	@Override
	public List<Category> getCategoryList() {		
		return CATEGORY_LIST;
	}
	
	@Override
	protected List<Product> getProductList() {
		return PRODUCT_LIST;
	}

}

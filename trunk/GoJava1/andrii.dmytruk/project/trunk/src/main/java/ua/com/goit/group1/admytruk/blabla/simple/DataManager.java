package ua.com.goit.group1.admytruk.blabla.simple;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

	private final List<Category> categoryList = new ArrayList<Category>();
	
	private final List<Product> productList = new ArrayList<Product>();
	
	public DataManager() {
		init();
	}
	
	protected void init() {
		categoryList.add(new Category(1, "Category 1"));
		categoryList.add(new Category(2, "Category 2"));
		categoryList.add(new Category(3, "Category 3"));		
		productList.add(new Product(1, "Product - 001", categoryList.get(0)));
		productList.add(new Product(2, "Product - 002", categoryList.get(0)));
		productList.add(new Product(3, "Product - 003", categoryList.get(0)));
		productList.add(new Product(4, "Product - 004", categoryList.get(1)));
		productList.add(new Product(5, "Product - 005", categoryList.get(2)));
		productList.add(new Product(6, "Product - 006", categoryList.get(2)));	
		
	}
	

	public List<Category> getCategoryList() {		
		return categoryList;
	}
	
	public List<Product> getProductList(Category category) {
		final List<Product> result = new ArrayList<Product>();
		if (category != null) {
			for (Product product : this.productList) {
				if (category.equals(product.getCategory())) {
					result.add(product);
				}
			}
		}
		return result;
	}

}

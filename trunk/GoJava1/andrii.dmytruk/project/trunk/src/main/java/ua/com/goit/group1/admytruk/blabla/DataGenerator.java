package ua.com.goit.group1.admytruk.blabla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.StringUtils;

public class DataGenerator {

	private static final Random RANDOM = new Random();
	
	private static AtomicInteger CATEGORY_SEQUENCE = new AtomicInteger();
	
	private static AtomicInteger PRODUCT_SEQUENCE = new AtomicInteger();
	
	protected static List<Category> createCategories() {
		final List<Category> result = new ArrayList<Category>();
		for (int i = 0; i < RANDOM.nextInt(100); i++) {
			final int categoryId = CATEGORY_SEQUENCE.getAndIncrement();
			final String categoryName = 
							"Category-" 
							+ StringUtils.leftPad(Integer.toString(categoryId), 4, "0");
			result.add(new Category(categoryId, categoryName));
		}
		return result;
	}
	
	
	protected static Map<Integer, List<Product>> createProducts(List<Category> categoryList) {
		final Map<Integer, List<Product>> result = new HashMap<Integer, List<Product>>();
		for (Category category : categoryList) {
			final List<Product> productList = new ArrayList<Product>();
						
			for (int i = 0; i < RANDOM.nextInt(); i++) {
				final int productId = PRODUCT_SEQUENCE.getAndIncrement();
				final String productName = 
								category.getName() 
								+ "-Category-" 
										+ StringUtils.leftPad(Integer.toString(productId), 4, "0");		
				productList.add(new Product(productId, productName));
			}
			result.put(category.getId(), productList);			
		}
		return result;
	}
	
}

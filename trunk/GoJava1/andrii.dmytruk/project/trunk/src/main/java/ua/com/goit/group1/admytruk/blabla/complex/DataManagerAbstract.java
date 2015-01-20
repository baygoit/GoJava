package ua.com.goit.group1.admytruk.blabla.complex;

import java.util.ArrayList;
import java.util.List;

public abstract class DataManagerAbstract implements DataManager {

	
	protected abstract List<Product> getProductList();
	
	protected abstract void init();

	@Override
	public List<Product> getProductList(Category category) {
		final List<Product> result = new ArrayList<Product>();
		if (category != null) {
			for (Product product : getProductList()) {
				if (category.equals(product.getCategory())) {
					result.add(product);
				}
			}
		}
		return result;
	}
	
}

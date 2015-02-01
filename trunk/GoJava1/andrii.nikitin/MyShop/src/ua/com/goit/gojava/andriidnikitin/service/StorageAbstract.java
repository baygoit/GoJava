package ua.com.goit.gojava.andriidnikitin.service;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;

public abstract class StorageAbstract implements Storable, Navigable {
	
	protected abstract List<Good> getGoodList();
	
	@Override
	public List<Good> getGoodList(Category category) {
		final List<Good> result = new ArrayList<Good>();
		if (category == null || category.getName() == null) { 
				return result;   
		}  
		final List<Good> goods = getGoodList();
		for (Good good : goods){
			if (category.getId().equals(good.getCategory().getId())) { 
					result.add(good);
			}
		}
		return result;
	}

}

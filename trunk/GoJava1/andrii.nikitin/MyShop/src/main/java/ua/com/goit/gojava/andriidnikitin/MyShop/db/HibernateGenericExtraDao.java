package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;



public abstract class HibernateGenericExtraDao <T>  extends HibernateGenericDao<T> 
													implements GenericExtraDao<T> {

	public List<T> getFilteringByName(String query) throws MyShopDaoException {
		List<T> all = getAll();
		List<T> result = new ArrayList<T>();
		for (int i = 0; i < all.size(); i++) {
	          T good = all.get(i);
	          if(getName(good).toLowerCase().startsWith(query)) {
	        	  result.add(good);
	          }
		}      
		return result;
	}

	@Override
	public List<T> getByName(String name) throws MyShopDaoException {
		List<T> all = getAll();
		List<T> result = new ArrayList<T>();
		for (int i = 0; i < all.size(); i++) {
	          T good = all.get(i);
	          if(getName(good).equals(name)) {
	        	  result.add(good);
	          }
		}      
		return result;
	}
	
	public abstract Class<T> getType();
	
	protected abstract String getName(T object);
}	
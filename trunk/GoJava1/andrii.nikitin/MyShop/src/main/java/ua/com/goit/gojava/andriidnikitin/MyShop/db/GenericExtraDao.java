package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;

public interface GenericExtraDao<T> extends GenericDao<T> {
	public List<T> getFilteringByName(String query) throws MyShopDaoException;
	public List<T> getByName(String name) throws MyShopDaoException;
}

package ua.com.goit.gojava.andriidnikitin.dao;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDaoException;

public interface GenericDao<T> {
	public Integer create(T unit) throws MyShopDaoException;   
    public T read(Integer id) throws MyShopDaoException;   
    public void update(T unit) throws MyShopDaoException;         
    public void delete(T unit) throws MyShopDaoException;
    public List<T> getAll() throws MyShopDaoException;
}

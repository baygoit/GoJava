package ua.com.goit.gojava.andriidnikitin.dao;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;

public interface GenericDAO<T> {
	public Integer create(T unit) throws MyShopDAOException;   
    public T read(Integer id) throws MyShopDAOException;   
    public void update(T unit) throws MyShopDAOException;         
    public void delete(T unit) throws MyShopDAOException;
    public List<T> getAll() throws MyShopDAOException;
}

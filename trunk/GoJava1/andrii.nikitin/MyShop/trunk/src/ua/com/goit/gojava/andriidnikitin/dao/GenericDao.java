package ua.com.goit.gojava.andriidnikitin.dao;

import java.util.List;


public interface GenericDao <T>{

	    public T create(T parameter) throws MyShopDAOException;

	    public T read(int key) throws MyShopDAOException;

	    public void update(T record) throws MyShopDAOException;

	    public void delete(T record) throws MyShopDAOException;

	    public List<T> getAll() throws MyShopDAOException;

}

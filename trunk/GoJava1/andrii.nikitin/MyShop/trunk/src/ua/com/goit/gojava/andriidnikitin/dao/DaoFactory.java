package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodType;

public interface DaoFactory {
	public Connection getConnection() throws MyShopDaoException;
    public GenericDao<GoodType> getGoodTypeDAO(Connection connection);
    public GenericDao<Good> getGoodDAO(Connection connection);
}

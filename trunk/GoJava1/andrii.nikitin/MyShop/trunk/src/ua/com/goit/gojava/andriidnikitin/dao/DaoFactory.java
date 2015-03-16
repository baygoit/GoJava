package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodType;

public interface DaoFactory {
	public Connection getConnection() throws MyShopDaoException;
    public GenericDao<GoodType> getGoodTypeDao(Connection connection);
    public GenericDao<Good> getGoodDao(Connection connection);
    public GenericDao<GoodIncoming> getGoodIncomingDao(Connection connection);
}

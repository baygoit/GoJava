package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public interface DAOFactory {
	public Connection getConnection() throws MyShopDAOException;
    public GenericDAO<GoodType> getGoodTypeDAO(Connection connection);
    public GenericDAO<Good> getGoodDAO(Connection connection);
}

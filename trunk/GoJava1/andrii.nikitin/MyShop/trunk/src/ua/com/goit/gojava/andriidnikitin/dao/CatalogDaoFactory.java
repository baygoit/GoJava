package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public interface CatalogDaoFactory {
    public Connection getConnection() throws SQLException;
    public GenericDao getGoodDao(Connection connection);
    public GenericDao getGoodTypeDao(Connection connection);
}


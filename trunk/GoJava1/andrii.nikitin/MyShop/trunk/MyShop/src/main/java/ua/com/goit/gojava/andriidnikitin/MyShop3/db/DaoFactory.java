package ua.com.goit.gojava.andriidnikitin.MyShop3.db;

import java.sql.Connection;

import ua.com.goit.gojava.andriidnikitin.MyShop3.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model.GoodType;


public interface DaoFactory {
	public Connection getConnection() throws MyShopDaoException;
    public GenericDao<GoodType> getGoodTypeDao(Connection connection);
    public GenericDao<Good> getGoodDao(Connection connection);
    public GenericDao<GoodIncoming> getGoodIncomingDao(Connection connection);
}

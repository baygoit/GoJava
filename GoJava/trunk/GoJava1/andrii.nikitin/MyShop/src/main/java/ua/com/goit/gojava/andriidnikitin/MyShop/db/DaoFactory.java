package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;


public interface DaoFactory {
    public GenericDao<GoodType> getGoodTypeDao() throws MyShopDaoException;
    public GenericDao<Good> getGoodDao() throws MyShopDaoException;
    public GenericDao<GoodRecord> getGoodRecordDao() throws MyShopDaoException;
	public GenericExtraDao<Good> getGoodDaoExtended() throws MyShopDaoException;
	public GenericExtraDao<GoodType> getGoodTypeExtraDao() throws MyShopDaoException;
}

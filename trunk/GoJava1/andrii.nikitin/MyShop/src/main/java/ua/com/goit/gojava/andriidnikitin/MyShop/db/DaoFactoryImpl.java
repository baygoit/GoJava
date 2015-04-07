package ua.com.goit.gojava.andriidnikitin.MyShop.db;


import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;

public class DaoFactoryImpl implements DaoFactory {	
	
	private GenericDao<Good> goodDao;
	
	public GenericDao<Good> getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GenericDao<Good> goodDao) {
		this.goodDao = goodDao;
	}

	public GenericDao<GoodType> getGoodTypeDao() {
		return goodTypeDao;
	}

	public void setGoodTypeDao(GenericDao<GoodType> goodTypeDao) {
		this.goodTypeDao = goodTypeDao;
	}

	public GenericDao<GoodRecord> getGoodIncomingDao() {
		return goodIncomingDao;
	}

	public void setGoodIncomingDao(GenericDao<GoodRecord> goodIncomingDao) {
		this.goodIncomingDao = goodIncomingDao;
	}

	private GenericDao<GoodType> goodTypeDao;
	
	private GenericDao<GoodRecord> goodIncomingDao;
	
	
	

}

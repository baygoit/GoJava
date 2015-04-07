package ua.com.goit.gojava.andriidnikitin.MyShop.db;


import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;

public class DaoFactoryImpl implements DaoFactory {	
	
	private GenericDao<Good> goodDao;

	private GenericDao<GoodType> goodTypeDao;
	
	private GenericDao<GoodRecord> goodRecordDao;
	
		
	public GenericDao<GoodRecord> getGoodRecordDao() {
		return goodRecordDao;
	}

	public void setGoodRecordDao(GenericDao<GoodRecord> goodRecordDao) {
		this.goodRecordDao = goodRecordDao;
	}

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

}

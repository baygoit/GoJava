package ua.com.goit.gojava.andriidnikitin.MyShop.db;


import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.CustomerBasket;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;

public class DaoFactoryImpl implements DaoFactory {	
	
	private GenericExtraDao<Good> goodDao;

	private GenericExtraDao<GoodType> goodTypeDao;
	
	private GenericDao<GoodRecord> goodRecordDao;

	private GenericExtraDao<CustomerBasket> basketDao;
	
	public GenericExtraDao<CustomerBasket> getBasketDao() {
		return basketDao;
	}

	public void setBasketDao(GenericExtraDao<CustomerBasket> basketDao) {
		this.basketDao = basketDao;
	}	
		
	public GenericDao<GoodRecord> getGoodRecordDao() {
		return goodRecordDao;
	}

	public void setGoodRecordDao(GenericDao<GoodRecord> goodRecordDao) {
		this.goodRecordDao = goodRecordDao;
	}

	public GenericExtraDao<Good> getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GenericExtraDao<Good> goodDao) {
		this.goodDao = goodDao;
	}

	public GenericExtraDao<GoodType> getGoodTypeDao() {
		return goodTypeDao;
	}

	public void setGoodTypeDao(GenericExtraDao<GoodType> goodTypeDao) {
		this.goodTypeDao = goodTypeDao;
	}

	@Override
	public GenericExtraDao<Good> getGoodDaoExtended(){
		return goodDao;
	}

	@Override
	public GenericExtraDao<GoodType> getGoodTypeExtraDao(){
		return goodTypeDao;
	}	

}

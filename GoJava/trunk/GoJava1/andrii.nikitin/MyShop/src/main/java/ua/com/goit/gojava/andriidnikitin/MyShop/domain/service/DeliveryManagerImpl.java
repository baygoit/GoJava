package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.DaoFactory;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.GenericDao;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

@Service
public class DeliveryManagerImpl implements DeliveryManager{	
	
	private DaoFactory daoFactory;

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	private Logger log;
	
	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public GoodRecord deliverGood(Good good, Integer quantity, Integer price) throws MyShopException {
		try{
			GenericDao<GoodRecord> dao = daoFactory.getGoodRecordDao();
			GoodRecord record = new GoodRecord();		
			record.setGood(good);
	        record.setPrice(price);
	        record.setAmount(quantity);
	        Integer id = dao.create(record);
	        log.info("created new record with ID " + id.toString());
	        record.setId(id);
	        return record;
		} catch (MyShopDaoException exception){
			log.error(exception);
			throw new MyShopException(exception);
		}
	}

	
	
	
}

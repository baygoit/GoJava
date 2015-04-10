package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.andriidnikitin.MyShop.db.DaoFactory;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.GenericDao;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

@Service
public class WarehouseManagerImpl implements WarehouseManager{	
	
	private DaoFactory daoFactory;

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	private Logger log;
	
	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public List<GoodRecord> getRecordsOfGood(Good good) throws MyShopException {
		try {
			GenericDao<GoodRecord> dao = daoFactory.getGoodRecordDao();
			List<GoodRecord> list = dao.getAll();
			List<GoodRecord> result = new ArrayList<GoodRecord>();
			for (GoodRecord record: list){
				if (record.getGood().equals(good)){
					result.add(record);
				}
				return result;
			}
		} catch (MyShopDaoException e) {
			log.error("error occured while getting instance of GoodRecordDao!");
			throw new MyShopException(e);
		}
		return null;
	}

	@Override
	public List<GoodRecord> getAllRecords() throws MyShopException{
		try {
			GenericDao<GoodRecord> dao = daoFactory.getGoodRecordDao();
			return dao.getAll();
		} catch (MyShopDaoException e) {
			log.error("error occured while getting instance of GoodRecordDao!");
			throw new MyShopException(e);
		}
	}

	@Override
	public GoodRecord getRecord(Integer id) throws MyShopException {
		try {
			GenericDao<GoodRecord> dao = daoFactory.getGoodRecordDao();
			return dao.read(id);
		} catch (MyShopDaoException e) {
			log.error("error occured while getting instance of GoodRecordDao!");
			throw new MyShopException(e);
		}
	}

	@Override
	public void deleteRecord(Integer id)  throws MyShopException {
		try {
			GenericDao<GoodRecord> dao = daoFactory.getGoodRecordDao();
			dao.delete(dao.read(id));
		} catch (MyShopDaoException e) {
			log.error("error occured while getting instance of GoodRecordDao!");
			throw new MyShopException(e);
		}
	}
	
	
}

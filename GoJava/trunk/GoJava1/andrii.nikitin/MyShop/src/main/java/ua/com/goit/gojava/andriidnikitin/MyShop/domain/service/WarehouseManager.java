package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;


public interface WarehouseManager {
	
	public List<GoodRecord> getRecordsOfGood(Good good) throws MyShopException;
	
	public List<GoodRecord> getAllRecords() throws MyShopException;
	
	public GoodRecord getRecord(Integer id) throws MyShopException;
	
	public void deleteRecord(Integer id) throws MyShopException;
	
}

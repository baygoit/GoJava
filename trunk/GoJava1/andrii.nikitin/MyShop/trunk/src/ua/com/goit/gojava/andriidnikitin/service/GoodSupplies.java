package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public interface GoodSupplies {
	
	public Boolean deliverGood(List<GoodIncoming> income) throws ShopException;
	
	public Integer getGoodAmount(Good good) throws ShopException;

}

package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodIncoming;

public interface GoodSupplies {
	
	public Boolean deliverGood(List<GoodIncoming> income);
	
	public Integer getGoodAmount(Good good);

}

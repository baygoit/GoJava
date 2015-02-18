package ua.com.goit.gojava.andriidnikitin.service;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class GoodSuppliesImpl implements GoodSupplies {
	
	protected List<GoodIncoming> storage;	

	final private static GoodSuppliesImpl instance;
	
	static {
		instance = new GoodSuppliesImpl();
	}	
	
	public static GoodSuppliesImpl getInstance() {
		return instance;
	}
	
	private GoodSuppliesImpl() {
		storage = new ArrayList<GoodIncoming>(); 
	}

	@Override
	public Boolean deliverGood(List<GoodIncoming> income) throws ShopException {
		if (income == null) {
			throw new ShopException("incorrect data!");
		}
		for (GoodIncoming item: income){
			storage.add(item);
		}
		return true;
	}

	@Override
	public Integer getGoodAmount(Good good) throws ShopException {
		if (storage == null) {
			throw new ShopException("Storage not found");
		}
		else {
			return 1;
		}
	}

}

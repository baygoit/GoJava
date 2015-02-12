package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public interface GoodCatalog {
	
	public List<GoodType> getGoodTypes(GoodType parent);
	
	public List<Good> getGoodsInType (Good good);
	
	public List<GoodType> getGoodTypesFromRoot();
	
}	

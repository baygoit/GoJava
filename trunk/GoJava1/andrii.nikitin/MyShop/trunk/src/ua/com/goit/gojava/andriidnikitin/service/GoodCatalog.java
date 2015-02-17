package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public interface GoodCatalog {
	
	public List<GoodType> getGoodTypes(GoodType parent);
	
	public List<GoodType> getGoodTypesFromRoot();

	public List<Good> getGoodsInType(GoodType type);
	
}	

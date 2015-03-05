package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public interface GoodCatalog {
	
	public List<GoodType> getGoodTypes(GoodType parent) throws ShopException;
	
	public List<GoodType> getGoodTypesFromRoot() throws ShopException;

	public List<Good> getGoodsInType(GoodType type);
	
	public List<GoodType> getChildren(GoodType parent) throws ShopException;
	
	public Boolean hasChildren(GoodType parent) throws ShopException;
	
	public Boolean isRoot(GoodType type) throws ShopException;
	
	public List<Good> getAllGoods();//TODO - replace

	public boolean addGood(Good element);

	List<GoodType> getLeaves() throws ShopException;

	GoodType getGoodTypeByName(String name) throws ShopException;
}	

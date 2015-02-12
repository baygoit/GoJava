package ua.com.goit.gojava.andriidnikitin.service;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.model.DAO.GoodDAO;
import ua.com.goit.gojava.andriidnikitin.model.DAO.GoodTypeDAO;

public class GoodCatalogImpl implements GoodCatalog{
	
	private GoodDAO goods;
	
	private GoodTypeDAO types;
	
	public GoodCatalogImpl() {
		goods = new GoodDAO();
		types = new GoodTypeDAO();
	}
	

	@Override
	public List<GoodType> getGoodTypes(GoodType parent) {

		List<GoodType> list = types.getAll();
		List<GoodType> result = new ArrayList<GoodType>();
		for (GoodType type: list){
			if (type.equals(parent)) {
				result.add(type);
			}
		}
		return result;
		
	}

	@Override
	public List<Good> getGoodsInType(Good good) {
		List<Good> result = new ArrayList<Good>();
		for (Good good1: goods.getAll()) {
			if (good.getType().equals(good1.getType())) {
				result.add(good1);
				}
		}
		return result ;
	}

	@Override
	public List<GoodType> getGoodTypesFromRoot() {
		
		return getGoodTypes(GoodType.ROOT);
	}


}

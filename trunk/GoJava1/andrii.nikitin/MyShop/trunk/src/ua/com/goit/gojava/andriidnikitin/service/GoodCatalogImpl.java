package ua.com.goit.gojava.andriidnikitin.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.util.DataBuilderPlain;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class GoodCatalogImpl implements GoodCatalog{
	
	private GoodDAO goods;
	
	private GoodTypeDAO types;
	
	private static final GoodCatalogImpl instance;
	
	public static GoodCatalogImpl getInstance() {
		return instance;
	}
	
	static {
		instance = new GoodCatalogImpl();
	}
	
	private GoodCatalogImpl() {
		goods = new GoodDAO();
		types = new GoodTypeDAO();
	}	

	@Override
	public List<GoodType> getGoodTypes(GoodType parent) {

		List<GoodType> list = types.getAll();
		List<GoodType> result = new ArrayList<GoodType>();
		if (parent == null) {
			for (GoodType type: list){
				if (type.getParent() == null) {
						result.add(type);
				}
			}	
		}	
		else {	
			for (GoodType type: list){
				if (type.getParent().getId().equals(parent.getId())) {
					result.add(type);
				}
			}
		}
		return result;
		
	}

	@Override
	public List<Good> getGoodsInType(GoodType type) {
		List<Good> result = new ArrayList<Good>();
		for (Good good1: goods.getAll()) {
			if (type.getId().equals(good1.getType().getId())) {
				result.add(good1);
				}
		}
		return result ;
	}

	@Override
	public List<GoodType> getGoodTypesFromRoot() {		
		return getGoodTypes(null);
	}
	
	public void initFromFile(String path) throws ShopException {
		if (path == null) {
			throw new ShopException("Illegal filepath.");
		}
		List<ArrayList<String>> contents;
		try {
			contents = new DataBuilderPlain(path).getCSVElementsFromFile();
		} catch (FileNotFoundException e) {
			throw new ShopException("Source file not found.");
		}
		for (ArrayList<String> row: contents) {
			goods.getAll().add(readGood(row));
		}
	}
	
	private Good readGood(List<String> CSVStrings) {
		Good good = new Good();
		good.setId(new Integer(CSVStrings.get(0)));
		good.setName(CSVStrings.get(1));
		GoodType type = new GoodType();
		type.setId(new Integer(CSVStrings.get(2)));
		type.setName(CSVStrings.get(3));
		good.setType(type);
		return good;
	}
	
	/*private String[] writeGood(Good good){
		String[] result = new String[5];
		result[0] = good.getId().toString();
		result[1] = good.getName();
		result[2] = good.getType().getId().toString();
		result[3] = good.getType().getName();
		result[4] = good.getPrice().toPlainString();
		return result;
	}*/
	
}

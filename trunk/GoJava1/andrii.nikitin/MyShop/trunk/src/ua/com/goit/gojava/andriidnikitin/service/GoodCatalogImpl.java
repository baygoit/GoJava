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
			if (typesAreEqual(type, good1.getType())) {
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

	@Override
	public List<GoodType> getChildren(GoodType parent) {
		List<GoodType> result = new ArrayList<GoodType>();
		for (GoodType type: types.getAll()){
			if (typesAreEqual(parent, type.getParent())){
				result.add(type);
			}
		}
		return result;
	}

	@Override
	public Boolean hasChildren(GoodType parent) {
		if (parent == null) {
			return (!types.getAll().isEmpty());
		}
		List<GoodType> typeList = types.getAll();
		for (GoodType type: typeList) {
			if (typesAreEqual(parent, type.getParent())) {
				return true;
			}
		}
			return false;
	}

	/**
	 * Returns true if parameter exists in catalog and his parent is null.  
	 * 	 */
	@Override
	public Boolean isRoot(GoodType type) {
		List<GoodType> listOfTypes = types.getAll();
		if (listOfTypes.contains(type)){
			return (type.getParent() == null);
		}
		return false;
		
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
	
	private Boolean typesAreEqual(GoodType arg0, GoodType arg1) {
		try{
		return arg0.getId().equals(arg1.getId());
		} catch (NullPointerException ex){
			return (arg0==arg1);
		}
	}
	
	private GoodType getTypeByName(String name){
		GoodType type = null;
		for (GoodType tempType: types.getAll() ) {
			String tempName = tempType.getName();
			if (tempName.equals(name)) {
				return tempType;
			}
		}
		return type;
		
	}

	@Override
	public List<Good> getAllGoods() {
		return goods.getAll();
	}

	@Override
	public boolean addGood(Good element) {
		return goods.create(element);
		
	}	
	
	public Good factoryGood(String name, String typeName) {
		Good result = new Good();
		result.setName(name);
		GoodType type = getTypeByName(typeName);
		result.setType(type);
		return result ;
		
	}
	
	public List<GoodType> getLeaves(){
		List<GoodType> result = new ArrayList<GoodType>();
		List<GoodType> typeList = types.getAll();
		for (GoodType type: typeList){
			if (!hasChildren(type)) {
				result.add(type);
			}
		}
		return result ; 
	}
}

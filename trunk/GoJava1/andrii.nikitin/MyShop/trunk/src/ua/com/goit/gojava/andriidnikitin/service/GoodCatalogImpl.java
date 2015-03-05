package ua.com.goit.gojava.andriidnikitin.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.dao.GoodDao;
import ua.com.goit.gojava.andriidnikitin.dao.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlGoodTypeDao;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.util.DataBuilderPlain;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class GoodCatalogImpl implements GoodCatalog{
	
	private GoodDao goods;
	
	private PostgresqlGoodTypeDao types;
	
	private static final GoodCatalogImpl instance;
	
	public static GoodCatalogImpl getInstance() {
		return instance;
	}
	
	static {
		instance = new GoodCatalogImpl();
	}
	
	private GoodCatalogImpl() {
		goods = new GoodDao();
		types = PostgresqlGoodTypeDao.getInstance();
	}	

	@Override
	public List<GoodType> getGoodTypes(GoodType parent) throws ShopException {
		List<GoodType> list = getAllTypes();
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
				GoodType tempParent = type.getParent();
				if (tempParent.getId().equals(parent.getId())) {
					result.add(type);
				}
			}
		}
		return result;
		
	}

	public List<GoodType> getAllTypes() throws ShopException {
		List<GoodType> list = null;
		try {
			list = types.getAll();
		} catch (MyShopDAOException e) {
			throw new ShopException("Cannot access datasource. ");
		}
		return list;
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
	public List<GoodType> getGoodTypesFromRoot() throws ShopException {		
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
	public List<GoodType> getChildren(GoodType parent) throws ShopException {
		List<GoodType> result = new ArrayList<GoodType>();
		for (GoodType type: getAllTypes()){
			if (typesAreEqual(parent, type.getParent())){
				result.add(type);
			}
		}
		return result;
	}

	@Override
	public Boolean hasChildren(GoodType parent) throws ShopException {
		List<GoodType> typeList = getAllTypes();
		if (parent == null) {
			return (!typeList.isEmpty());
		}	
		for (GoodType type: typeList) {
			if (typesAreEqual(parent, type.getParent())) {
				return true;
			}
		}
			return false;
	}

	/**
	 * Returns true if parameter exists in catalog and his parent is null.  
	 * @throws ShopException 
	 * 	 */
	@Override
	public Boolean isRoot(GoodType type) throws ShopException {
		List<GoodType> listOfTypes = getAllTypes();
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
	
	

	@Override
	public List<Good> getAllGoods() {
		return goods.getAll();
	}

	@Override
	public boolean addGood(Good element) {
		try{
			goods.create(element);
		} catch (Exception e){
			//logging error
			return false; 
		}
		return true;
		
	}	
	
	@Override
	public List<GoodType> getLeaves() throws ShopException{
		List<GoodType> result = new ArrayList<GoodType>();
		List<GoodType> typeList = getAllTypes();
		for (GoodType type: typeList){
			if (!hasChildren(type)) {
				result.add(type);
			}
		}
		return result ; 
	}

	@Override
	public GoodType getGoodTypeByName(String name) throws ShopException {
		List<GoodType> typeList = getAllTypes();
		for (GoodType type: typeList){
			if (name.equals(type.getName())){
				return type;
			}			
		}
		return null ;
	}
	
	public Good getGoodByName(String name) {
		List<Good> goodList = goods.getAll();
		for (Good good: goodList){
			if (name.equals(good.getName())){
				return good;
			}			
		}
		return null ;
	}


	public Good getGoodById(Integer goodCode) {
		List<Good> goodList = goods.getAll();
		for (Good good: goodList){
			if (goodCode.equals(good.getId())){
				return good;
			}			
		}
		return null ;
	}

	public boolean deleteGood(Good good) {
		try {
			goods.delete(good);
		} catch (Exception e){
			//logging error
			return false;
		}
		return true ; 
	}

	public String createGood(String name, Integer typeID) throws ShopException {	
		GoodType type = getGoodTypeById(typeID);
		if (type == null){
			return "Such type does not exist.";
		}
		if (getGoodByName(name)!= null){
			return "Good with such name already exists.";
		}
		return goods.create(name, type);
	}

	
	public GoodType getGoodTypeById(Integer typeID) throws ShopException {
		GoodType type ;
		try{
			type = types.read(typeID);
		} catch (MyShopDAOException e){
			throw new ShopException("Cannot access datasource. ");
		}
		return type;
	}

	public boolean deleteGoodType(GoodType goodType) {
		try {
			types.delete(goodType);
		} catch (MyShopDAOException e){
			return false;
		}
		return true;
		}

	public String createType(String name, Integer parentID) throws ShopException {
		GoodType type = getGoodTypeById(parentID);
		if (type == null){
			return "Parent type does not exist.";
		}
		if (getGoodByName(name)!= null){
			return "Type with such name already exists.";
		}
		try{
			GoodType savedObject = GoodType.factory(null, name, type.getId());
			types.create(savedObject);
		} catch (MyShopDAOException e) {
			return "Error occured while creating."; 
		}
		return "Successfully created."; 
	}

	public void updateGood(String newName) {
		// TODO Auto-generated method stub
		
	}	
	
	/*private GoodType getTypeByName(String name){
		GoodType type = null;;
		for (GoodType tempType: types.getAll() ) {
			String tempName = tempType.getName();
			if (tempName.equals(name)) {
				return tempType;
			}
		}
		
		return type;
		
	}*/
}

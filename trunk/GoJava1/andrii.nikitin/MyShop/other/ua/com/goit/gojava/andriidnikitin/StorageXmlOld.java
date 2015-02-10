package ua.com.goit.gojava.andriidnikitin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.andriidnikitin.service.StorageAbstract;

public class StorageXmlOld extends StorageAbstract {
	
	private WarehouseOld warehouseOld;
	private final File fileStorage = new File("resources/DataFile.xml");
	
	public StorageXmlOld() {
		init();
	}
	
	private void init() {
		try {
			warehouseOld = XmlDataBuilderOld.unmarshallWarehouse(fileStorage);
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	
	public void saveChanges() throws JAXBException{
		XmlDataBuilderOld.marshallWarehouse(warehouseOld, fileStorage);
		init();
	}

	@Override
	public List<Category> getCategoryList() {
		Set<Category> categorySet = warehouseOld.getGoodMap().keySet();	
		List<Category> list = new ArrayList<Category>();
		for (Category category : categorySet) {
			list.add(category);
		}
		return list;
	}

	@Override
	public List<Good> getGoodList(Category category) {
		GoodCollection collection;
		try {
			collection = warehouseOld.getGoodMap().get(category);
			} catch (NullPointerException e){
				return null;
			}
		return collection.getList();
	}

	@Override
	public void save(Category category) {
		warehouseOld.getGoodMap().put(category, null);	
	}

	@Override
	public void save(Good good) {
		Map<Category, GoodCollection> map = warehouseOld.getGoodMap();
		GoodCollection list = map.get(good.getCategory());
		if (!list.getList().contains(good)) {
			list.getList().add(good);
			map.put(good.getCategory(), list);
		}
	}
}
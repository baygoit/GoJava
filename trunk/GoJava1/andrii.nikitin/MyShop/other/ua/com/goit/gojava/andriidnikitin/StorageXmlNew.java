package ua.com.goit.gojava.andriidnikitin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.andriidnikitin.service.StorageAbstract;

public class StorageXmlNew extends StorageAbstract {
	
	private WarehouseNew warehouse;
	private final File fileStorage = new File("resources/DataFile.xml");
	
	public StorageXmlNew() {
		init();
	}
	
	private void init() {
		try {
			warehouse = XmlDataBuilderNew.unmarshallWarehouse(fileStorage);
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	
	public void saveChanges() throws JAXBException{
		XmlDataBuilderNew.marshallWarehouse(warehouse, fileStorage);
		init();
	}

	@Override
	public List<Category> getCategoryList() {
		Set<Category> categorySet = warehouse.getGoodMap().keySet();	
		List<Category> list = new ArrayList<Category>();
		for (Category category : categorySet) {
			list.add(category);
		}
		return list;
	}

	@Override
	public List<Good> getGoodList(Category category) {
		List<Good> collection;
		try {
			collection = warehouse.getGoodMap().get(category);
			} catch (NullPointerException e){
				return null;
			}
		return collection;
	}

	@Override
	public void save(Category category) {
		warehouse.getGoodMap().put(category, null);	
	}

	@Override
	public void save(Good good) {
		Map<Category, List<Good>> map = warehouse.getGoodMap();
		List<Good> list = map.get(good.getCategory());
		if (!list.contains(good)) {
			list.add(good);
			map.put(good.getCategory(), list);
		}
	}
}
package ua.com.goit.gojava.andriidnikitin.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Warehouse;

public class StorageXML {/*extends StorageAbstract {
	
	private Warehouse warehouse;
	private final File fileStorage = new File("Hello,World!");
	
	public StorageXML() {
		//init();
	}
	
	public void init() {//TODO: set as private
		try {
			warehouse = DataBuilder.unmarshall(fileStorage);
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	
	public void saveChanges() throws JAXBException{
		DataBuilder.marshall(warehouse, fileStorage);
	}

	@Override
	public List<Category> getCategoryList() {
		return warehouse.getCategoryList();
	}

	@Override
	public void save(Category category) {
		warehouse.getCategoryList().add(category);		
	}

	@Override
	public void save(Good good) {
		warehouse.getGoodList().add(good);
	}

	@Override
	public List<Good> getGoodList(Category category) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
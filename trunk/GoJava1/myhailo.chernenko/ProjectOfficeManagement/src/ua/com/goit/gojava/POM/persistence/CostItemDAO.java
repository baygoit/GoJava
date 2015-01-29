package ua.com.goit.gojava.POM.persistence;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.*;

public class CostItemDAO {//implements GenericDAO<CostItem> {
	
	private static final String CLASS_NAME = "CostItem";
	DAOFactory dataManager;
	
	public CostItemDAO(DAOFactory dataManager) {

		this.dataManager = dataManager;
		
	}

	public CostItem create() {

		CostItem newCostItem = new CostItem();
		dataManager.saveObject(newCostItem, CLASS_NAME);
		return newCostItem;

	}

	public CostItem getByName(String name) {

		CostItem findedCostItem = null;
		List<CostItem> list = getList();
		for(CostItem costItem : list) {
			if(costItem.getName().equals(name)){
				findedCostItem = costItem;
			}
		}

		return findedCostItem;
	}

	public void update(CostItem obj) {
		
		dataManager.saveObject(obj, CLASS_NAME);
		
	}

	public void delete(CostItem obj) {

		dataManager.deleteObject(obj, CLASS_NAME);
		
	}

	public List<CostItem> getList() {
		
		List<DataObject> objectList = dataManager.getObjectList(CLASS_NAME);
		@SuppressWarnings("unchecked")
		List<CostItem> result =  (List<CostItem>)(List<?>) objectList;
		
		return result;
	}


}

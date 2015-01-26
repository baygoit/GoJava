package ua.com.goit.gojava.POM.persistence;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.POM.dataModel.*;

public class CostItemDAO implements GenericDAO<CostItem> {
	
	DAOFactory dataManager;
	
	public CostItemDAO(DAOFactory dataManager) {

		this.dataManager = dataManager;
		
	}

	@Override
	public CostItem create() {

		CostItem newCostItem = new CostItem();
		dataManager.saveObject(newCostItem, "CostItem");
		return newCostItem;

	}

	@Override
	public CostItem getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CostItem obj) {
		
		dataManager.saveObject(obj, "CostItem");
		
	}

	@Override
	public void delete(CostItem obj) {

		dataManager.deleteObject(obj, "CostItem");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CostItem> getList() {
		
		ArrayList<CostItem> result = new ArrayList<CostItem>();
		Object objectList = dataManager.getObjectList("CostItem");
		if (objectList instanceof ArrayList<?> ) {
			
			result = (ArrayList<CostItem>) objectList;
					
		}
		
		return result;
	}


}

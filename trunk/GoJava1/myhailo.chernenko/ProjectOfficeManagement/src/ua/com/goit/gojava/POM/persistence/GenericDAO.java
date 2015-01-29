package ua.com.goit.gojava.POM.persistence;

import java.util.List;

//import ua.com.goit.gojava.POM.dataModel.*;

public class GenericDAO<T extends DataObject> {
	
	private Class<T> classT;
	private DAOFactory dataManager;
	
	public GenericDAO(Class<T> classT, DAOFactory dataManager) {

		this.classT = classT;
		this.dataManager = dataManager;
		
	}

	public T getNewT() {
		
		T newInstance = null;
		try {
			newInstance = classT.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			//e.printStackTrace();
		}
		return newInstance;
	}

	public T create() {

		T newGenericObj = getNewT();
		dataManager.saveObject(newGenericObj, classT.getName());
		return newGenericObj;

	}

	public T getByName(String name) {

		T findedGenericObj = null;
		List<T> list = getList();
		for(T genericObj : list) {
			if(genericObj.getName().equals(name)){
				findedGenericObj = genericObj;
			}
		}

		return findedGenericObj;
	}

	public void update(T obj) {
		
		dataManager.saveObject(obj, classT.getName());
		
	}

	public void delete(T obj) {

		dataManager.deleteObject(obj, classT.getName());
		
	}

	public List<T> getList() {
		
		List<DataObject> objectList = dataManager.getObjectList(classT.getName());
		@SuppressWarnings("unchecked")
		List<T> result =  (List<T>)(List<?>) objectList;
		
		return result;
	}
}

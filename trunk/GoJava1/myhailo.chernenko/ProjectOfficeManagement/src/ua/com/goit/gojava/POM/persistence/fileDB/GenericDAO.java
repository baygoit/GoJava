package ua.com.goit.gojava.POM.persistence.fileDB;

import java.util.List;

//import ua.com.goit.gojava.POM.persistence.abstraction.DataObject;

//import ua.com.goit.gojava.POM.dataModel.*;

public class GenericDAO<T> {
	
	private Class<T> classT;
	private DAOFactory dataManager;
	
	public GenericDAO(Class<T> classT, DAOFactory dataManager) {

		this.classT = classT;
		this.dataManager = dataManager;
		
	}

	public T getNewClassInstance() {
		
		T newInstance = null;
		try {
			newInstance = classT.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			//e.printStackTrace();
		}
		return newInstance;
	}

	public T create() {

		T newGenericObj = getNewClassInstance();
		/*if(newGenericObj instanceof DataObject){
		
			List<T> objectsList = getList();
			long newID = 1;
			if(objectsList.size() != 0) {
				T lastElement = objectsList.get(objectsList.size()-1);
				newID = (lastElement == null) ? 1 : ((DataObject) lastElement).getId()+1;
			}
			((DataObject) newGenericObj).setId(newID);

		}*/
		dataManager.saveObject(newGenericObj, classT.getName());
		return newGenericObj;

	}

	/*public T getByName(String name) {

		T findedGenericObj = null;
		List<T> list = getList();
		for(T genericObj : list) {
			if((genericObj instanceof DataObject)
					&&(((DataObject)genericObj).getName().equals(name))	){
				findedGenericObj = genericObj;
			}
		}

		return findedGenericObj;
	}*/
	
	public void update(T obj) {
		
		dataManager.saveObject(obj, classT.getName());
		
	}

	public void delete(T obj) {

		dataManager.deleteObject(obj, classT.getName());
		
	}

	public List<T> getList() {
		
		List<Object> objectList = dataManager.getObjectList(classT.getName());
		@SuppressWarnings("unchecked")
		List<T> result =  (List<T>)objectList;
		
		return result;
	}

	public T getByID(long id) {
		
		T findedGenericObj = null;
		/*List<T> list = getList();
		for(T genericObj : list) {
			if((genericObj instanceof DataObject)
					&&(((DataObject)genericObj).getId() == id )	){
				findedGenericObj = genericObj;
			}
		}*/

		return findedGenericObj;
	}
}

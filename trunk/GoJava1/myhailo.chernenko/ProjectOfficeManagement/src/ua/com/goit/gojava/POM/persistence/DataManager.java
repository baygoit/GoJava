package ua.com.goit.gojava.POM.persistence;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManager implements DAOFactory{

	private static final String DATA_FILE = "C:\\workspace\\ProjectOfficeManagement.dat";
	
	// for DB imitation:
	private Map<String, List<DataObject>> objectsMap; 
	
	public DataManager() {
		
		readData();
		
	}
	
	public void readData() {
		
		this.objectsMap = new HashMap<String, List<DataObject>>();
		
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			
			fis = new FileInputStream(DATA_FILE);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			
			ois.close();
			fis.close();
					
			if(obj instanceof HashMap<?, ?> ) {
				
				@SuppressWarnings("unchecked")
				HashMap<String, List<DataObject>> objectsMap = (HashMap<String, List<DataObject>>) obj;
				this.objectsMap = objectsMap;
				
			}
		
			
		} catch (IOException | ClassNotFoundException | ConcurrentModificationException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot read program data!");
		
		}
		
	}
	
	public void saveData() {
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			
			fos = new FileOutputStream(DATA_FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objectsMap);
			oos.close();
			fos.close();
				
		} catch (IOException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot save TransactionsStore!");
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public List<DataObject> getObjectList(String key) {

		return objectsMap.get(key);
		
	}
	
	@Override
	public void saveObject(DataObject obj, String key) {

		List<DataObject> objList = objectsMap.get(key);
		int indexOfObj = -1;
		if(objList == null) {		
			objList = new ArrayList<DataObject>();
			objectsMap.put(key, objList);		
		} else {			
			indexOfObj = objList.indexOf(obj);			
		}
		if(indexOfObj == -1) {			
			objList.add(obj);				
		} else {			
			objList.set(indexOfObj, obj);			
		}
		
	}

	
	@Override
	public void deleteObject(DataObject obj, String key) {

		List<DataObject> objList = objectsMap.get(key);
		if(objList != null) {
			int indexOfObj = objList.indexOf(obj);
			if(indexOfObj != -1) {
				objList.remove(indexOfObj);
			}
		}
	}

}

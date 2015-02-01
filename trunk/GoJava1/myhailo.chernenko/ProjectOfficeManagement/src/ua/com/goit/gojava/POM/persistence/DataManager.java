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
	private Map<String, List<Object>> objectsMap = new HashMap<String, List<Object>>(); 
	
	public DataManager() {
		
		readData();
		
	}
	
	public void readData() {
		
		this.objectsMap = new HashMap<String, List<Object>>();
		
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
				HashMap<String, List<Object>> objectsMap = (HashMap<String, List<Object>>) obj;
				this.objectsMap = objectsMap;
				
			}
		
			
		} catch (IOException | ClassNotFoundException | ConcurrentModificationException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot read programs data!");
		
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
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot save programs data!");
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public List<Object> getObjectList(String key) {

		List<Object> objList = objectsMap.get(key);
		if(objList == null) {
			objList = new ArrayList<Object>();
			objectsMap.put(key, objList);	
		}
		
		return objList;
		
	}
	
	@Override
	public void saveObject(Object obj, String key) {

		List<Object> objList = getObjectList(key);
		int indexOfObj = objList.indexOf(obj);			
		if(indexOfObj == -1) {			
			objList.add(obj);				
		} else {			
			objList.set(indexOfObj, obj);			
		}
		
	}

	
	@Override
	public void deleteObject(Object obj, String key) {

		List<Object> objList = getObjectList(key);
		int indexOfObj = objList.indexOf(obj);
		if(indexOfObj != -1) {
			objList.remove(indexOfObj);
		}
	}

}
